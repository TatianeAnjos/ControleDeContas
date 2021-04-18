package com.tatiane.ControleDeContas.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	private Date dt_nascimento;
	
	public PessoaFisica() {
		
	}

	public PessoaFisica(Long id_pessoa, String nome, String no_documento,Date dt_nascimento) {
		super(id_pessoa,nome,no_documento);
		this.dt_nascimento = dt_nascimento;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	

}
