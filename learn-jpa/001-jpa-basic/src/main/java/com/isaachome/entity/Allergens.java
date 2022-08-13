package com.isaachome.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Allergens {
    @Column(name = "peanuts", table = "allergens")
    boolean peanuts;

    @Column(name = "celery", table = "allergens")
    boolean celery;

    @Column(name = "sesame_seeds", table = "allergens")
    boolean sesameSeeds;

    // standard getters and setters
}
