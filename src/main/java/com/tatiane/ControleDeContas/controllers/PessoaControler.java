package com.tatiane.ControleDeContas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.ControleDeContas.entities.Pessoa;
import com.tatiane.ControleDeContas.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaControler {
	
	@Autowired
	PessoaService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id){
		Pessoa pessoaFisica = service.findById(id);
		return ResponseEntity.ok().body(pessoaFisica);
	}
	
	/*@GetMapping(value = "/{id}")
	public ResponseEntity<Order>findByIhd(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}*/
}
