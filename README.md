Pour tester les services avec CURL
Ajout d'une valeur dans le cache :
curl -X POST http://localhost:8080/cache/user123 -H "Content-Type: text/plain" -d "HelloWorld"
Récupérez la valeur du cache :
curl -X GET http://localhost:8080/cache/user123
Supprimez la valeur du cache :
curl -X DELETE http://localhost:8080/cache/user123

# Système de Cache avec TTL (Spring Boot)

Cette application Spring Boot implémente un **système de cache REST** avec **expiration automatique (TTL de 10s)**.  
Elle utilise **ConcurrentHashMap** (sans Caffeine) et un **scheduler** pour nettoyer les entrées expirées.

## Fonctionnalités :
- ✅ API REST pour ajouter, récupérer et supprimer des valeurs du cache.
- ✅ Expiration automatique des entrées après **10 secondes**.
- ✅ Tests unitaires et tests d'intégration inclus.

## Exécuter l'application :
1. Clonez ce repository :  
   ```sh
   git clone <repo_url>
   cd <repo_directory>

