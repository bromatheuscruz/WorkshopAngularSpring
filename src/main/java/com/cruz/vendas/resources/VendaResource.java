package com.cruz.vendas.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruz.vendas.model.Venda;
import com.cruz.vendas.repositories.VendaRepository;
import com.cruz.vendas.services.VendaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/vendas")
public class VendaResource {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private VendaService vendaService;

	@GetMapping
	public List<Venda> listar() {
		return vendaRepository.findAll();
	}
		
	@PostMapping
	public Venda adicionar(@RequestBody @Valid Venda venda) {
		return vendaService.adicionar(venda);
	}
}
