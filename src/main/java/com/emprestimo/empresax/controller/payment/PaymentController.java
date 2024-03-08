package com.emprestimo.empresax.controller.payment;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimo.empresax.integration.response.loan.LoanResponse;
import com.emprestimo.empresax.request.payment.PaymentRequest;
import com.emprestimo.empresax.service.payment.PaymentService;

@RestController
@RequestMapping("/pagamento")
public class PaymentController {
	
	@Autowired
	private PaymentService service;

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanResponse create(@RequestBody @Valid PaymentRequest request) {
		
		return service.payAction(request);
	}
}
