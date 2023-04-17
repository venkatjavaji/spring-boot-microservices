package com.example.demo.service;

import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.CustTransaction;
import com.example.demo.entity.QueueTransaction;
import com.example.demo.repo.QueueTransactionRepo;
import com.example.demo.repo.TransactionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    QueueTransactionRepo queueTransactionRepo;
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
        queueTransaction.setQueueName(transactionDto.getQueueName());
        transactionRepo.save(custTransaction);
        queueTransactionRepo.save(queueTransaction);
    }


}
