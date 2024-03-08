package com.emprestimo.empresax.integration.model.enumeration;

public enum StatusPayment {

	PAGO("Pago"),
	NAO_PAGO("Não Pago");
	
	private final String status;
	
	StatusPayment(String status){
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
