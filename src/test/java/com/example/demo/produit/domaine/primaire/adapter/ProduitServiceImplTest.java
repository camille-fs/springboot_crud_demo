package com.example.demo.produit.domaine.primaire.adapter;

import com.example.demo.produit.domaine.dto.Produit;
import com.example.demo.produit.domaine.secondaire.port.ProduitRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static com.example.demo.produit.utils.data.ProduitDataFactory.PRODUITS;
import static com.example.demo.produit.utils.data.ProduitDataFactory.PRODUIT_1;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ProduitServiceImplTest {

    @InjectMocks
    private ProduitServiceImpl produitService;

    @Mock
    private ProduitRepository produitRepository;

    @Test
    void getProduit() {
        Mockito.when(produitRepository.getProduit(PRODUIT_1.getId())).thenReturn(PRODUIT_1);
        final Produit produitResult = produitService.getProduit(PRODUIT_1.getId());
        assertThat(produitResult).isEqualTo(PRODUIT_1);
    }

    @Test
    void getAllProduit() {
        Mockito.when(produitRepository.getAllProduit()).thenReturn(PRODUITS);
        final Set<Produit> produitsResult = produitService.getAllProduit();
        assertThat(produitsResult).isEqualTo(PRODUITS);
    }

    @Test
    void addProduit() {
    }

    @Test
    void updateProduit() {
    }

    @Test
    void deleteProduit() {
        Assertions.assertDoesNotThrow(() -> produitService.deleteProduit(PRODUIT_1.getId()));
    }
}
