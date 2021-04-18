package com.tatiane.ControleDeContas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatiane.ControleDeContas.entities.MovimentoConta;
import com.tatiane.ControleDeContas.repositories.MovimentoContaRepository;

@Service
public class MovimentoContaService {
	
	@Autowired
	private MovimentoContaRepository movimentoContaRepository;
	
	public MovimentoConta findById(Long id) {
		Optional<MovimentoConta> conta = movimentoContaRepository.findById(id);
		return conta.get();
	}

}
