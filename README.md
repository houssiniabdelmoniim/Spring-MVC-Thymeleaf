# Activité Pratique N°3 — Spring MVC, Thymeleaf et Spring Security
 
## Objectif
 
Développer une application web JEE de gestion de produits avec Spring Boot, Spring Data JPA, Thymeleaf et Spring Security : affichage, ajout avec validation et suppression de produits, le tout protégé par une authentification et des rôles.
 
## Technologies
 
- Spring Boot, Spring MVC
- Spring Data JPA et H2 (MySQL disponible comme driver)
- Thymeleaf, Thymeleaf Layout Dialect, Thymeleaf Extras Spring Security
- Spring Security, Spring Validation
- Bootstrap (WebJars)
- Lombok
## Structure
 
```
src/main/java/org/example/springmvcthymeleaf
├── SpringMvcThymeleafApplication.java   Point d'entrée + jeu de données initial
├── entities/Product.java                Entité JPA avec contraintes de validation
├── repository/ProductRepository.java    Interface Spring Data
├── sec/SecurityConfig.java              Configuration de la sécurité
└── web/ProductController.java           Contrôleur Spring MVC
src/main/resources/templates
├── layout1.html        Template commun (barre de navigation, Bootstrap)
├── products.html       Liste des produits
├── new-product.html    Formulaire d'ajout
├── login.html          Page d'authentification
└── notAuthorized.html  Page d'accès refusé
```
 
## Fonctionnalités
 
- Affichage de la liste des produits
- Ajout d'un produit avec validation du formulaire (nom de 3 à 50 caractères, prix positif ou nul, quantité d'au moins 1)
- Suppression d'un produit
- Template unique avec Thymeleaf Layout et Bootstrap
- Authentification par formulaire personnalisé, déconnexion
## Sécurité
 
Les utilisateurs sont définis en mémoire, avec mots de passe chiffrés par BCrypt.
 
| Utilisateur | Rôles | Mot de passe |
|---|---|---|
| `user1` | USER | `1234` |
| `user2` | USER | `1234` |
| `admin` | USER, ADMIN | `1234` |
 
- Les routes `/user/**` sont réservées au rôle USER, les routes `/admin/**` au rôle ADMIN (annotations `@PreAuthorize`).
- Les boutons « New Product » et « Delete » ne s'affichent que pour un administrateur.
- Un utilisateur sans droit suffisant est redirigé vers `/notAuthorized`.
- La protection CSRF est active : les formulaires Thymeleaf incluent automatiquement le jeton.
Ces comptes sont destinés au développement uniquement.
 
## Exécution
 
```bash
mvn spring-boot:run
```
 
- Application : `http://localhost:8084`
- Console H2 : `http://localhost:8084/h2-console` (JDBC URL : `jdbc:h2:mem:products-db`)
Trois produits sont créés au démarrage.
 
## Concepts illustrés
 
- Architecture MVC (contrôleur, modèle, vue)
- Moteur de templates Thymeleaf et mise en page par layout
- Validation avec Bean Validation et `BindingResult`
- Authentification, autorisation par rôles, chiffrement BCrypt, CSRF
- Sécurité au niveau des méthodes (`@PreAuthorize`) et des vues (`sec:authorize`)
