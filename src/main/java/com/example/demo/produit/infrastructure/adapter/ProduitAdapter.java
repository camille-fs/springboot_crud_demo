package com.example.demo.produit.infrastructure.adapter;

import com.example.demo.produit.domaine.dto.Produit;
import com.example.demo.produit.domaine.secondaire.port.ProduitRepository;
import com.example.demo.produit.infrastructure.mapper.ProduitMapper;
import com.example.demo.produit.infrastructure.repository.ProduitJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.example.demo.produit.infrastructure.mapper.ProduitMapper.mapToDto;
import static com.example.demo.produit.infrastructure.mapper.ProduitMapper.mapToEntity;
import static java.lang.String.format;
import static java.util.stream.Collectors.toCollection;

@Repository
@RequiredArgsConstructor
public class ProduitAdapter implements ProduitRepository {

    private final ProduitJpaRepository produitJpaRepository;

    @Override
    public Produit getProduit(final Integer id) {
        return produitJpaRepository.findById(id)
                .map(ProduitMapper::mapToDto)
                // TODO [Amélioration] : voir pour renvoyer erreur plus spécifique (ou 404)
                .orElseThrow(() -> new RuntimeException(format("Produit non trouvé %s", id)));
    }

    @Override
    public Set<Produit> getAllProduit() {
        return produitJpaRepository.findAll().stream()
                .map(ProduitMapper::mapToDto)
                .collect(toCollection(LinkedHashSet::new));
    }

    @Override
    public Produit addProduit(final Produit produit) {
        return mapToDto(produitJpaRepository.save(mapToEntity(produit)));
    }

    @Override
    public Produit updateProduit(final Integer id, final Produit produit) {
        produit.setId(id);
        return mapToDto(produitJpaRepository.save(mapToEntity(produit)));
    }

    @Override
    public void deleteProduit(final Integer id) {
        produitJpaRepository.deleteById(id);
    }
}
