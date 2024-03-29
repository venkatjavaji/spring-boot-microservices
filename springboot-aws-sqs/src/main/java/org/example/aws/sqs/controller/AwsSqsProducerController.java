package org.example.aws.sqs.controller;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sqs")
@Slf4j
public class AwsSqsProducerController {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    private ContextRefresher contextRefresher;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @PostMapping("send")
    public ResponseEntity<?> sendMessageToQueue(@RequestBody String message) {
        log.info("sendMessageToQueue is called. endpoint="+endpoint);
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
        return ResponseEntity.status(HttpStatus.OK).body("message sent successfully.");
    }

    @GetMapping("refresh")
    public String refreshContext() {
        contextRefresher.refresh();
        return "success";
    }
}
