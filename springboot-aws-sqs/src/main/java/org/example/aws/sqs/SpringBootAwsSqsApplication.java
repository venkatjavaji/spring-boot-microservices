package org.example.aws.sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
@Slf4j
public class SpringBootAwsSqsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAwsSqsApplication.class, args);
    }
}
