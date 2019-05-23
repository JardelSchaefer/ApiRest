package com.gProdutos.apiRest.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gProdutos.apiRest.models.Produto;
import com.gProdutos.apiRest.repository.repositoryProduto;
import java.util.ArrayList;

//Recebe requisições http.
@RestController
@RequestMapping("/api")
public class produtoResources {

	// Possibilita usar os metodos repositoryProduto
    @Autowired
    private repositoryProduto rp;

    @GetMapping("/produtos")
    public ArrayList<Produto> listaProdutos() {
        Iterable<Produto> listaProdutos = rp.findAll();

        return (ArrayList<Produto>) listaProdutos;
    }

    @GetMapping("/produtos/{id}")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
        return rp.findOne(id);
    }

    @PostMapping("/addProduto")
    public Produto cadastraProduto(@RequestBody @Valid Produto produto) {
        return rp.save(produto);
    }

    @DeleteMapping("/produto/{id}")
    public long deletaProduto(@PathVariable(value = "id") long id) {
        rp.delete(id);
        return id;
    }

}
