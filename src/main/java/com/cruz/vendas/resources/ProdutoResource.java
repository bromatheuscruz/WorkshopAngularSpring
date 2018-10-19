package com.cruz.vendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruz.vendas.model.Produto;
import com.cruz.vendas.repositories.ProdutoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

}
