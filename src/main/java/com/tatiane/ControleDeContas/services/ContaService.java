package com.tatiane.ControleDeContas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatiane.ControleDeContas.entities.Conta;
import com.tatiane.ControleDeContas.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	public Conta findById(Long id) {
		Optional<Conta> conta = contaRepository.findById(id);
		return conta.get();
	}

}
