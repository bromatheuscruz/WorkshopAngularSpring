package com.cruz.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cruz.vendas.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
