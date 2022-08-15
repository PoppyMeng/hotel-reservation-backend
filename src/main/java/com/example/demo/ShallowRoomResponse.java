package com.example.demo;

public class ShallowRoomResponse {

    private Room room;
    public ShallowRoomResponse(Room room){
        this.room=room;

    }
    public Long getId() {
        return room.getId();
    }
    public Integer getPricePerNight() {
        return room.getPricePerNight();
    }

    public String getName() {
        return room.getName();
    }

    public String getAddress() {
        return room.getAddress();
    }
}
