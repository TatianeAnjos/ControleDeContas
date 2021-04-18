package com.tatiane.ControleDeContas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public abstract class Pessoa implements Serializable{
private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pessoa;
	
	private String nome;
	private String no_documento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pessoa")
	public List<Conta> contas = new ArrayList<>();
	
	public Pessoa() {
		
	}

	public Pessoa(Long id_pessoa, String nome, String no_documento) {
		super();
		this.id_pessoa = id_pessoa;
		this.nome = nome;
		this.no_documento = no_documento;
	}

	public Long getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Long id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNo_documento() {
		return no_documento;
	}

	public void setNo_documento(String no_documento) {
		this.no_documento = no_documento;
	}
	
	public List<Conta> getContas() {
		return contas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_pessoa == null) ? 0 : id_pessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id_pessoa == null) {
			if (other.id_pessoa != null)
				return false;
		} else if (!id_pessoa.equals(other.id_pessoa))
			return false;
		return true;
	}
	
}
