package com.tatiane.ControleDeContas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tatiane.ControleDeContas.entities.Conta;

public interface  ContaRepository extends JpaRepository<Conta, Long> {

}
