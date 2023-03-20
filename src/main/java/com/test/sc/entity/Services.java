package com.test.sc.entity;


import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "service_name")
    private String serviceName;
    @Pattern(regexp = "^[а-яА-ЯёЁ]+$", message = "ФИО должно содержать только кириллические буквы")
    @Column(name = "firstname")
    private String firstName;
    @Pattern(regexp = "^[а-яА-ЯёЁ]+$", message = "ФИО должно содержать только кириллические буквы")
    @Column(name = "lastname")
    private String lastName;
    @Pattern(regexp = "^[а-яА-ЯёЁ]+$", message = "ФИО должно содержать только кириллические буквы")
    @Column(name = "surname")
    private String surName;
    @Column(name = "email")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "используйте адрес электронной почты")
    private String eMail;
    @Transient
    private boolean serviceSaved;

    public Services() {
        serviceSaved = true;
    }

    public Services(int id, String createdDate,
                    String serviceName, String firstName,
                    String lastName, String surName, String eMail) {
        this.id = id;
        this.createdDate = createdDate;
        this.serviceName = serviceName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.eMail = eMail;
        serviceSaved = true;
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

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public boolean isServiceSaved() {
        return serviceSaved;
    }

    public void setServiceSaved(boolean serviceSaved) {
        this.serviceSaved = serviceSaved;
    }
}
