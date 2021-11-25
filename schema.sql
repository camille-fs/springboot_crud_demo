## INIT DB SCHEMA
DROP TABLE IF EXISTS `produit`;
DROP TABLE IF EXISTS `categorie`;

CREATE TABLE `categorie`
(
    id      int          not null AUTO_INCREMENT,
    libelle varchar(100) not null,
    PRIMARY KEY (id)
);

CREATE TABLE `produit`
(
    id           int          not null AUTO_INCREMENT,
    libelle      varchar(100) not null,
    categorie_id int          not null,
    FOREIGN KEY (categorie_id) REFERENCES `categorie` (id),
    PRIMARY KEY (id)
);
