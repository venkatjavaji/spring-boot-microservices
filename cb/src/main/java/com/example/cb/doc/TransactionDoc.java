package org.example.cb.doc;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.Date;

@Document
@Builder
@Data
public class TransactionDoc {

    @Id
    private String queueName;

    @Field
    private String transactionId;

    @Field
    private String sla;

    @Field
    private Date entryTime;


}
