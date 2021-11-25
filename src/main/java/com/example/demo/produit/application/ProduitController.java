package com.example.demo.produit.application;

import com.example.demo.produit.application.dto.ProduitIn;
import com.example.demo.produit.application.mapper.ProduitMapper;
import com.example.demo.produit.domaine.dto.Produit;
import com.example.demo.produit.domaine.primaire.port.ProduitService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ResponseHeader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/produits", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
public class ProduitController {

    private final ProduitService produitService;

    @GetMapping(path = "/{id}")
    public Produit getProduit(@ApiParam(example = "1") @PathVariable final Integer id) {
        return produitService.getProduit(id);
    }

    @GetMapping
    public Collection<Produit> getAllProduit() {
        return produitService.getAllProduit();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    @ResponseHeader
    public Produit addProduit(@RequestBody final ProduitIn produit) {
        return produitService.addProduit(ProduitMapper.mapToDto(produit));
    }

    @PutMapping(path = "/{id}")
    public Produit updateProduit(@ApiParam(example = "1") @PathVariable final Integer id,
                                 @RequestBody final ProduitIn produit) {
        return produitService.updateProduit(id, ProduitMapper.mapToDto(produit));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteProduit(@ApiParam(example = "1") @PathVariable final Integer id) {
        produitService.deleteProduit(id);
    }
}
