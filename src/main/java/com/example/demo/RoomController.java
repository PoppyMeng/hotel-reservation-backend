package com.example.demo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> findAll() {
        return roomRepository.findAll();
    }


    @GetMapping("/roomName/{roomName}")
    public List<Room> findByName(@PathVariable String roomName) {
        return roomRepository.findByName(roomName);
    }

    @GetMapping("/{id}")
    public Room findOne(@PathVariable Long id) {
        return roomRepository.findById(id)
                .orElseThrow(RoomNotFoundException::new);
    }
    @GetMapping("/{roomId}/orders")
    public List<Order> findOrderByRoomId(@PathVariable Long roomId) {
        return orderRepository.findByRoomId(roomId);
    }

}



//    @PutMapping("/{id}")
//    public Room updateRoom(@RequestBody Room room, @PathVariable Long id) {
//        if (room.getId() != id) {
//            throw new RoomIdMismatchException();
//        }
//        roomRepository.findById(id)
//                .orElseThrow(RoomNotFoundException::new);
//        return roomRepository.save(room);
//    }
//}

//get available rooms (filter)
//reservation, customer, rooms---linked by userID--get all the reservation filtered by a userID---my existing order
