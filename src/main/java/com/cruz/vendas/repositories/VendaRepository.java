package com.cruz.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cruz.vendas.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {}
