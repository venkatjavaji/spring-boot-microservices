package com.example.demo.controller;

import com.example.demo.entity.QueueTransaction;
import com.example.demo.service.QueueTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transaction/queue")
@Slf4j
public class QueueTransactionController {

    @Autowired
    QueueTransactionService queueTransactionService;
    @GetMapping
    public ResponseEntity<?> getQueueTransactions() {
        List<QueueTransaction> queueTransactionList = queueTransactionService.getQueueTransactions();
       return  ResponseEntity.status(HttpStatus.OK).body(queueTransactionList);
    }

    @GetMapping("{transactionId}")
    public ResponseEntity<?> getQueueTransactionByCustTransaction(@PathVariable String transactionId) {
        List<QueueTransaction> queueTransactionList = queueTransactionService.getQueueTransactionsByCustTransaction(transactionId);
        return ResponseEntity.status(HttpStatus.OK).body(queueTransactionList);
    }
}
