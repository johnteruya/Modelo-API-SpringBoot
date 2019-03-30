package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.Produto;
import com.example.easynotes.repository.ProdutoRepository;

@RestController
@RequestMapping("/api-produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	
	@GetMapping("/listarTodos")
    public List<Produto> getAllProducts() {
        return produtoRepository.findAll();
    }

    @PostMapping("/inserirProduto")
    public Produto createNote(@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    
    
    @GetMapping("/listarPorNome")
    public List<Produto> getProdutoByDescription(String description) {
		return produtoRepository.getProdutoByDescription(description);
	}

	
}
