package com.tatiane.ControleDeContas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.tatiane.ControleDeContas.entities.enums.StatusConta;
import com.tatiane.ControleDeContas.services.ContaService;
import com.tatianeanjos.services.exceptions.DataIntegrityException;

@RestController
@RequestMapping(value = "/contas")
public class ContaControler {

	@Autowired
	ContaService contaService;

	@GetMapping(value = "{id}/consultaConta")
	public ResponseEntity<Conta> findById(@PathVariable Long id) {
		Conta conta = contaService.findById(id);
		return ResponseEntity.ok().body(conta);
	}

	@PostMapping
	public ResponseEntity<ContaDTO> insert(@RequestBody ContaDTO conta) {
		ContaDTO c = contaService.insertConta(conta);
		return ResponseEntity.ok().body(c);
	}

	@PutMapping("{valor}/{id}/{descricao}/inserirSaldo")
	public ResponseEntity<String> insertSaldo(@PathVariable Double valor, @PathVariable Long id,
			@PathVariable String descricao) {
		String retorno = contaService.insertSaldo(valor, id, descricao);
		if (retorno.equals("Sucesso!")) {
			return ResponseEntity.ok().body(retorno);
		} else {
			throw new DataIntegrityException(retorno);
		}
	}

	@PutMapping("{id_origem}/{id_destino}/{valor}/{descricao}/realizarTransferencia")
	public ResponseEntity<String> realizarTranferencia(@PathVariable Long id_origem, @PathVariable Long id_destino,
			@PathVariable Double valor, @PathVariable String descricao) {
		String retorno = contaService.realizarTranferencia(id_origem, id_destino, valor, descricao);
		if (retorno.equals("Sucesso!"))
			return ResponseEntity.ok().body(retorno);
		else {
			throw new DataIntegrityException(retorno);
		}
	}

	@GetMapping(value = "{id}/consultaSaldo")
	public ResponseEntity<ContaDTO> consultaSaldo(@PathVariable Long id) {
		Conta c = contaService.consultaSaldo(id);
		return ResponseEntity.ok().body(new ContaDTO(c));
	}
	
	@PutMapping("{id_conta}/{status}/AlterarStatus")
	public ResponseEntity<ContaDTO> alterarStatus(@PathVariable Long id_conta,@PathVariable int status){
		ContaDTO contaDTO = contaService.AlteraStatusConta(id_conta, StatusConta.valueOf(status));
		return ResponseEntity.ok().body(contaDTO);
	}

}
