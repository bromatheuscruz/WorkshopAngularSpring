package com.cruz.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cruz.vendas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
