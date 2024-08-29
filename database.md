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