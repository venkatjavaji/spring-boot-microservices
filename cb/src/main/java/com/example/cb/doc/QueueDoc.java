package org.example.cb.doc;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.Set;

@Document
@Data
@Builder
public class QueueDoc {

    @Id
    private String userName;

    @Field
    private Set<String> queueList;
}
