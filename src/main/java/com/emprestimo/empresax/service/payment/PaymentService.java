package com.emprestimo.empresax.service.payment;

import com.emprestimo.empresax.integration.response.loan.LoanResponse;
import com.emprestimo.empresax.request.payment.PaymentRequest;

public interface PaymentService {

	LoanResponse payAction(PaymentRequest request);
}
