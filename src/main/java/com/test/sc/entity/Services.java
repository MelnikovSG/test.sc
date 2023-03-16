package com.test.sc.entity;

import javax.persistence.*;

@Entity
@Table(name = "services")
public class Services {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "service_name")
    private String ServiceName;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number")
    private int number;

    public Services() {
    }

    public Services(int id, String created_date, String userName, String serviceName, int number) {
        this.id = id;
        this.createdDate = created_date;
        this.userName = userName;
        ServiceName = serviceName;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String created_date) {
        this.createdDate = created_date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
