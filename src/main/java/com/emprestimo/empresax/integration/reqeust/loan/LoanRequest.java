package com.emprestimo.empresax.integration.reqeust.loan;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanRequest {
	
	@JsonProperty("identificadorPessoa")
	public String identifier;

	@JsonProperty("valorEmprestimo")
	public BigDecimal loanValue;
	
	@JsonProperty("numeroParcelas")
	public Integer numberInstallments;
}
