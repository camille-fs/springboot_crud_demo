package com.example.demo.produit.application;

import com.example.demo.commun.core.config.AbstractControllerTest;
import com.example.demo.produit.domaine.dto.Produit;
import com.example.demo.produit.domaine.primaire.port.ProduitService;
import com.example.demo.produit.utils.data.ProduitDataFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Set;

import static com.example.demo.produit.utils.data.ProduitDataFactory.PRODUIT_1;
import static com.example.demo.produit.utils.data.ProduitDataFactory.PRODUIT_2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(ProduitController.class)
class ProduitControllerTest extends AbstractControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean // Used with Spring boot
    ProduitService produitService;

    @Test
    void getProduit() throws Exception {
        Mockito.when(produitService.getProduit(PRODUIT_1.getId()))
                .thenReturn(PRODUIT_1);

        mvc.perform(MockMvcRequestBuilders.get("/produits/{id}", PRODUIT_1.getId()))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(PRODUIT_1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.libelle").value(PRODUIT_1.getLibelle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.categorie.libelle").value(PRODUIT_1.getCategorie().getLibelle()));
    }

    @Test
    void getAllProduit() throws Exception {
        Mockito.when(produitService.getAllProduit())
                .thenReturn(ProduitDataFactory.PRODUITS);

        mvc.perform(MockMvcRequestBuilders.get("/produits"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(result -> {
                    final Set<Produit> produits = getMvcResultAsSet(result, Produit.class);
                    assertThat(produits).isEqualTo(ProduitDataFactory.PRODUITS);
                });
    }

    @Test
    void addProduit() throws Exception {
        Mockito.when(produitService.addProduit(any()))
                .thenReturn(PRODUIT_2);

        final String body = mapper.writeValueAsString(ProduitDataFactory.PRODUIT_IN_1);

        mvc.perform(MockMvcRequestBuilders.post("/produits")
                        .contentType(APPLICATION_JSON_VALUE)
                        .content(body))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.libelle").value(PRODUIT_2.getLibelle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.categorie.libelle").value(PRODUIT_2.getCategorie().getLibelle()));
    }

    @Test
    void updateProduit() throws Exception {
        Mockito.when(produitService.updateProduit(anyInt(), any()))
                .thenReturn(PRODUIT_1);

        final String body = mapper.writeValueAsString(ProduitDataFactory.PRODUIT_IN_1);

        mvc.perform(MockMvcRequestBuilders.put("/produits/{id}", PRODUIT_1.getId())
                        .contentType(APPLICATION_JSON_VALUE)
                        .content(body))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(PRODUIT_1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.libelle").value(PRODUIT_1.getLibelle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.categorie.libelle").value(PRODUIT_1.getCategorie().getLibelle()));
    }

    @Test
    void deleteProduit() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/produits/{id}", PRODUIT_1.getId()))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
