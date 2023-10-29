package com.example.demo.repo;

import com.example.demo.entity.TxnUserQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxnUserQueueRepo extends JpaRepository<TxnUserQueue, Long> {
}
