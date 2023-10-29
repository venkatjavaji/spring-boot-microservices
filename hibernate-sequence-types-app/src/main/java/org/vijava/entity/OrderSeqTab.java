package org.vijava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderSeqTab {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
//    @SequenceGenerator(name = "order_seq_gen", sequenceName = "order_seq", allocationSize = 1)
    /**
     * MySQL doesn't support SEQUENCE-GenerationType. Inorder to use sequence generation type, we need to create a table
     * with sequenceName=`order_seq`. :: https://amrutprabhu.medium.com/spring-boot-jpa-bulk-insert-performance-by-100-times-14ec10fa682b
     *
     * CREATE TABLE `local`.`order_seq` (
     *   `next_val` bigint DEFAULT NULL
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
     *
     * INSERT INTO `order_seq` (`next_val`) VALUES(1);
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name="ORDER_DATE")
    private Date orderDate;

    @Column(name="DELIVERY_DATE")
    private Date deliveryDate;

}
