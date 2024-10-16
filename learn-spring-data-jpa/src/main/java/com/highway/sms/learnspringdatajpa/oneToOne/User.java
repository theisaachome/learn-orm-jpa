package com.highway.sms.learnspringdatajpa.oneToOne;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    @OneToOne(cascade = CascadeType.PERSIST,mappedBy = "user")
    private Address shippingAddress;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "user")
    private NRC nrc;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "buyer")
    private Set<Item> boughtItems = new HashSet<Item>();
}
