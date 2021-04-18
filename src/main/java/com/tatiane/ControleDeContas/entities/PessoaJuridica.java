package com.tatiane.ControleDeContas.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "J")
public class PessoaJuridica extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	private String RazaoSocial;
	
	public PessoaJuridica() {
		
	}

	public PessoaJuridica(Long id_pessoa, String nome, String no_documento,String tipo_pessoa, String RazaoSocial) {
		super(id_pessoa,nome,no_documento, tipo_pessoa);
		this.RazaoSocial = RazaoSocial;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}
}
