package com.tatiane.ControleDeContas.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tatiane.ControleDeContas.entities.enums.TipoMovimentoConta;

@Entity
public class MovimentoConta implements Serializable {
private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_movimento_conta;
	
	private TipoMovimentoConta tipoMovimentoConta;
	private Date data_hora;
	private String descricao;
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name="id_conta")
	private Conta conta;
	
	public MovimentoConta() {
		
	}

	public MovimentoConta(Long id_movimento_conta, TipoMovimentoConta tipoMovimentoConta, Date data_hora, String descricao, Conta conta,  Double valor) {
		super();
		this.id_movimento_conta = id_movimento_conta;
		this.setTipoMovimentoConta(tipoMovimentoConta);
		this.data_hora = data_hora;
		this.descricao = descricao;
		this.conta = conta;
		this.valor = valor;
	}

	public Long getId_movimento_conta() {
		return id_movimento_conta;
	}

	public void setId_movimento_conta(Long id_movimento_conta) {
		this.id_movimento_conta = id_movimento_conta;
	}

	public Date getData_hora() {
		return data_hora;
	}

	public void setData_hora(Date data_hora) {
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoMovimentoConta getTipoMovimentoConta() {
		return tipoMovimentoConta;
	}

	public void setTipoMovimentoConta(TipoMovimentoConta tipoMovimentoConta) {
		this.tipoMovimentoConta = tipoMovimentoConta;
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
