package com.example.demo.produit.application.mapper;

import com.example.demo.produit.application.dto.CategorieIn;
import com.example.demo.produit.domaine.dto.Categorie;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CategorieMapper {

    public static Categorie mapToDto(final CategorieIn categorie) {
        return Categorie.builder()
                .libelle(categorie.getLibelle())
                .build();
    }

    public static CategorieIn mapToDtoIn(final Categorie categorie) {
        return CategorieIn.builder()
                .libelle(categorie.getLibelle())
                .build();
    }
}
