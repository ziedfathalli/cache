# API CACHE:

Cette application Spring Boot implémente un **système de cache REST** avec **expiration automatique (TTL de 10s)**.  
Elle utilise **ConcurrentHashMap** et un **scheduler** pour nettoyer les entrées expirées.

## Fonctionnalités :
- ✅ API REST pour ajouter, récupérer et supprimer des valeurs du cache.
- ✅ Expiration automatique des entrées après **10 secondes**.
- ✅ Tests unitaires et tests d'intégration inclus.

## Tester les services avec CURL :
Pour tester les services avec CURL.
- ✅ Ajout d'une valeur dans le cache :
curl -X POST http://localhost:8082/cache/user123 -H "Content-Type: text/plain" -d "HelloWorld"
- ✅ Récupérez la valeur du cache :
curl -X GET http://localhost:8082/cache/user123
- ✅ Supprimez la valeur du cache :
curl -X DELETE http://localhost:8082/cache/user123

