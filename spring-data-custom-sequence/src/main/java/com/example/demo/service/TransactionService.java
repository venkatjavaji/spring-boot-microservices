package com.example.demo.service;

import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.CustTransaction;

import java.util.List;

public interface TransactionService {

    List<CustTransaction> getTransactions();

    void saveTransaction(TransactionDto transactionDto);
}
