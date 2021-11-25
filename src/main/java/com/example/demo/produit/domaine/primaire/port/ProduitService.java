package com.example.demo.produit.domaine.primaire.port;

import com.example.demo.produit.domaine.dto.Produit;

import java.util.Set;

public interface ProduitService {

    Produit getProduit(final Integer id);

    Set<Produit> getAllProduit();

    Produit addProduit(final Produit produit);

    Produit updateProduit(final Integer id, final Produit produit);

    void deleteProduit(final Integer id);
}
