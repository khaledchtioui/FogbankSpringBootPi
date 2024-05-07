package com.fogbank.springsecurity.services.forum.implServiceForum;

import com.fogbank.springsecurity.Repository.forum.PublicationInitialeRepository;
import com.fogbank.springsecurity.entities.forum.PublicationInitiale;
import com.fogbank.springsecurity.entities.forum.ReponsePublication;
import com.fogbank.springsecurity.services.forum.IPublicationInitialeService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PublicationInitialeService implements IPublicationInitialeService {

    private PublicationInitialeRepository publicationInitialeRepository;

    @Override
    public List<PublicationInitiale> chargerTous() {
        return publicationInitialeRepository.findByVisibilityTrue();
    }

    @Override
    public PublicationInitiale ajouter(PublicationInitiale publicationInitiale) {
        publicationInitiale.setVue(0);
        publicationInitiale.setVisibility(true);
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(ZoneId.systemDefault()).toInstant();
        publicationInitiale.setDatePublication(Date.from(instant));

        return publicationInitialeRepository.save(publicationInitiale);
    }
    // Méthode pour vérifier si le commentaire est toxique
    public boolean isToxic(String analysisResult) {
        // Analyser le résultat de l'analyse de toxicité pour déterminer si le commentaire est toxique
        // Vous devrez extraire le score de toxicité du résultat JSON et le comparer à un seuil
        // Si le score de toxicité est supérieur à 0.5, retourne true (toxique), sinon retourne false (non toxique)

        // Analysez le résultat JSON pour extraire le score de toxicité
        // Par exemple, vous pouvez utiliser une bibliothèque JSON comme Jackson ou Gson pour analyser la réponse JSON
        // Voici un exemple d'utilisation de Gson pour extraire le score de toxicité (à adapter selon votre structure JSON) :
        JsonObject jsonObject = new Gson().fromJson(analysisResult, JsonObject.class);
        JsonObject attributeScores = jsonObject.get("attributeScores").getAsJsonObject();
        JsonObject toxicityScore = attributeScores.get("TOXICITY").getAsJsonObject();
        double score = toxicityScore.get("summaryScore").getAsJsonObject().get("value").getAsDouble();

        // Comparer le score de toxicité au seuil
        if (score > 0.3) {
            // Si le score de toxicité est supérieur à 0.5, le commentaire est toxique
            // Vous pouvez afficher un message ou effectuer d'autres actions nécessaires
            System.out.println("Error adding post : Post contain bad words");
            return true;
        } else {
            // Sinon, le commentaire n'est pas toxique
            return false;
        }
    }

    @Override
    public void supprimer(PublicationInitiale publicationInitiale) {
        publicationInitiale.setVisibility(false);
        publicationInitialeRepository.save(publicationInitiale);
    }

    public void supprimer(Optional<PublicationInitiale> publicationInitiale) {
        if (publicationInitiale.isPresent()) { // Vérifie si l'optionnel contient une valeur
            PublicationInitiale publicationInitiale1 = publicationInitiale.get(); // Extrait l'objet de réponse de l'optionnel
            publicationInitiale1.setVisibility(false); // Modifie la visibilité de la réponse à false
            publicationInitialeRepository.save(publicationInitiale1); // Enregistre la modification
        } else {
            // Gérer le cas où l'optionnel est vide (pas de réponse de publication à supprimer)
            // Vous pouvez lancer une exception ou gérer ce cas selon vos besoins
            throw new IllegalArgumentException("Publication optionnel vide");
        }
    }


    @Override
    public PublicationInitiale modifier(PublicationInitiale publicationInitiale) {
        return publicationInitialeRepository.save(publicationInitiale);

    }


    public Optional<PublicationInitiale> afficherDetails(int id){
        Optional<PublicationInitiale> publicationInitiale=publicationInitialeRepository.findById(id);
        if (publicationInitiale.isPresent()) {
            PublicationInitiale publicationInitialee = publicationInitiale.get();
            publicationInitialee.setVue(publicationInitialee.getVue()+1);
            publicationInitialeRepository.save(publicationInitialee);
        }

        // Filtrer les réponses pour ne conserver que celles avec visibility true
        List<ReponsePublication> filteredReponses = publicationInitiale.get().getReponsePublicationList().stream()
                .filter(reponse -> reponse.isVisibility())
                .collect(Collectors.toList());

        // Mettre à jour la liste de réponses de la publication initiale avec les réponses filtrées
        publicationInitiale.get().setReponsePublicationList(filteredReponses);



        return publicationInitiale;

    }
}
