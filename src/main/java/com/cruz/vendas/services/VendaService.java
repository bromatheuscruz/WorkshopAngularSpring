package com.cruz.vendas.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruz.vendas.model.Venda;
import com.cruz.vendas.repositories.ProdutoRepository;
import com.cruz.vendas.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	VendaRepository vendaRepository;
	@Autowired
	ProdutoRepository produtoRepository;

	public Venda adicionar(Venda venda) {
		venda.setCadastro(LocalDate.now());
		venda.getItens().forEach(i -> {
			i.setVenda(venda);
			i.setProduto(produtoRepository.findById(i.getProduto().getId()).get());
		});

		BigDecimal totalItens = venda.getItens().stream()
				.map(i -> i.getProduto().getValor().multiply(new BigDecimal(i.getQuantidade())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		venda.setTotal(totalItens.add(venda.getFrete()));

		return vendaRepository.save(venda);
	}

}
