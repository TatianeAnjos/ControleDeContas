package com.tatiane.ControleDeContas.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "F")
public class PessoaFisica extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	private Date dt_nascimento;
	
	public PessoaFisica() {
		
	}

	public PessoaFisica(Long id_pessoa, String nome, String no_documento,String tipo_pessoa, Date dt_nascimento) {
		super(id_pessoa,nome,no_documento, tipo_pessoa);
		this.dt_nascimento = dt_nascimento;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	

}
