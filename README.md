# Serveur cinemaEpul

### Projet web services

Alexis Jamal & Yohan Malbranque - Polytech 5A INFO - 2020/2021

Cette application Java réalisée avec le framework Spring JPA est la moitié du projet web services.
Elle correpond au serveur qui fait office d'API pour le client, réalisé en React-Native (mobile cross-plateform) qui est donc l'autre moitié du projet.

C'est un serveur Tomcat possédant une architecture MVC, utilisant les JPA Entities de Spring ainsi que les Repositories.
Il y a égalemment des controlleurs et des services classique à l'architecture MVC.

Coté serveur, on peut manier 5 classes d'objets différents : 
* acteur
* catégorie
* film
* personnage
* realisateur

On peut afficher, modifier, ajouter et supprimer chacune de ses entités (CRUD).
Pour cela il existe une route pour chaque action :
* /{objet}/list en méthode GET, pour obtenir tous les objets de la classe,
* /{objet}/{id} en méthode GET, pour obtenir un objet particulier de la classe,
* /{objet}/update en méthode PUT, pour modifier un objet particulier de la classe,
* /{objet}/add en méthode POST, pour ajouter un objet de la classe,
* /{objet}/{id} en méthode DELETE, pour supprimer un objet particulier de la classe.

Pour l'objet film il existe une route en plus pour répondre aux demandes du sujet :
* /film/search?realisateur={idRea}&categorie={idCat}

Cela marche avec un seul des paramètres ou les 2 ensembles.

Coté base de données, l'objet personnage à été modifié pour permettre à un acteur de posséder plusieurs roles dans un même film(ce qui arrive de temps en temps).
Un script sql est donc à disposition à la racine du projet pour avoir une base de données compatible avec le serveur.

Enfin le fichier application.properties permet de modifier l'accès à la base de données ainsi que les identifiants à celle-ci (username,password,url).
Il faudra donc surement les modifier pour faire marcher la connection à la DB.

Liens Git des 2 parties du projet Web Services :
* Serveur : https://github.com/yohanmlbr/cinema-server
* Client : https://github.com/AlexisJamal/cinemaEpul