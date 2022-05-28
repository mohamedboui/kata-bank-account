package com.bank.kata.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.bank.kata.domain.enumeration.TypeOperation;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "operation")

public class Operation extends AuditableEntity {
	
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    private Long id;
	
	@Column(name = "type_operation")
	@Enumerated(EnumType.STRING)
	private TypeOperation typeOperation;
	
	@Column(name = "montant")
	private BigDecimal amount;
	
	@Column(name = "balance")
	private BigDecimal balance;
	
	@ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference
	private Account account;

	public Operation(TypeOperation typeOperation, BigDecimal amount, BigDecimal balance,
			Account account) {
		this.typeOperation = typeOperation;
		this.amount = amount;
		this.balance = balance;
		this.account = account;
	}

	public Operation() {}



	public TypeOperation getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(TypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}


	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
