package com.tatiane.ControleDeContas.DTO;

import java.io.Serializable;

import com.tatiane.ControleDeContas.entities.Conta;

public class ContaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String nome_conta;
	private Long id_pessoa;
	
	public ContaDTO() {
		
	}
	
	public ContaDTO(String nome_conta, Long id_pessoa) {
		super();
		this.nome_conta = nome_conta;
		this.id_pessoa = id_pessoa;
	}
	public ContaDTO(Conta entity) {
		nome_conta = entity.getNome_conta();
		id_pessoa = entity.getPessoa().getId_pessoa();
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
	
}
