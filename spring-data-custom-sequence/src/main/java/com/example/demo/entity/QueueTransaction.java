package com.example.demo.entity;

import com.example.demo.config.DatePrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "queuetransaction")
public class QueueTransaction {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq_gen_queuetransaction")
//    @SequenceGenerator(name="seq_gen_queuetransaction" , sequenceName = "seq_queuetransaction", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "queue_transaction_seq")
    @GenericGenerator(
            name = "queue_transaction_seq",
            strategy = "com.example.demo.config.DatePrefixedSequenceIdGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = DatePrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1")})
    private String id;
    private String queueName;

    @ManyToOne
    @JoinColumn(name="custtransactionfk")
    private CustTransaction custTransaction;
}
