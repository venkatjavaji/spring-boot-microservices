package org.example.cb.service;

import lombok.extern.slf4j.Slf4j;
import org.example.cb.doc.TransactionDoc;
import org.example.cb.repo.TransactionDocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class TransactionDocService {

    @Autowired
    TransactionDocRepo transactionDocRepo;
    public void getNextTransaction(Set<String> queueNameSet) {
        transactionDocRepo.findTopByQueueNameInOrderByEntryTimeAscSlaAsc(queueNameSet);
    }

    public TransactionDoc saveNextTransactionDoc(TransactionDoc transactionDoc) {
        return transactionDocRepo.save(transactionDoc);
    }
}
