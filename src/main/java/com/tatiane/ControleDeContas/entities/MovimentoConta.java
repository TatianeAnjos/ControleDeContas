package com.tatiane.ControleDeContas.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovimentoConta implements Serializable {
private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_movimento_conta;
	
	private String operacao;
	private Instant data_hora;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="id_conta")
	private Conta conta;
	
	public MovimentoConta() {
		
	}

	public MovimentoConta(Long id_movimento_conta, String operacao, Instant data_hora, String descricao, Conta conta) {
		super();
		this.id_movimento_conta = id_movimento_conta;
		this.operacao = operacao;
		this.data_hora = data_hora;
		this.descricao = descricao;
		this.conta = conta;
	}

	public Long getId_movimento_conta() {
		return id_movimento_conta;
	}

	public void setId_movimento_conta(Long id_movimento_conta) {
		this.id_movimento_conta = id_movimento_conta;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public Instant getData_hora() {
		return data_hora;
	}

	public void setData_hora(Instant data_hora) {
		this.data_hora = data_hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_movimento_conta == null) ? 0 : id_movimento_conta.hashCode());
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
		MovimentoConta other = (MovimentoConta) obj;
		if (id_movimento_conta == null) {
			if (other.id_movimento_conta != null)
				return false;
		} else if (!id_movimento_conta.equals(other.id_movimento_conta))
			return false;
		return true;
	}
	
}
