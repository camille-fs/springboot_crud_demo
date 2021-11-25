package com.example.demo.produit.infrastructure.mapper;

import com.example.demo.produit.domaine.dto.Categorie;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CategorieMapper {

    public static Categorie mapToDto(final com.example.demo.produit.infrastructure.model.Categorie categorie) {
        return Categorie.builder()
                .id(categorie.getId())
                .libelle(categorie.getLibelle())
                .build();
    }

    public static com.example.demo.produit.infrastructure.model.Categorie mapToEntity(final Categorie categorie) {
        return com.example.demo.produit.infrastructure.model.Categorie.builder()
                .id(categorie.getId())
                .libelle(categorie.getLibelle())
                .build();
    }
}
