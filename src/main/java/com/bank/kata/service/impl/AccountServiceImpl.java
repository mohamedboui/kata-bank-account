package com.bank.kata.service.impl;

import com.bank.kata.domain.Account;
import com.bank.kata.domain.Client;
import com.bank.kata.domain.Operation;
import com.bank.kata.domain.enumeration.TypeOperation;
import com.bank.kata.dto.AccountDTO;
import com.bank.kata.mapper.AccountDTOMapper;
import com.bank.kata.repository.AccountRepository;
import com.bank.kata.repository.ClientRepository;
import com.bank.kata.repository.OperationRepository;
import com.bank.kata.service.AccountService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountDTOMapper accountDTOMapper;
    private final ClientRepository clientRepository;

    public AccountServiceImpl(AccountRepository accountRepository,
                              AccountDTOMapper accountDTOMapper,
                              ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.accountDTOMapper = accountDTOMapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public Account deposit(Long id, BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException();
        }

        Account account = accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        BigDecimal newBalance = account.getAmount().add(amount);
        Operation operation = new Operation(TypeOperation.DEPOSIT, amount, newBalance, account);
        account.getOperations().add(operation);
        account.setAmount(newBalance);
        return accountRepository.save(account);
    }

    @Override
    public Account withdrawal(Long id, BigDecimal amount) {

        Account account = accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (account.getAmount().compareTo(amount) == -1) {
            throw new IllegalArgumentException();
        }

        BigDecimal newBalance = account.getAmount().subtract(amount);
        Operation operation = new Operation(TypeOperation.WITHDRAWAL, amount, newBalance, account);
        account.getOperations().add(operation);
        account.setAmount(newBalance);
        return accountRepository.save(account);
    }

    @Override
    public Account createAccount(AccountDTO accountDTO) {
        Account account = accountDTOMapper.toDomainObject(accountDTO);
        Client client = clientRepository.findById(account.getClient().getId()).orElseThrow(EntityNotFoundException::new);
        account.setClient(client);
       return accountRepository.saveAndFlush(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

}
