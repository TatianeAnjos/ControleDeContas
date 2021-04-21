package com.tatiane.ControleDeContas.entities.enums;
public enum StatusConta {
	
	ATIVA(1),
	BLOQUEADA(2);
	
	private int code;
	
	private StatusConta(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public static StatusConta valueOf(int code) {
		for(StatusConta value: StatusConta.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Order Status Code");
	}
}

