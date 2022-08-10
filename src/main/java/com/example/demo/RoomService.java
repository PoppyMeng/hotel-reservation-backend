package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private OrderRepository orderRepository;

    public List<Room> findAvailableRooms(String start, String end) {
        List<Room> res = new ArrayList<>();
        List<Room> rooms = roomRepository.findAll();
        for (Room room : rooms) {
            List<Order> roomOrders = orderRepository.findByRoomId(room.getId());
            for (Order order : roomOrders) {
                if (Integer.valueOf(order.getStartTime()) < Integer.valueOf(end) || Integer.valueOf(order.getEndTime()) > Integer.valueOf(start)) {
                    break;
                }
            }
            res.add(room);

        }
        return res;
    }
}


