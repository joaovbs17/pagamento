package com.emprestimo.empresax.integration.repository.loan;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emprestimo.empresax.integration.model.loan.LoanModel;

@Repository
public interface LoanReposiotry extends CrudRepository<LoanModel, Long>{

}
