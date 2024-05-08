const {google} = require('googleapis');

API_KEY = 'AIzaSyDA9MaX8dKNoVQ0evdAAF3Ca_hcJ2GUe2o';
DISCOVERY_URL =
    'https://commentanalyzer.googleapis.com/$discovery/rest?version=v1alpha1';

google.discoverAPI(DISCOVERY_URL)
    .then(client => {
        const analyzeRequest = {
            comment: {
                text: process.argv[2], // Le commentaire à analyser est passé en argument
            },
            requestedAttributes: {
                TOXICITY: {},
            },
        };

        client.comments.analyze(
            {
                key: API_KEY,
                resource: analyzeRequest,
            },
            (err, response) => {
                if (err) throw err;
                console.log(JSON.stringify(response.data, null, 1));
            });
    })
    .catch(err => {
        throw err;
    });