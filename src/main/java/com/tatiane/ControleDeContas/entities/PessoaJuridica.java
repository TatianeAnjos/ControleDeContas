package com.tatiane.ControleDeContas.entities;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	private String RazaoSocial;
	
	public PessoaJuridica() {
		
	}

	public PessoaJuridica(Long id_pessoa, String nome, String no_documento,String RazaoSocial) {
		super(id_pessoa,nome,no_documento);
		this.RazaoSocial = RazaoSocial;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}
}
