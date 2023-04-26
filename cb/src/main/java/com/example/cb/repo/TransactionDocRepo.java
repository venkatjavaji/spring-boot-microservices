package org.example.cb.repo;

import org.example.cb.doc.TransactionDoc;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TransactionDocRepo extends CouchbaseRepository<TransactionDoc,String> {

    TransactionDoc findTopByQueueNameInOrderByEntryTimeAscSlaAsc(Set<String> queueName);
}
