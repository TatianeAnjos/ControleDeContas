package com.tatiane.ControleDeContas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
