package org.example.aws.sqs.consumer;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AwsSqsConsumer {

    @SqsListener("venkat-gurram")
    public void loadMessageFromSQS(String message)  {
        log.info("message from SQS Queue {}",message);
    }
}
