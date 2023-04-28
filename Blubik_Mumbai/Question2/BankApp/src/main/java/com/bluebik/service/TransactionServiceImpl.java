package com.bluebik.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebik.model.Account;
import com.bluebik.model.Transaction;
import com.bluebik.model.User;
import com.bluebik.repository.AccountRepository;
import com.bluebik.repository.TransactionRepository;
import com.bluebik.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public String credit(Integer userId, Integer accountId, BigDecimal amount) {
        Optional<User> user = userRepository.findByUserId(userId);
        Optional<Account> account = accountRepository.findByAccountId(accountId);
        if (user.isPresent() && account.isPresent()) {
            if (account.get().getBalance().add(amount).longValue() <= 10000000) {
                account.get().setBalance(account.get().getBalance().add(amount));
                Transaction transaction = new Transaction("credit", amount, account.get(), userId);
                transactionRepository.save(transaction);
                return amount+" Rs. credited to the account "+accountId+" By User "+user.get().getName();
            } else {
                throw new RuntimeException("Credit amount exceeds balance limit");
            }
        } else {
            throw new RuntimeException("User or account not found");
        }
    }

    public String debit(Integer userId, Integer accountId, BigDecimal amount) {
        Optional<User> user = userRepository.findByUserId(userId);
        Optional<Account> account = accountRepository.findByAccountId(accountId);
        if (user.isPresent() && account.isPresent()) {
            if (account.get().getBalance().subtract(amount).longValue() >= 0) {
                account.get().setBalance(account.get().getBalance().subtract(amount));
                Transaction transaction = new Transaction("debit", amount, account.get(), userId);
                transactionRepository.save(transaction);
                return amount+" Rs. debited from the account "+accountId+" By User "+user.get().getName();
            } else {
                throw new RuntimeException("Debit amount exceeds balance limit");
            }
        } else {
            throw new RuntimeException("User or account not found");
        }
    }
}
