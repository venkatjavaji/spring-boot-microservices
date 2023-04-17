package com.example.demo.service;

import com.example.demo.entity.QueueTransaction;

import java.util.List;

public interface QueueTransactionService {

    List<QueueTransaction> getQueueTransactions();

    List<QueueTransaction> getQueueTransactionsByCustTransaction(String custTransactionId);
}
