package org.vijava.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vijava.entity.OrderSeqTab;
import org.vijava.repository.OrderRepository;
import org.vijava.util.ApplicationUtil;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    void createOrderTest() {
        OrderSeqTab order = OrderSeqTab.builder()
                .orderDate(ApplicationUtil.toDate(LocalDate.now()))
                .deliveryDate(ApplicationUtil.toDate(LocalDate.of(2023,2,23)))
                .build();
        orderRepository.save(order);
    }

    @Test
    void saveBulkOrderTest() {
        List<OrderSeqTab> orderList = IntStream.rangeClosed(1,100).mapToObj(num -> OrderSeqTab.builder()
                .orderDate(new Date())
                .deliveryDate(ApplicationUtil.toDate(LocalDate.of(2023,2,28))).build())
                .collect(Collectors.toList());
        orderRepository.saveAll(orderList);
    }

}