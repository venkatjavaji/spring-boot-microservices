package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Data
@Table(name = "appqueue",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"queueName"})})
public class AppQueue {

    @Id
    private Long id;

    private int sla;
    private String queueName;

}
