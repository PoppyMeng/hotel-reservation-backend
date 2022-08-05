package com.example.demo;

import javax.persistence.*;
@Entity
@Table (name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//user, room
    @Column(nullable = false)
    private String startTime;

    @Column(nullable = false)
    private String endTime;

    public Long getId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setName(String startTime) {
        this.startTime= startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime= endTime;
    }
}