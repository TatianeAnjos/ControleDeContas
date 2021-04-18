package com.tatiane.ControleDeContas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tatiane.ControleDeContas.entities.PessoaFisica;

public interface  PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

}
