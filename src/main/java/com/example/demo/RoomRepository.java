package com.example.demo;
//This interface is Data Access Object (DAO)
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findByName(String roomName);

    Optional<Room> findById(Long id);
    List<Room> findAll();


}
