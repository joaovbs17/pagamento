package com.emprestimo.empresax.integration.mapper.loan;

import org.springframework.stereotype.Component;

import com.emprestimo.empresax.integration.model.loan.LoanModel;
import com.emprestimo.empresax.integration.response.loan.LoanResponse;

@Component
public class LoanModelMapper {
	
	public LoanResponse response(LoanModel model) {
		
		return LoanResponse.builder()
				.loanValue(model.loanValue)
				.numberInstallments(model.numberInstallments)
				.paymentStatus(model.paymentStatus)
				.creationDate(model.creationDate)
				.build();
	}
}
