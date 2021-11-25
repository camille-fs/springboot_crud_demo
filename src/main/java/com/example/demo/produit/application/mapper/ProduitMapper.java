package com.example.demo.produit.application.mapper;

import com.example.demo.produit.application.dto.ProduitIn;
import com.example.demo.produit.domaine.dto.Produit;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProduitMapper {

    public static Produit mapToDto(final ProduitIn produitEntity) {
        return Produit.builder()
                .libelle(produitEntity.getLibelle())
                .categorie(CategorieMapper.mapToDto(produitEntity.getCategorie()))
                .build();
    }

    public static ProduitIn mapToEntity(final Produit produit) {
        return ProduitIn.builder()
                .libelle(produit.getLibelle())
                .categorie(CategorieMapper.mapToDtoIn(produit.getCategorie()))
                .build();
    }
}
