package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "txnuserqueue")
public class TxnUserQueue {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "appUserFk")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "appQueueFk")
    private AppQueue queue;
}
