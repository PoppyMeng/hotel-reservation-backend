package com.example.demo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public Iterable<ShallowRoomResponse> findAll() {
        return StreamSupport.stream(roomRepository.findAll().spliterator(),false)
                .map(ShallowRoomResponse::new).collect(Collectors.toList());
    }
    @GetMapping("/available/{start}/{end}")
    public Iterable<ShallowRoomResponse> findAvailableRoom(@PathVariable String start, @PathVariable String end) {
        return roomService.findAvailableRooms(start, end).stream()
                .map(ShallowRoomResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/roomName/{roomName}")
    public List<ShallowRoomResponse> findByName(@PathVariable String roomName) {
        return roomRepository.findByName(roomName).stream()
                .map(ShallowRoomResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ShallowRoomResponse findById(@PathVariable Long id) {
        Room room=roomRepository.findById(id)
                .orElseThrow(RoomNotFoundException::new);
        return new ShallowRoomResponse(room);
    }
    @GetMapping("/roomId/{roomId}/orders")
    public List<ShallowOrderResponse> findOrderByRoomId(@PathVariable Long roomId) {
        Room room=roomRepository.findById(roomId)
                .orElseThrow(RoomNotFoundException::new);
        return room.getOrders().stream().map(ShallowOrderResponse::new).collect(Collectors.toList());
    }


    @PostMapping
    private ShallowRoomResponse createRoom(@RequestBody Room room)
    {
        return new ShallowRoomResponse(roomRepository.save(room));

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
