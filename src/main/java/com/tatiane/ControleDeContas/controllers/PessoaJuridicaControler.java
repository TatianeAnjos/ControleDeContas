package com.tatiane.ControleDeContas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.ControleDeContas.entities.PessoaFisica;
import com.tatiane.ControleDeContas.entities.PessoaJuridica;
import com.tatiane.ControleDeContas.services.PessoaJuridicaService;

@RestController
@RequestMapping(value = "/pessoaJuridica")
public class PessoaJuridicaControler {
	
	@Autowired
	PessoaJuridicaService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<PessoaJuridica> findById(@PathVariable Long id){
		PessoaJuridica pessoaJuridica = service.findById(id);
		return ResponseEntity.ok().body(pessoaJuridica);
	}
	
	/*@GetMapping(value = "/{id}")
	public ResponseEntity<Order>findByIhd(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}*/
}
