package com.bank.kata.rest;

import com.bank.kata.domain.Account;
import com.bank.kata.dto.AccountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bank.kata.service.AccountService;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountResource {

    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping("/deposit")
    public ResponseEntity<Account> depositToAccount(@RequestParam("id") Long id, @RequestParam("amount") BigDecimal amount) {

        Account account = accountService.deposit(id, amount);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PutMapping("/withdrawal")
    public ResponseEntity<Account> withdrawalFromAccount(@RequestParam("id") Long id, @RequestParam("amount") BigDecimal amount) {

        Account account = accountService.withdrawal(id, amount);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO) {

        Account account = accountService.createAccount(accountDTO);

        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Account>> findAllAccount() {

        List<Account> accounts = accountService.getAllAccounts();

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
