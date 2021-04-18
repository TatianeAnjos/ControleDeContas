package com.tatiane.ControleDeContas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tatiane.ControleDeContas.entities.MovimentoConta;

public interface  MovimentoContaRepository extends JpaRepository<MovimentoConta, Long> {

}
