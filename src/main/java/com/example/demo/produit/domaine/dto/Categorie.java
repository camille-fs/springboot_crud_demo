package com.example.demo.produit.domaine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Categorie {
    private Integer id;
    private String libelle;
}
