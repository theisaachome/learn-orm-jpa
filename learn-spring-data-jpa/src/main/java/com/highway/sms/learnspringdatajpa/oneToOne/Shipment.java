package com.highway.sms.learnspringdatajpa.oneToOne;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Shipment {
    enum Status{
        InProgress,Shipped,Completed
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // intermediate table
    @OneToOne
    @JoinTable(
        name = "shipment_item",
            joinColumns = @JoinColumn(name = "shipment_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id",nullable = false,unique = true)
    )
    private Item auction;
    @Enumerated(EnumType.STRING)
    private Status status;
}
