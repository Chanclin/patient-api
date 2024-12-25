# Patient API

Bienvenue dans le projet **Patient API** pour la gestion des patients de FhunHospital. Ce projet implémente une API RESTful utilisant Java avec Spring Boot et une base de données MongoDB. L'application permet de gérer les informations des patients, y compris leurs contacts (email, mobile, fixe).

## Table des matières

- [Description du projet](#description-du-projet)
- [Fonctionnalités](#fonctionnalités)
- [Technologies utilisées](#technologies-utilisées)
- [Installation](#installation)
- [Utilisation](#utilisation)
- [API Endpoints](#api-endpoints)
- [Contact](#contact)

## Description du projet

Cette API permet de gérer les patients de FhunHospital. Un patient est défini par :

- **Nom**
- **Prénom**
- **Date de naissance**
- **Sexe** (Homme ou Femme)
- **Taille**
- **Poids**
- **Contacts** (email, mobile, fixe)

L'API offre des opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) sur les patients et leurs contacts.

## Fonctionnalités

### Gestion des patients
- **Créer un patient** : Ajouter un nouveau patient avec ses informations de base et ses contacts.
- **Consulter la liste des patients** : Récupérer tous les patients enregistrés.
- **Consulter les détails d’un patient** : Obtenir les informations complètes d’un patient.
- **Modifier un patient** : Mettre à jour les informations d’un patient.
- **Supprimer un patient** : Supprimer un patient et ses contacts associés.

### Gestion des contacts
- **Ajouter un contact** : Ajouter un ou plusieurs contacts à un patient.
- **Modifier un contact** : Mettre à jour un contact spécifique.
- **Supprimer un contact** : Retirer un contact d’un patient.

## Technologies utilisées

- **Backend** : Java, Spring Boot
- **Base de données** : MongoDB
- **API RESTful** : Spring Boot REST Controller

## Installation

1. **Clonez le dépôt** :

   ```bash
   git clone https://github.com/username/patient-api.git
   ```

2. **Installez les dépendances** via Maven (ou votre gestionnaire de dépendances préféré) :

   ```bash
   mvn install
   ```

3. **Configuration de MongoDB** : Assurez-vous que MongoDB est installé et fonctionne sur votre machine.

4. **Démarrer l’application** :

   ```bash
   mvn spring-boot:run
   ```

L'API sera disponible à l'adresse suivante : [http://localhost:8080](http://localhost:8080)

## Utilisation

Vous pouvez maintenant interagir avec l'API en utilisant les points de terminaison définis ci-dessous.

### API Endpoints

#### 1. Créer un patient
- **URL** : `/api/patients`
- **Méthode** : `POST`
- **Body** :
  ```json
  {
    "nom": "Imra",
    "prenom": "Kristian",
    "dateNaissance": "1990-05-15",
    "sexe": "Homme",
    "taille": 180,
    "poids": 75.0,
    "contacts": [
      {
        "type": "EMAIL", "valeur": "Imra.Kristian@example.com"
      },
      {
        "type": "FIXE", "valeur": "0123456789"
      }
    ]
  }
  ```

#### 2. Récupérer la liste des patients
- **URL** : `/api/patients`
- **Méthode** : `GET`

#### 3. Consulter les détails d’un patient
- **URL** : `/api/patients/{id}`
- **Méthode** : `GET`

#### 4. Mettre à jour un patient
- **URL** : `/api/patients/{id}`
- **Méthode** : `PUT`
- **Body** : 
  ```json
  {
    "nom": "Imra",
    "prenom": "Kristian",
    "dateNaissance": "1990-05-15",
    "sexe": "Homme",
    "taille": 180,
    "poids": 75.0,
    "contacts": [
      {
        "type": "EMAIL", "valeur": "Imra.Kristian@example.com"
      },
      {
        "type": "FIXE", "valeur": "0123456789"
      }
    ]
  }
  ```

#### 5. Supprimer un patient
- **URL** : `/api/patients/{id}`
- **Méthode** : `DELETE`

#### 6. Ajouter un contact à un patient
- **URL** : `/api/patients/contacts/{patientId}`
- **Méthode** : `POST`
- **Body** :
  ```json
  {
    "type": "EMAIL",
    "valeur": "Chancelin@example.com"
  }
  ```

#### 7. Ajouter un contact à un patient
- **URL** : `/api/patients/contacts/{patientId}/{contactIndex}`
- **Méthode** : `PUT`
- **Body** :
  ```json
  {
    "type": "EMAIL",
    "valeur": "Chancelin@example.com"
  }
  ```

#### 8. Supprimer un contact
- **URL** : `/api/patients/contacts/{patientId}/{contactIndex}`
- **Méthode** : `DELETE`

## Contact

Si vous avez des questions ou des suggestions, n'hésitez pas à me contacter.

- **Nom** : MAKOSSO Chancelin
- **Email** : chancelinmakosso@gmail.com
- **GitHub** : [Mon profil](https://github.com/Chanclin/)

```
