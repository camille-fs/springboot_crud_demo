package com.example.demo.produit.domaine.primaire.adapter;

import com.example.demo.produit.domaine.dto.Produit;
import com.example.demo.produit.domaine.primaire.port.ProduitService;
import com.example.demo.produit.domaine.secondaire.port.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    @Override
    public Produit getProduit(final Integer id) {
        return produitRepository.getProduit(id);
    }

    @Override
    public Set<Produit> getAllProduit() {
        return produitRepository.getAllProduit();
    }

    @Override
    public Produit addProduit(final Produit produit) {
        return produitRepository.addProduit(produit);
    }

    @Override
    public Produit updateProduit(final Integer id, final Produit produit) {
        return produitRepository.updateProduit(id, produit);
    }

    @Override
    public void deleteProduit(final Integer id) {
        produitRepository.deleteProduit(id);
    }
}
