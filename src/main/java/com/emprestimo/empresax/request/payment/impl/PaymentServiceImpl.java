package com.emprestimo.empresax.request.payment.impl;

import java.util.Optional;

import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.emprestimo.empresax.exception.BaseException;
import com.emprestimo.empresax.integration.mapper.loan.LoanModelMapper;
import com.emprestimo.empresax.integration.model.enumeration.StatusPayment;
import com.emprestimo.empresax.integration.model.loan.LoanModel;
import com.emprestimo.empresax.integration.repository.loan.LoanReposiotry;
import com.emprestimo.empresax.integration.response.loan.LoanResponse;
import com.emprestimo.empresax.request.payment.PaymentRequest;
import com.emprestimo.empresax.service.payment.PaymentService;

import jakarta.transaction.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private LoanReposiotry loanReposiotry;
	
	@Autowired
	private LoanModelMapper loanModelMapper;

	@Override
	@Transactional
	public LoanResponse payAction(PaymentRequest request) {
		
		LoanModel loanModel = findLoanModel(request.id);
		
		checkPayment(loanModel);
	
		loanModel.paymentStatus = StatusPayment.PAGO.getStatus();
		
		loanModel = loanReposiotry.save(loanModel);
				
		return loanModelMapper.response(loanModel);
	}
	
	private void checkPayment(LoanModel loanModel) {
		
		if(loanModel.paymentStatus.equals(StatusPayment.PAGO.getStatus())) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "Esse emprestimo já foi pago.");
		}
	}

	private LoanModel findLoanModel(Long id) {
		
		if(isNull(id)) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "Informe o ID do emprestimo.");
		}
		
		Optional<LoanModel> model = loanReposiotry.findById(id);

		if(!model.isPresent()) {
			throw new BaseException(HttpStatus.NOT_FOUND, "Emprestimo não encontrado.");
		}
		
		return model.get();
	}

}
