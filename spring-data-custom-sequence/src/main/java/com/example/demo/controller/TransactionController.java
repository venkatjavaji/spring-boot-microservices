package com.example.demo.controller;

import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.CustTransaction;
import com.example.demo.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@Slf4j
public class TransactionController {

    @Autowired TransactionService transactionService;
    @GetMapping
    public ResponseEntity<?> getTransactions() {
        List<CustTransaction> custTransactionList =  transactionService.getTransactions();
        return ResponseEntity.status(HttpStatus.OK).body(custTransactionList);
    }

    @PostMapping
    public ResponseEntity<?> saveTransaction(@RequestBody TransactionDto transactionDto) {
        transactionService.saveTransaction(transactionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @GetMapping("next")
    public ResponseEntity<?> getNextTransaction(@RequestParam String userId) {
        return new ResponseEntity<>(transactionService.getNextTransaction(userId),HttpStatus.OK);
    }
}
