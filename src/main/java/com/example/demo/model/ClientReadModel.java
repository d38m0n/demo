package com.example.demo.model;

import com.example.demo.entity.EvidenceEntity;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.Jobsheet;
import com.example.demo.entity.OrderEntity;
import org.modelmapper.ModelMapper;

import java.util.Set;

public class ClientReadModel {
    private String description1;
    private String description2;
    private boolean isActive;
    private EvidenceEntity evidence_id;
    private Set<ItemEntity> items;
    private Set<OrderEntity> orders;
    private Set<Jobsheet> jobsheets;
    private ModelMapper mapper;

    public ClientReadModel() {

    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public EvidenceReadModel getEvidence_id() {
        mapper = new ModelMapper();
        return mapper.map(evidence_id, EvidenceReadModel.class);
    }

    public void setEvidence_id(EvidenceEntity evidence_id) {
        this.evidence_id = evidence_id;
    }

    public Set<ItemEntity> getItems() {
        return items;
    }

    public void setItems(Set<ItemEntity> items) {
        this.items = items;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public Set<Jobsheet> getJobsheets() {
        return jobsheets;
    }

    public void setJobsheets(Set<Jobsheet> jobsheets) {
        this.jobsheets = jobsheets;
    }
}
