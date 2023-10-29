package com.example.demo.entity;

import com.example.demo.config.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="custtransaction",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"trackingNumber"})})
public class CustTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_transaction_seq")
    @GenericGenerator(
            name = "cust_transaction_seq",
            strategy = "com.example.demo.config.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CUST_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d") })
    private String id;
    private String trackingNumber;
    private Date createdOn;
}
