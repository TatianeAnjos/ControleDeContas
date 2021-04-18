package com.tatiane.ControleDeContas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.ControleDeContas.entities.Conta;
import com.tatiane.ControleDeContas.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaControler {
	
	@Autowired
	ContaService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<Conta> findById(@PathVariable Long id){
		Conta conta = service.findById(id);
		return ResponseEntity.ok().body(conta);
	}
	
	/*@GetMapping(value = "/{id}")
	public ResponseEntity<Order>findByIhd(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}*/
}
