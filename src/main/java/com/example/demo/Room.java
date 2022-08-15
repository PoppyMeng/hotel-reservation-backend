package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Room is a domain class
@Entity
public class Room {
    public Room(String name, String address, Integer pricePerNight) {
        this.name = name;
        this.address = address;
        this.pricePerNight = pricePerNight;
        this.orders = new ArrayList<Order>();
    }

    public Room() {
        this.orders = new ArrayList<Order>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column (columnDefinition = "integer default 100", nullable=false)
    private Integer pricePerNight;
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "room")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPricePerNight(Integer price) {
        this.pricePerNight = price;
    }
}

//DB in heroku, clear out existing data