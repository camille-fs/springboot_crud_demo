package com.example.demo.produit.domaine.primaire.utils;

import com.example.demo.produit.domaine.dto.Produit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
class Offre {
    private Integer id;
    private String libelle;
    private Set<Produit> produits;
}
