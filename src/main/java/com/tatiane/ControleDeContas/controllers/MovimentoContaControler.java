package com.tatiane.ControleDeContas.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.ControleDeContas.entities.Conta;
import com.tatiane.ControleDeContas.entities.MovimentoConta;
import com.tatiane.ControleDeContas.services.ContaService;
import com.tatiane.ControleDeContas.services.MovimentoContaService;

@RestController
@RequestMapping(value = "/movimentoContas")
public class MovimentoContaControler {

	@Autowired
	MovimentoContaService service;

	@Autowired
	ContaService contaService;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<MovimentoConta> findById(@PathVariable Long id) {
		MovimentoConta conta = service.findById(id);
		return ResponseEntity.ok().body(conta);
	}

	@GetMapping(value = "{id_conta}/{dt_inicio}/{dt_fim}")
	public ResponseEntity<List<MovimentoConta>> ConsultarExtrato(@PathVariable Long id_conta, 
			@PathVariable String dt_inicio, @PathVariable String dt_fim) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		Date data_inicio = new Date(dt_inicio);//;sdf.parse(dt_inicio);
		Date data_fim = new Date(dt_inicio);//sdf.parse(dt_fim);

		Conta conta = contaService.findById(id_conta);
		List<MovimentoConta> mov_conta = service.ConsultarExtratoPorData(conta, data_inicio, data_fim);
		return ResponseEntity.ok().body(mov_conta);

		
	}
}
