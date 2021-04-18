package com.tatiane.ControleDeContas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatiane.ControleDeContas.entities.PessoaFisica;
import com.tatiane.ControleDeContas.repositories.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {
	
	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	
	public PessoaFisica findById(Long id) {
		Optional<PessoaFisica> pessoa = pessoaFisicaRepository.findById(id);
		return pessoa.get();
	}

}
