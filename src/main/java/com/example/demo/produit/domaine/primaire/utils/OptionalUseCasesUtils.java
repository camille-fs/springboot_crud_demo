package com.example.demo.produit.domaine.primaire.utils;

import com.example.demo.produit.domaine.dto.Produit;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * Classe utilitaire pour voir des exemples d'utilisation d'optional
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class OptionalUseCasesUtils {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static final class OfNullable {

        public static Produit ofNullable(final Produit produit) {
            return Optional.ofNullable(produit)
                    .map(p -> Produit.builder()
                            .libelle(p.getLibelle())
                            .build())
                    .orElse(null);
        }

    }
}
