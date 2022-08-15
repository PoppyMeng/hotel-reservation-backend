package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table (name="orders")
public class Order {
    public Order( String startTime, String endTime, User user, Room room) {
        this.endTime= endTime;
        this.startTime= startTime;
        this.user= user;
        this.room= room;
    }
    public Order(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//user, room

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;


    @ManyToOne
    @JoinColumn(name="room_id", nullable=false)
    private Room room; //one room to many orders
    @Column(nullable = false)
    private String startTime;

    @Column(nullable = false)
    private String endTime;

    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public Room getRoom() {
        return room;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setUser(User user) {
        this.user= user;
    }
    public void setRoom(Room room) {
        this.room= room;
    }

    public void setEndTime(String endTime) {
        this.endTime= endTime;
    }
    public void setStartTime(String startTime) {
        this.startTime= startTime;
    }
}
