package com.emprestimo.empresax.request.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

	@JsonProperty("emprestimoId")
	public Long id;
}
