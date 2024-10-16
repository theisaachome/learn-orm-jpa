package com.highway.sms.learnspringdatajpa.oneToOne;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class NRC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNo;
    private String cardType;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
