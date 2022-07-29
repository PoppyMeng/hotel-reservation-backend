package com.example.demo;

public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findByName(String roomName);
}
