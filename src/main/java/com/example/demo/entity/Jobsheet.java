package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "jobsheets")
public class Jobsheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String date;
    private LocalDateTime timeStop;
    private LocalDateTime timeStart;
    private LocalDateTime timeDrive;
    private String distance;
    private String projectNumber;
    private String status;
    private String userId;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "jobsheet_id")
    private Set<ItemEntity> items;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "jobsheet_id")
    private Set<ClientEntity> clients;

}
