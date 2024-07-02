package com.example.accounting.service;

import com.example.accounting.model.Account;
import com.example.accounting.model.Transaction;
import com.example.accounting.repository.AccountRepository;
import com.example.accounting.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountingService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Transaction createTransaction(Transaction transaction) {
        Account account = transaction.getAccount();
        account.setBalance(account.getBalance() + transaction.getAmount());
        accountRepository.save(account);
        return transactionRepository.save(transaction);
    }
}
