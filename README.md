Pour tester les services avec CURL
Ajout d'une valeur dans le cache :
curl -X POST http://localhost:8080/cache/user123 -H "Content-Type: text/plain" -d "HelloWorld"
Récupérez la valeur du cache :
curl -X GET http://localhost:8080/cache/user123
Supprimez la valeur du cache :
curl -X DELETE http://localhost:8080/cache/user123
