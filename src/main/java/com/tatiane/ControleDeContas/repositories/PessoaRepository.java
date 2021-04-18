package com.tatiane.ControleDeContas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tatiane.ControleDeContas.entities.Pessoa;

public interface  PessoaRepository extends JpaRepository<Pessoa, Long> {

}
