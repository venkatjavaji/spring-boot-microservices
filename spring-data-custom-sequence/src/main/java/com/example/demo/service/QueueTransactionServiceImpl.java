package com.example.demo.service;

import com.example.demo.entity.QueueTransaction;
import com.example.demo.repo.QueueTransactionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QueueTransactionServiceImpl implements QueueTransactionService{

    @Autowired
    QueueTransactionRepo queueTransactionRepo;
    @Override
    public List<QueueTransaction> getQueueTransactions() {
        return queueTransactionRepo.findAll();
    }

    @Override
    public List<QueueTransaction> getQueueTransactionsByCustTransaction(String custTransactionId) {
        return queueTransactionRepo.findByCustTransaction_Id(custTransactionId);
    }
}
