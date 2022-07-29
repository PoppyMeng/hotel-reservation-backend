package com.example.demo;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String roomName;

    @Column(nullable = false)
    private String address;
}