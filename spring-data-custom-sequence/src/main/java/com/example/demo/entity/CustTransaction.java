package com.example.demo.entity;

import com.example.demo.config.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="custtransaction")
public class CustTransaction {

    @Id
//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")

//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_custtransaction")
//    @SequenceGenerator(name="seq_gen_custtransaction" , sequenceName = "seq_custtransaction", allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_transaction_seq")
    @GenericGenerator(
            name = "cust_transaction_seq",
            strategy = "com.example.demo.config.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "10"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "B_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    private String id;
    private String trackingNumber;
    private Date createdOn;
}
