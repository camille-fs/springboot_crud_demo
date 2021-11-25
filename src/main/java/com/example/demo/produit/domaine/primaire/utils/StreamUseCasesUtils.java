package com.example.demo.produit.domaine.primaire.utils;

import com.example.demo.produit.application.dto.ProduitIn;
import com.example.demo.produit.domaine.dto.Categorie;
import com.example.demo.produit.domaine.dto.Produit;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

/**
 * Classe utilitaire pour voir des examples d'utilisation de stream
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class StreamUseCasesUtils {

    public static final String PRODUIT_1_LIBELLE = "produit_1";

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static final class Mapping {
        public static Set<ProduitIn> mapToDto(final Set<Produit> produits) {
            return produits.stream()
                    .map(mapProduitToProduitInFunction())
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        private static Function<Produit, ProduitIn> mapProduitToProduitInFunction() {
            return produit -> ProduitIn.builder()
                    .libelle(produit.getLibelle())
                    .build();
        }

        public static Set<String> mapToOneProperty(final Set<Produit> produits) {
            return produits.stream()
                    .map(Produit::getLibelle)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static final class Filter {
        public static Set<Produit> filterAllByProperty(final Set<Produit> produits) {
            return produits.stream()
                    .filter(hasProduitPrefixe())
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        private static Predicate<Produit> hasProduitPrefixe() {
            return produit -> produit.getLibelle().contains("produit_");
        }

        public static Produit filterOneByProperty(final Set<Produit> produits) {
            return produits.stream()
                    .filter(produit -> produit.getLibelle().equals(PRODUIT_1_LIBELLE))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException(format("Produit %s non trouvé.", PRODUIT_1_LIBELLE)));
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static final class Sort {
        public static Set<Produit> sort(final Set<Produit> produits) {
            return produits.stream()
                    .sorted(Comparator.comparing(Produit::getId))
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        public static Set<Produit> sort2(final Set<Produit> produits) {
            return produits.stream()
                    .sorted(comparingProduitId())
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        private static Comparator<Produit> comparingProduitId() {
            return Comparator.comparing(Produit::getId);
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static final class Group {
        public static Map<Categorie, List<Produit>> groupInMap(final Set<Produit> produits) {
            return produits.stream()
                    .sorted(Comparator.comparing(Produit::getId))
                    .collect(groupingBy(Produit::getCategorie));
        }

        public static Map<Categorie, Set<Produit>> groupInMapSet(final Set<Produit> produits) {
            return produits.stream()
                    .sorted(Comparator.comparing(Produit::getId))
                    .collect(groupingBy(Produit::getCategorie, toSet()));
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static final class Reduce {
        public static BigDecimal addBigDecimalNullable(final BigDecimal... bigdecimals) {
            if (Arrays.stream(bigdecimals).allMatch(Objects::isNull)) {
                return null;
            }
            return Arrays.stream(bigdecimals)
                    .filter(Objects::nonNull)
                    .reduce(ZERO, BigDecimal::add);
        }

        public static Tarif reduce(final Set<Tarif> tarifs) {
            return tarifs.stream()
                    .reduce(Reduce::reduceT1T2)
                    .orElse(null);
        }

        public static Tarif reduceT1T2(final Tarif p1, final Tarif p2) {
            return Tarif.builder()
                    .libelle(p1.getLibelle().concat(p2.getLibelle()))
                    .prix1(p1.getPrix1().add(p1.getPrix1()))
                    .build();
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static final class FlatMap {
        public static Set<Produit> recupererTarifsMensuelMembres(final Set<Offre> offres) {
            return offres.stream()
                    .flatMap(offre -> offre.getProduits().stream())
                    .sorted(Comparator.comparing(Produit::getId))
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        public static Set<Produit> flatMap2(final Set<Produit> produitsOffre1, final Set<Produit> produitsOffre2) {
            return Stream.of(produitsOffre1, produitsOffre2)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }
    }
}
