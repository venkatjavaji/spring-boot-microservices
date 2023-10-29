package com.example.demo.repo;

import com.example.demo.entity.AppQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppQueueRepo extends JpaRepository<AppQueue, Long> {

    AppQueue findByQueueName(String queueName);

}
