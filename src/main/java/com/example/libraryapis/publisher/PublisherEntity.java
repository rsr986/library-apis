package com.example.libraryapis.publisher;

import jakarta.persistence.*;

@Entity
@Table(name = "PUBLISHER")
public class PublisherEntity {

    @Column(name = "Publisher_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisherId_generator")
    @SequenceGenerator(name = "publisherId_generator", sequenceName = "publisher_sequence", allocationSize = 50)
    private Integer publisherId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email_Id")
    private String emailId;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    public PublisherEntity() {
    }

    public PublisherEntity(String name, String emailId, String phoneNumber) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
