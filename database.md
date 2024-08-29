## Tables
1. Users: Stock les infos sur les clients

|Nom de la colonne|Type de données|Description         |
|-----------------|---------------|--------------------|
|id               |BIGINT         |Clé primaire        |
|user_id          |BIGINT         |Clé primaire        |
|total_amount     |DECIMAL        |Montant total       |
|status           |VARCHAR        |Status              |
|created_at       |TIMESTAMP      |Date de création    |
|updated_at       |TIMESTAMP      |Date de modification|    
--------------------------------------------------------


2. Products: Stock les infos sur les produits

|Nom de la colonne|Type de données|Description         |
|-----------------|---------------|--------------------|
|id               |BIGINT         |Clé primaire        |
|user_id          |BIGINT         |Clé primaire        |
|total_amount     |DECIMAL        |Montant total       |
|status           |VARCHAR        |Status              |
|created_at       |TIMESTAMP      |Date de création    |
|updated_at       |TIMESTAMP      |Date de modification|
--------------------------------------------------------


3. Orders: Stock les infos sur les commandes faites par les clients

|Nom de la colonne|Type de données|Description         |
|-----------------|---------------|--------------------|
|id               |BIGINT         |Clé primaire        |
|user_id          |BIGINT         |Clé primaire        |
|total_amount     |DECIMAL        |Montant total       |
|status           |VARCHAR        |Status              |
|created_at       |TIMESTAMP      |Date de création    |
|updated_at       |TIMESTAMP      |Date de modification|--------------------------------------------------------
4. Order Items: Stock les infos sur les produits inclus dans chaque commande

|Nom de la colonne|Type de données|Description         |
|-----------------|---------------|--------------------|
|id               |BIGINT         |Clé primaire        |
|user_id          |BIGINT         |Clé primaire        |
|total_amount     |DECIMAL        |Montant total       |
|status           |VARCHAR        |Status              |
|created_at       |TIMESTAMP      |Date de création    |
|updated_at       |TIMESTAMP      |Date de modification|
--------------------------------------------------------


## Relations

* `users` -> `orders`:un user peut faire plusieurs commandes
* `orders` -> `order_items`:une commande peut avoir plusieurs items
* `products` -> `order_items`: un produit peut être commandé plusieurs fois dans la journée

`spring.jpa.hiberate.ddl-auto`:
Cette propriété est utilisé pour spécifier la stratégie de génération du schéma de la BDD lors du démarage de l'application. 
Hibernate , l'ORM utilisé par défaut dans spring boot, peut automatiquement créer , mettre à jour, valider ou gérer le schéma de la BDD en fonction de cette propriété.

Voici une explication des différnetes valeurs qu'on peut attribuer:

1. `none`: Désactive la gestion automatique du schéma par Hibernate. Aucune modification du schéma de BDD ne sera affecté au démarrage de l'application
2. `validate`: Hibernate vérifie que  le schéma de la BDD correspond à la structure définie dans les entités JPA. Aucune modification du schéma ne sera effectuée, mais si le schéma est incorrecte ou ne correspond pas, une exception est levée 
3. `update`: Hibernate met à jour le schéma de la BDD pour qu'il corespond aux entités JPA définis. Cela inclut l'ajout de nouvel tables, colonnes existantes.
4. `create`: Hibernate supprime le schéma existant et créé un  nouveau  schéma à partir des entités JPA définies. Cela implique de perdre toutes les données existantes puisque le schéma est recréé à  chaque démarrage de l'application. 
5. `create-drop`: Similaire à `create `, mais avec la particularité que le schéma est supprimée lorsque l'application est  arretée. Cela signifie que la BDD est recréé à chaque démarrage et supprimé à chaque arrêt de l'application.


## Schéma d'une BDD

Le `schema` d'une BDD est une représentation de la structure logique des données,

