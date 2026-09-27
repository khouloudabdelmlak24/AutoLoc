# AutoLoc

Plateforme de gestion de location de véhicules multi-agences (UP ASI, ESPRIT).

## Objectifs du projet
- Gérer les véhicules, les agences et les réservations
- Suivre les locations, retours et paiements
- Exposer une API REST (Spring Boot, MySQL)

## Acteurs identifiés
- **Client** : recherche un véhicule, réserve, consulte ses locations
- **Agent d'agence** : enregistre les locations et retours, gère les véhicules
- **Responsable d'agence** : supervise l'agence, valide les opérations, consulte les statistiques
- **Administrateur** : gère les agences, les utilisateurs et la configuration globale

## Stack technique
Java 17, Spring Boot, Spring Data JPA, Maven, MySQL, Postman, IntelliJ IDEA