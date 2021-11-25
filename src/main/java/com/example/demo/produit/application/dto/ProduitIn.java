package com.example.demo.produit.application.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProduitIn {
    @ApiModelProperty(example = "produit_2")
    private String libelle;
    private CategorieIn categorie;
}
