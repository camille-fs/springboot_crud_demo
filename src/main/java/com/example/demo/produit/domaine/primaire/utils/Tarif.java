package com.example.demo.produit.domaine.primaire.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
class Tarif {
    private Integer id;
    private String libelle;
    private BigDecimal prix1;
    private BigDecimal prix2;
}
