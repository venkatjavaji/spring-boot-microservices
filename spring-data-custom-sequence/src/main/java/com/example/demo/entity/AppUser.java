package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Data
@Table(name = "appuser",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"userId"})})
public class AppUser {

    @Id
    private Long id;

    private String userId;
}
