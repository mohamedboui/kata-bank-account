package com.bank.kata.service;

import com.bank.kata.domain.Account;
import com.bank.kata.dto.AccountDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

	Account deposit(Long id, BigDecimal amount);

	Account withdrawal(Long id, BigDecimal amount);

	Account createAccount(AccountDTO accountDTO);

	List<Account> getAllAccounts();

}
