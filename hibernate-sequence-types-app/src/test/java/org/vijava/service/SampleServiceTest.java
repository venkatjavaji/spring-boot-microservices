package org.vijava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vijava.entity.SampleIdentityTab;
import org.vijava.repository.SampleRepository;

import java.util.Date;
import java.util.Random;

@SpringBootTest
class SampleServiceTest {
    @Autowired
    SampleRepository sampleRepository;
    @Test
    void createSampleTest() {
        SampleIdentityTab sample = SampleIdentityTab.builder()
                .createdOn(new Date())
                .name("SampleIdentityTab-"+new Random().nextInt(1,100))
                .build();
       sampleRepository.save(sample);
       Assertions.assertTrue(sample.getId()>0);
    }

}