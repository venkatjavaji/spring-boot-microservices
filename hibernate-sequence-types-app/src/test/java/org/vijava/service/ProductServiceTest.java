package org.vijava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vijava.entity.ProductAutoTab;
import org.vijava.repository.ProductRepository;
import org.vijava.util.ApplicationUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void saveProductTest() {
        ProductAutoTab product = ProductAutoTab
                .builder()
                .productName("Macbook Pro4")
                .price(198000L)
                .quantity(100L)
                .dateOfManufacture(ApplicationUtil.toDate(LocalDate.of(2023,1,26)))
                .build();

            productRepository.save(product);
        Assertions.assertTrue(product.getId()>0);
    }

    @Test
    void saveBulkProductsTest() {
        Random random = new Random();
        List<ProductAutoTab> productList = IntStream.rangeClosed(1,100)
                .mapToObj(num -> ProductAutoTab.builder()
                    .productName("product-"+num)
                    .price(random.nextLong(60000,199999))
                    .quantity(random.nextLong(1,100)).build())
                .collect(Collectors.toList());
        productRepository.saveAll(productList);
        Assertions.assertFalse(productList.size() != 49);
    }

}