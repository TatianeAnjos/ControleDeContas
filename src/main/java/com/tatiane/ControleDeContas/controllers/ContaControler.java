package com.tatiane.ControleDeContas.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tatiane.ControleDeContas.DTO.ContaDTO;
import com.tatiane.ControleDeContas.entities.Conta;
import com.tatiane.ControleDeContas.entities.MovimentoConta;
import com.tatiane.ControleDeContas.entities.enums.StatusConta;
import com.tatiane.ControleDeContas.services.ContaService;
import com.tatianeanjos.services.exceptions.DataIntegrityException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API_REST Controle de Contas")
@RestController
@RequestMapping(value = "/contas")
public class ContaControler {

	@Autowired
	ContaService contaService;

	@ApiOperation(value = "Retorna os dados da conta do ID informado")
	@GetMapping(value = "{id}/consultaConta")
	public ResponseEntity<Conta> findById(@PathVariable Long id) {
		Conta conta = contaService.findById(id);
		return ResponseEntity.ok().body(conta);
	}

	@ApiOperation(value = "Cria uma nova conta")
	@PostMapping(("/criarConta"))
	public ResponseEntity<ContaDTO> insert(@RequestBody ContaDTO conta) {
		ContaDTO c = contaService.insertConta(conta);
		return ResponseEntity.ok().body(c);
	}

	@ApiOperation(value = "Insere crédito na conta informada")
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

	@ApiOperation(value = "Realiza uma transferência bancária")
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

	@ApiOperation(value = "Consulta o saldo da conta informada")
	@GetMapping(value = "{id}/consultaSaldo")
	public ResponseEntity<ContaDTO> consultaSaldo(@PathVariable Long id) {
		Conta c = contaService.consultaSaldo(id);
		return ResponseEntity.ok().body(new ContaDTO(c));
	}
	
	@ApiOperation(value = "Bloqueia ou desbloqueia uma conta")
	@PutMapping("{id_conta}/{status}/alterarStatus")
	public ResponseEntity<ContaDTO> alterarStatus(@PathVariable Long id_conta,@PathVariable int status){
		ContaDTO contaDTO = contaService.alteraStatusConta(id_conta, StatusConta.valueOf(status));
		return ResponseEntity.ok().body(contaDTO);
	}

	@ApiOperation(value = "Consulta movimento de uma conta com base em um período")
	@GetMapping(value = "{id}/{data_inicio}/{data_fim}/consultarMovimentos")
	public ResponseEntity<List<MovimentoConta>> consultaMovimentoConta(@PathVariable Long id ,
			@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date data_inicio,
			@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date data_fim){
		Conta conta = contaService.findById(id);
		List<MovimentoConta> list = contaService.movimentosContaPorData(conta, data_inicio, data_fim);
		return ResponseEntity.ok().body(list);
    }
}
