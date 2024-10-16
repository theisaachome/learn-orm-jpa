package com.highway.sms.learnspringdatajpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class News {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String content;
    @OrderBy("postedDate DESC")
    @OneToMany
    private List<Comment> comments = new ArrayList<Comment>();
}
