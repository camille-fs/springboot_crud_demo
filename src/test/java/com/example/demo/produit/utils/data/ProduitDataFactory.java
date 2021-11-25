package com.example.demo.produit.utils.data;

import com.example.demo.produit.application.dto.ProduitIn;
import com.example.demo.produit.domaine.dto.Produit;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Set;

import static com.example.demo.produit.utils.data.CategoryDataFactory.CATEGORIE_1;
import static com.example.demo.produit.utils.data.CategoryDataFactory.CATEGORIE_IN_1;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProduitDataFactory {

    public static final Produit PRODUIT_1 = Produit.builder().id(1)
            .libelle("produit_1")
            .categorie(CATEGORIE_1)
            .build();

    public static final Produit PRODUIT_2 = Produit.builder().id(2)
            .libelle("produit_2")
            .categorie(CATEGORIE_1)
            .build();

    public static final ProduitIn PRODUIT_IN_1 = ProduitIn.builder()
            .libelle(PRODUIT_1.getLibelle())
            .categorie(CATEGORIE_IN_1)
            .build();

    public static final Set<Produit> PRODUITS = Set.of(PRODUIT_1, PRODUIT_2);
}
