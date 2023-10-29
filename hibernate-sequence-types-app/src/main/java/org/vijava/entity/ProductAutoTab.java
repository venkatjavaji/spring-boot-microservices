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
@NoArgsConstructor
@AllArgsConstructor
public class ProductAutoTab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "PRODUCT_NAME")private String productName;
    @Column(name="QUANTITY") private Long quantity;
    @Column(name="PRICE") private Long price;
    @Column(name="DATE_OF_MANUFACTURE") private Date dateOfManufacture;

}
