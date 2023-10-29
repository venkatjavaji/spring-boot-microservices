package org.vijava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
class HibernateApplicationTest {

    @Test
    void test() {
        Assertions.assertTrue(true,"sample mockito test method, with default assertion");
    }

}