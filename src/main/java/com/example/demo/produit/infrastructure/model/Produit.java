package com.example.demo.produit.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "produit")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String libelle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    // TODO [Amélioration] : @version (optimistic lock)

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, categorie);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Produit produit = (Produit) o;
        return id.equals(produit.id) && libelle.equals(produit.libelle) && categorie.equals(produit.categorie);
    }
}
