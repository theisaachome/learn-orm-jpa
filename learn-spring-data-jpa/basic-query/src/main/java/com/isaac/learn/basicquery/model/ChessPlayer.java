package com.isaac.learn.basicquery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ChessPlayer {

    @Id
    private Long id;
}
