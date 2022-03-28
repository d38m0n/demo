package com.example.demo.entity;


import com.example.demo.model.CompanyUpdateModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "companies")
public class CompanyEntity extends BaseEditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String status;
    private String description;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Set<UserEntity> users;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Set<ClientEntity> clients;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Set<ItemEntity> items;



    public CompanyEntity() {
    }

    public String getId() {
        return id;
    }

    public void addUserToCompany(UserEntity source) {
        this.users.add(source);
    }

    public CompanyEntity deleteUserWithCompany(UserEntity source) {
        this.users.remove(source);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String description_1) {
        this.status = description_1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description_2) {
        this.description = description_2;
    }


    public CompanyEntity updateFrom(final CompanyUpdateModel store) {
        this.description = store.getDescription();
        this.name = store.getName();
        this.status = store.getStatus();
        return this;
    }

}
