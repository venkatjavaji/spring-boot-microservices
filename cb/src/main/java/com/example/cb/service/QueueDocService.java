package org.example.cb.service;


import lombok.extern.slf4j.Slf4j;
import org.example.cb.doc.QueueDoc;
import org.example.cb.repo.QueueDocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class QueueDocService {

    @Autowired
    QueueDocRepo queueDocRepo;

    public QueueDoc getQueueDocAssignedToUser(String userId){
        return queueDocRepo.findById(userId).orElse(null);
    }

    public QueueDoc saveOrUpdateUserQueueList(String userId, Set<String> queueNameList) {
        QueueDoc queueDoc;
        if(queueDocRepo.existsById(userId)) {
            queueDoc  = getQueueDocAssignedToUser(userId);
            queueDoc.setQueueList(queueNameList);
            queueDoc = queueDocRepo.save(queueDoc);
        } else {
            queueDoc = saveQueueDoc(userId,queueNameList);
        }
        return queueDoc;
    }

    public QueueDoc saveQueueDoc(String userId, Set<String> queueNameList) {
            QueueDoc queueDoc = QueueDoc.builder().userName(userId).queueList(queueNameList).build();
          return  queueDocRepo.save(queueDoc);
    }
}
