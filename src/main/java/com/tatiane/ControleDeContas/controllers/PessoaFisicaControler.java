package com.tatiane.ControleDeContas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.ControleDeContas.entities.PessoaFisica;
import com.tatiane.ControleDeContas.services.PessoaFisicaService;

@RestController
@RequestMapping(value = "/pessoaFisica")
public class PessoaFisicaControler {
	
	@Autowired
	PessoaFisicaService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<PessoaFisica> findById(@PathVariable Long id){
		PessoaFisica pessoaFisica = service.findById(id);
		return ResponseEntity.ok().body(pessoaFisica);
	}
	
	/*@GetMapping(value = "/{id}")
	public ResponseEntity<Order>findByIhd(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}*/
}
