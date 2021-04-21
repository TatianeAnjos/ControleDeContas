package com.tatiane.ControleDeContas.services;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
		
	//	SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
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
	@SuppressWarnings("deprecation")
	public List<MovimentoConta> ConsultarExtratoPorData(Conta conta, Date dt_inicio, Date dt_fim) {
		//dt_inicio.toInstant();
		List <MovimentoConta> mov_conta = conta.getMovimentoConta();
		List<MovimentoConta>filtro_mov_conta = new ArrayList<>();
		for (MovimentoConta movimento: mov_conta) {
			if(movimento.getData_hora().getDate() >= dt_inicio.getDate() 
					&& movimento.getData_hora().getDate() <= dt_fim.getDate()) {
				filtro_mov_conta.add(movimento);
			}
		}		
		return filtro_mov_conta;
	}

}
