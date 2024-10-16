package com.highway.sms.learnspringdatajpa.oneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(
            name = "addressKeyGenerator",
            strategy = "foreign",
            parameters = {
                    @Parameter(name = "property",value = "user")
            }
    )
    private Integer addressId;
    private String street;
    private String zipcode;
    private String city;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private User user;
    public Address(){}
    public Address(User user) {
        this.user = user;
    }
    public Address( User user, String street, String zipcode, String city) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.user = user;
    }
}
