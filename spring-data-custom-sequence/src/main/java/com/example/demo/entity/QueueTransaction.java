package com.example.demo.entity;

import com.example.demo.config.DatePrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "queuetransaction")
public class QueueTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "queue_transaction_seq")
    @GenericGenerator(
            name = "queue_transaction_seq",
            strategy = "com.example.demo.config.DatePrefixedSequenceIdGenerator",
            parameters = {@Parameter(name = DatePrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1")})
    private Long id;

    @OneToOne
    @JoinColumn(name="custtransactionfk")
    private CustTransaction custTransaction;

    @ManyToOne
    @JoinColumn(name="txnUserQueueFk")
    private TxnUserQueue txnUserQueue;

    @ManyToOne
    @JoinColumn(name = "appQueueFk")
    private AppQueue queue;
}
