# Application *My GBF V2*

##  **Développeur**
JATOB Nicolas

##  **Présentation**

Cette application fut créé à l'issu d'un projet de programmation mobile de 4ème année.
Direct successeur de l'application réalisé pour mon projet de 3ème année.

Cette nouvelle version de l'application implémente une page de connexion et d'inscription à l'application.
Les données sont stocké localement et simplement utilisé pour se connecté et accédé au coeur de l'application, soit une liste affichant quelques personnages du jeu [Granblue Fantasy](https://granbluefantasy.jp/en/).

## Prérequis
- [Android Studio](https://developer.android.com/studio/) installé
- Récupérer la branch master

## Eléments implémentés
- Utilisation du language Kotlin
- Architecture MVVM
- Clean Architecture
- Utilisation d'une réelle BDD
- Appel WebService à une API Rest
- Affichage d'une liste
- Ecran avec les détails d'un élément
- Ecran de détails scrollable
- Couleur de background adaptatif en fonction du personnage sélectionné
- GitFlow

## Fonctionnalités:
### Login Screen
- Ecran de connexion à l'aide d'un compte existant :
  >>Le cas des champs vides est supporté
  
![screen_login](https://user-images.githubusercontent.com/62256154/103322141-5824ad00-4a80-11eb-9073-3bec3ff62ead.PNG)

### Signup Screen
- Ecran de création de compte (accessible depuis l'écran de connexion):
  >>Le cas des champs vides est supporté
  
![screen_signup](https://user-images.githubusercontent.com/62256154/103321534-763cde00-4a7d-11eb-8520-3cbf7ad7ff7d.PNG)

### Liste d'éléments
- Listes de personnages à l'aide d'une recycler view aprés s'être correctement connecté ou enregistré:

![screen_list](https://user-images.githubusercontent.com/62256154/103321536-776e0b00-4a7d-11eb-81d2-6417914c161a.PNG)

### Ecran de détails
- Aprés avoir cliqué sur l'un des personnages, les détails de celui-ci s'affiche à l'écran:

![screen_detail_1](https://user-images.githubusercontent.com/62256154/103321540-7937ce80-4a7d-11eb-9dd9-c0c2ef262e10.PNG)
![screen_detail_2](https://user-images.githubusercontent.com/62256154/103321543-7b9a2880-4a7d-11eb-981b-19c6b89c0583.PNG)

- Le retour à la page précédente se fera avec le bouton retour du téléphone
