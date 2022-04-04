package com.example.demo.entity;

import com.example.demo.model.ItemReadModel;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "jobsheets")
public class JobsheetEntity {

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

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "jobsheet_id")
    private Set<ItemEntity> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalDateTime getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(LocalDateTime timeStop) {
        this.timeStop = timeStop;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeDrive() {
        return timeDrive;
    }

    public void setTimeDrive(LocalDateTime timeDrive) {
        this.timeDrive = timeDrive;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ItemReadModel> getItems() {
        ModelMapper mapper = new ModelMapper();
        return items.stream()
                .map(itemEntity -> mapper.map(itemEntity, ItemReadModel.class))
                .collect(Collectors.toList());
    }

    public void setItems(Set<ItemEntity> items) {
        this.items = items;
    }

    public JobsheetEntity addItem(ItemEntity source) {
        this.items.add(source);
        return this;
    }
    public JobsheetEntity deleteItem(ItemEntity source) {
        this.items.remove(source);
        return this;
    }
}
