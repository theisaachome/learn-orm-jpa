package com.highway.sms.learnspringdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime creationDate;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "purchased_order_lines",
    joinColumns = @JoinColumn(name = "order_fk"),
    inverseJoinColumns = @JoinColumn(name = "order_line_fk"))
    private List<OrderLine> orderLines;
}
