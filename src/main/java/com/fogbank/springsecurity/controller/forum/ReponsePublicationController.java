package com.fogbank.springsecurity.controller.forum;

import com.fogbank.springsecurity.entities.forum.PublicationInitiale;
import com.fogbank.springsecurity.entities.forum.ReponsePublication;
import com.fogbank.springsecurity.services.forum.implServiceForum.PublicationInitialeService;
import com.fogbank.springsecurity.services.forum.implServiceForum.ReponsePublicationService;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ReponsePublication")
@AllArgsConstructor
public class ReponsePublicationController {


        public ReponsePublicationService reponsePublicationService;
        private PublicationInitialeService publicationInitialeService;

    @GetMapping("")
        public List<ReponsePublication> ChargerTous() {
            return this.reponsePublicationService.chargerTous();
        }

        @DeleteMapping("/{id}")
        public void supprimerReponsePublication(@PathVariable Long id) {


            this.reponsePublicationService.supprimer(reponsePublicationService.chargerParId(id));
        }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<ReponsePublication> ajouterReponsePublication(@RequestBody ReponsePublication reponsePublication){

            try {
                // Construire la requête d'analyse du post
                JsonObject requestObject = new JsonObject();
                JsonObject commentObject = new JsonObject();
                commentObject.addProperty("text", reponsePublication.getDescription());
                requestObject.add("comment", commentObject);
                JsonObject requestedAttributes = new JsonObject();
                requestedAttributes.addProperty("TOXICITY", "{}");
                requestObject.add("requestedAttributes", requestedAttributes);

                // Envoyer la requête à votre script Node.js
                String nodeScriptPath = "C:\\Users\\ghassen\\Desktop\\BackGit\\src\\main\\java\\com\\fogbank\\springsecurity\\utils\\PerspectiveAnalyzer.js";
                ProcessBuilder processBuilder = new ProcessBuilder("node", nodeScriptPath, requestObject.toString());
                Process process = processBuilder.start();

                // Lire la réponse de votre script Node.js
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                // Attendre la fin du processus
                int exitCode = process.waitFor();

                // Vérifier le code de sortie
                if (exitCode != 0) {
                    throw new RuntimeException("Erreur lors de l'exécution du script Node.js");
                }

                String analysisResult = result.toString();
                // Vérifier si le post est toxique
                if (publicationInitialeService.isToxic(analysisResult)) {
                    // Si toxique, retourner un message d'avertissement
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

                } else {
                    // Sinon, ajouter le post
                    this.reponsePublicationService.ajouter(reponsePublication) ;
                    return ResponseEntity.ok(reponsePublication);



                }
            } catch (InterruptedException  | IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }


        @PutMapping("")
        public ReponsePublication modifierReponsePublication(@RequestBody ReponsePublication reponsePublication){

            return   this.reponsePublicationService.modifier(reponsePublication) ;

        }
    }

