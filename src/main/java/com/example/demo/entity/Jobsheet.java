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
//    @OneToOne
    private String userId;

//    @ManyToMany
//    @JoinTable(name = "jobsheets-items",
//            joinColumns = @JoinColumn(name = "jobsheet_id",
//                    referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id",
//                    referencedColumnName = "id"))
//    private Set<ItemEntity> items;

//    @ManyToMany
//    @JoinTable(name = "jobsheets-clients",
//            joinColumns = @JoinColumn(name = "jobsheet_id",
//                    referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "client_id",
//                    referencedColumnName = "id"))
//    private Set<ClientEntity> clients;

}
