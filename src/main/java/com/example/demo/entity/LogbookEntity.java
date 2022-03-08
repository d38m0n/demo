package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logbook")
public class LogbookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private LocalDateTime log;

    public LogbookEntity() {
        this.log = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getLog() {
        return log;
    }

    public void setLog(LocalDateTime log) {
        this.log = log;
    }
}
