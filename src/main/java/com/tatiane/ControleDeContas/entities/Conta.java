package com.tatiane.ControleDeContas.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tatiane.ControleDeContas.entities.enums.StatusConta;


@Entity
public class Conta  implements Serializable{
private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_conta;
	
	private String nome_conta;
	private Instant data_hora;
	private Double saldo;
	private Integer statusConta;
	
	
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	@JsonIgnore
	@OneToMany(mappedBy = "conta",fetch=FetchType.EAGER)
	private List <MovimentoConta> movimentoConta = new ArrayList<>();
	
	public Conta() {
		
	}
	
	public Conta(Long id_conta, String nome_conta, Instant data_hora, Double saldo, Pessoa pessoa,StatusConta statusConta) {
		super();
		this.id_conta = id_conta;
		this.nome_conta = nome_conta;
		this.data_hora = data_hora;
		this.saldo = saldo;
		this.pessoa = pessoa;
		setStatusConta(statusConta);
	}

	public Long getId_conta() {
		return id_conta;
	}
	public void setId_conta(Long id_conta) {
		this.id_conta = id_conta;
	}
	public String getNome_conta() {
		return nome_conta;
	}
	public void setNome_conta(String nome_conta) {
		this.nome_conta = nome_conta;
	}
	public Instant getData_hora() {
		return data_hora;
	}
	public void setData_hora(Instant data_hora) {
		this.data_hora = data_hora;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public StatusConta getStatusConta() {
		return StatusConta.valueOf(statusConta);
	}

	public void setStatusConta(StatusConta statusConta) {
		if(statusConta != null) {
			this.statusConta = statusConta.getCode();
		}
	}
	public List<MovimentoConta> getMovimentoConta() {
		return movimentoConta;
	}

	public void setMovimentoConta(List<MovimentoConta> movimentoConta) {
		this.movimentoConta = movimentoConta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_conta == null) ? 0 : id_conta.hashCode());
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
		Conta other = (Conta) obj;
		if (id_conta == null) {
			if (other.id_conta != null)
				return false;
		} else if (!id_conta.equals(other.id_conta))
			return false;
		return true;
	}
	
}
