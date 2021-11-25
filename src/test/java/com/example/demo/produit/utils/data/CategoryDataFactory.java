package com.example.demo.produit.utils.data;

import com.example.demo.produit.application.dto.CategorieIn;
import com.example.demo.produit.domaine.dto.Categorie;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CategoryDataFactory {

    public static final Categorie CATEGORIE_1 = Categorie.builder()
            .id(1)
            .libelle("categorie_1")
            .build();

    public static final CategorieIn CATEGORIE_IN_1 = CategorieIn.builder()
            .libelle(CATEGORIE_1.getLibelle())
            .build();
}
