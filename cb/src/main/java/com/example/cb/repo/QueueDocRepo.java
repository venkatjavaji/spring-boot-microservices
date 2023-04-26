package org.example.cb.repo;


import org.example.cb.doc.QueueDoc;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueDocRepo extends CouchbaseRepository<QueueDoc, String> {

}
