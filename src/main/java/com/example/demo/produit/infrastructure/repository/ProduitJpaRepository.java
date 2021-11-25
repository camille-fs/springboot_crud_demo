package com.example.demo.produit.infrastructure.repository;

import com.example.demo.produit.infrastructure.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProduitJpaRepository extends JpaRepository<Produit, Integer> {

    Optional<Produit> findByLibelle(String libelle);

    @Query("select p from Produit p where p.libelle = :libelle")
    Optional<Produit> findByLibelleQuery(String libelle);
}
