package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Produto;
import com.example.easynotes.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produto")
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    @PostMapping("/produtos")
    public Produto createProduto(@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/produtos/{id}")
    public Produto getProdutoById(@PathVariable(value = "id") Long produtoId) {
        return produtoRepository.findById(produtoId)
                .orElseThrow(() -> new ResourceNotFoundException("Produto", "id", produtoId));
    }

    @PutMapping("/produto/{id}")
    public Produto updateProduto(@PathVariable(value = "id") Long produtoId,
                                           @Valid @RequestBody Produto ProdutoDetails) {

    	Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new ResourceNotFoundException("Produto", "id", produtoId));

        produto.setNome_produto(ProdutoDetails.getNome_produto());

        Produto updatedProduto = produtoRepository.save(produto);
        return updatedProduto;
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable(value = "id") Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new ResourceNotFoundException("Produto", "id", produtoId));

        produtoRepository.delete(produto);

        return ResponseEntity.ok().build();
    }
}
