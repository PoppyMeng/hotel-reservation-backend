package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Room> findAvailableRooms(String start, String end) {
        List<Room> res = new ArrayList<>();
        Iterable<Room> rooms = roomRepository.findAll();
        for (Room room : rooms) {
            List<Order> roomOrders=room.getOrders();
            //List<Order> roomOrders = orderRepository.findByRoomId(room.getId());
            boolean isAvailable=true;
            for (Order order : roomOrders) {
                if (!(Integer.valueOf(order.getStartTime()) >= Integer.valueOf(end) || Integer.valueOf(order.getEndTime()) <= Integer.valueOf(start))) {
                    isAvailable=false;
                    break;
                }
            }
            if (isAvailable){
                res.add(room);
            }


        }
        return res;
    }
}


