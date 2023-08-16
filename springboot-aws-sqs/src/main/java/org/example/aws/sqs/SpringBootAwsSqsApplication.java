package org.example.aws.sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
@Slf4j
public class SpringBootAwsSqsApplication {
    @Value("${test-property}")
    private String testProp;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAwsSqsApplication.class, args);
    }

    @PostConstruct
    public void testMethod() {
        log.info("loading property from DB ---> " + testProp);
    }
}
