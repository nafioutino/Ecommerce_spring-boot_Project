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
|updated_at       |TIMESTAMP      |Date de modification|



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
5. Products: Stock les infos sur les produits disponibles

|Nom de la colonne|Type de données|Description         |
|-----------------|---------------|--------------------|
|id               |BIGINT         |Clé primaire        |
|name             |VARCHAR        |Nom du produit      |
|description      |VARCHAR        |Description         |
|price            |DECIMAL        |Prix                |
|created_at       |TIMESTAMP      |Date de création    |
|updated_at       |TIMESTAMP      |Date de modification|


## Relations

* `users` -> `orders`:un user peut faire plusieurs commandes
* `orders` -> `order_items`:une commande peut avoir plusieurs items
* `products` -> `order_items`: un produit peut être commandé plusieurs fois dans la journée
*  

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

Le `schema` d'une BDD est une représentation de la structure logique des données, incluant les tables , les colonnes, les relations entre les tables et les contraintes . Il définit comment les données sont organisées, interconnectées,et géréés pour assurer leur cohérence et intégrité.

`@Bas`: définit un mapping entre une entité JPA et une table de la BDD. Il permet de spécifier le nom de la table, les colonnes, les relations entre les tables et les contraintes. 
`@Column`: définit un mapping entre une propriété d'une entité JPA et une colonne de la table correspondante. Il permet de spécifier le nom de la colonne, le type de données, les contraintes, et les options de mapping. 
`@Id`: définit la colonne qui sert d'identifiant unique pour chaque enregistrement de la table. 
`@GeneratedValue`: définit la stratégie de génération de la valeur de l'identifiant unique. 
`@OneToOne`: définit une relation de type 1-1 entre deux entités. 
`@OneToMany`: définit une relation de type 1-N entre deux entités. 
`@ManyToOne`: définit une relation de type N-1 entre deux entités. 
`@ManyToMany`: définit une relation de type N-N entre deux entités. 
`@JoinTable`: définit la table de jointure pour une relation de type N-N. 
`@JoinColumn`: définit la colonne de jointure pour une relation de type N-1 ou 1-N.
`@Table`: définit le nom de la table dans la base de données.
`@Data`: génère automatiquement les getters, setters, equals, hashCode, et toString pour les propriétés de la classe.
`@Getter`: génère automatiquement les getters pour les propriétés de la classe.
`@Setter`: génère automatiquement les setters pour les propriétés de la classe.
`@NoArgsConstructor`: génère automatiquement un constructeur sans arguments pour la classe.
`@AllArgsConstructor`: génère automatiquement un constructeur avec arguments pour la classe.
`@Entity`: indique que la classe est une entité JPA et doit être persistée dans la base de données.
`@Transactional`: indique que la méthode est une transactionnelle et doit être exécutée dans un contexte de transaction.
`mappedBy`: indique le nom de la propriété de l'autre entité qui définit la relation inverse.

|id|order_id|product_id|quantity|price|creted_at|updated_at|
|---|---|---|---|---|---|---|
|1|1|1|1|10.00|2022-01-01 10:00:00|2022-01-01 10:00:00|
|1|1|1|2|10.00|2022-01-01 10:00:00|2022-01-01 10:00:00|
|2|1|2|1|20.00|2022-01-01 10:00:00|2022-01-01 10:00:00|
|3|2|1|1|10.00|2022-01-02 11:00:00|2022-01-02 11:00:00|