package com.emprestimo.empresax.integration.model.person;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.emprestimo.empresax.integration.model.enumeration.IdentifierType;
import com.emprestimo.empresax.model.common.BasicModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class PersonModel extends BasicModel<PersonModel>{

	private static final long serialVersionUID = 7256528509853650080L;

	@Column(nullable = false, name = "identificador")
	public String identifier;
	
	@Column(nullable = false, name = "nome")
	public String name;
	
	@Column(nullable = false, name = "data_nascimento")
	public LocalDate dateBirth;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "tipo_identificador")
	public IdentifierType identifierType;
	
	@Column(nullable = false, name = "valor_minimo_mensal")
	public BigDecimal monthlyMinimum;
	
	@Column(nullable = false, name = "valor_maximo_emprestimo")
	public BigDecimal maximumLoanAmount;
}
