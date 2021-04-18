package com.tatiane.ControleDeContas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.ControleDeContas.DTO.ContaDTO;
import com.tatiane.ControleDeContas.entities.Conta;
import com.tatiane.ControleDeContas.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaControler {
	
	@Autowired
	ContaService contaService;

	@GetMapping(value = "{id}")
	public ResponseEntity<Conta> findById(@PathVariable Long id){
		Conta conta = contaService.findById(id);
		return ResponseEntity.ok().body(conta);
	}
	@PostMapping
	public ResponseEntity<ContaDTO> insert(@RequestBody ContaDTO conta){
		ContaDTO c = contaService.insertConta(conta);
		return ResponseEntity.ok().body(c);
	}
	@PutMapping("{valor}/{id}/{descricao}/inserirSaldo")
	public ResponseEntity<String> insertSaldo(@PathVariable Double valor,@PathVariable Long id,@PathVariable String descricao){
			Conta conta = contaService.insertSaldo(valor, id, descricao);
			if (conta != null) {
				return ResponseEntity.ok().body("Transação realizada com sucesso!!!");
			}else{
				return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ops! Valor não permitido para esse tipo de conta");
			}
	}

}
