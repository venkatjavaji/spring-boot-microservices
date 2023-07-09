package org.example.aws.sqs.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AwsSqsConsumer {

    @SqsListener("venkat-gurram")
    public void loadMessageFromSQS(String message)  {
        log.info("message from SQS Queue {}",message);
    }
}
