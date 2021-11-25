package com.example.demo.produit.infrastructure.mapper;

import com.example.demo.produit.domaine.dto.Produit;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProduitMapper {

    public static Produit mapToDto(final com.example.demo.produit.infrastructure.model.Produit produitEntity) {
        return Produit.builder()
                .id(produitEntity.getId())
                .libelle(produitEntity.getLibelle())
                .categorie(CategorieMapper.mapToDto(produitEntity.getCategorie()))
                .build();
    }

    public static com.example.demo.produit.infrastructure.model.Produit mapToEntity(final Produit produit) {
        return com.example.demo.produit.infrastructure.model.Produit.builder()
                .id(produit.getId())
                .libelle(produit.getLibelle())
                .categorie(CategorieMapper.mapToEntity(produit.getCategorie()))
                .build();
    }
}
