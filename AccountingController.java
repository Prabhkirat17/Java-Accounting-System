package com.example.accounting.controller;

import com.example.accounting.model.Account;
import com.example.accounting.model.Transaction;
import com.example.accounting.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountingController {
    @Autowired
    private AccountingService accountingService;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountingService.getAllAccounts();
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {
        return accountingService.createAccount(account);
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return accountingService.createTransaction(transaction);
    }
}
