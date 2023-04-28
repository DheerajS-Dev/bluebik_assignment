package com.bluebik.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluebik.service.TransactionService;

@RestController
@RequestMapping("/accounts")
public class TransactionController {

    @Autowired
    private TransactionService accountService;

    @PostMapping("/{accountId}/credit")
    public ResponseEntity<String> credit(@RequestParam Integer userId, @RequestParam BigDecimal amount, @PathVariable Integer accountId) {
        String res = accountService.credit(userId, accountId, amount);
        return new ResponseEntity<String>(res,HttpStatus.OK);
    }

    @PostMapping("/{accountId}/debit")
    public ResponseEntity<String> debit(@RequestParam Integer userId, @RequestParam BigDecimal amount, @PathVariable Integer accountId) {
        String res = accountService.debit(userId, accountId, amount);
        return new ResponseEntity<String>(res,HttpStatus.OK);
    }
}
