package com.tatiane.ControleDeContas.DTO;

import java.io.Serializable;

import com.tatiane.ControleDeContas.entities.Conta;
import com.tatiane.ControleDeContas.entities.enums.StatusConta;

public class ContaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome_conta;
	private Long id_pessoa;
	private Double saldo;
	private StatusConta statusConta;
	public ContaDTO() {

	}

	public ContaDTO(Long id, String nome_conta, Long id_pessoa, Double saldo,StatusConta statusConta) {
		super();
		this.setId(id);
		this.nome_conta = nome_conta;
		this.id_pessoa = id_pessoa;
		this.saldo = saldo;
		this.statusConta = statusConta;
	}

	public ContaDTO(Conta entity) {
		id = entity.getId_conta();
		nome_conta = entity.getNome_conta();
		id_pessoa = entity.getPessoa().getId_pessoa();
		saldo = entity.getSaldo();
		statusConta = entity.getStatusConta();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_conta() {
		return nome_conta;
	}

	public void setNome_conta(String nome_conta) {
		this.nome_conta = nome_conta;
	}

	public Long getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Long id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public StatusConta getStatusConta() {
		return statusConta;
	}

	public void setStatusConta(StatusConta statusConta) {
		this.statusConta = statusConta;
	}

}
