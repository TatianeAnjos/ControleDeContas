package com.tatiane.ControleDeContas.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatiane.ControleDeContas.entities.Conta;
import com.tatiane.ControleDeContas.entities.MovimentoConta;
import com.tatiane.ControleDeContas.entities.enums.TipoMovimentoConta;
import com.tatiane.ControleDeContas.repositories.MovimentoContaRepository;

@Service
public class MovimentoContaService {
	
	@Autowired
	private MovimentoContaRepository movimentoContaRepository;
	
	public MovimentoConta findById(Long id) {
		Optional<MovimentoConta> mvConta = movimentoContaRepository.findById(id);
		return mvConta.get();
	}
	
	public MovimentoConta insertMovConta(TipoMovimentoConta tipo_mov_conta,String descricao, Conta conta, Double valor) {
		Date data_atual = new Date();
		MovimentoConta mv = new MovimentoConta();
		mv.setData_hora(data_atual);
		mv.setTipoMovimentoConta(tipo_mov_conta);
		mv.setDescricao(descricao);
		mv.setConta(conta);
		mv.setValor(valor);
		movimentoContaRepository.save(mv);
		return mv;
	}
	
}
