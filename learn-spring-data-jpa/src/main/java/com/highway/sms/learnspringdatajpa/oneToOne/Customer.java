package com.highway.sms.learnspringdatajpa.oneToOne;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String fullname;
    private String mail;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "address_fk")
    private Address address;

}
