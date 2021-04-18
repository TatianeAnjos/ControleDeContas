package com.tatiane.ControleDeContas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatiane.ControleDeContas.entities.PessoaJuridica;
import com.tatiane.ControleDeContas.repositories.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {
	
	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;
	
	public PessoaJuridica findById(Long id) {
		Optional<PessoaJuridica> pessoa = pessoaJuridicaRepository.findById(id);
		return pessoa.get();
	}

}
