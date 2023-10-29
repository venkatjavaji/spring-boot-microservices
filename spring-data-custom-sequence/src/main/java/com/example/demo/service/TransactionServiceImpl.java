package com.example.demo.service;


import com.example.cb.service.QueueDocService;
import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.AppQueue;
import com.example.demo.entity.CustTransaction;
import com.example.demo.entity.QueueTransaction;
import com.example.demo.repo.AppQueueRepo;
import com.example.demo.repo.QueueTransactionRepo;
import com.example.demo.repo.TransactionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private AppQueueRepo appQueueRepo;

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    QueueTransactionRepo queueTransactionRepo;

    @Autowired
    QueueDocService queueDocService;


    @Override
    public List<CustTransaction> getTransactions() {
        return transactionRepo.findAll();
    }

    @Override
    @Transactional
    public void saveTransaction(TransactionDto transactionDto) {
        CustTransaction custTransaction = new CustTransaction();
        custTransaction.setTrackingNumber(transactionDto.getTrackingNumber());
        custTransaction.setCreatedOn(new Date());

        QueueTransaction queueTransaction = new QueueTransaction();
        queueTransaction.setCustTransaction(custTransaction);

        AppQueue appQueue = appQueueRepo.findByQueueName(transactionDto.getQueueName());
        if(appQueue!=null) {
            queueTransaction.setQueue(appQueue);
        } else {
            log.error("Queue Name should be valid");
            throw new RuntimeException("Queue Name should be a valid one.");
        }

        transactionRepo.save(custTransaction);
        queueTransactionRepo.save(queueTransaction);
    }

    @Override
    public String getNextTransaction(String userId) {
        return UUID.randomUUID().toString();
    }


}
