package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;


    public Order bookARoom(String email, String userName, Long roomId, String start, String end ) {

        Room room=roomRepository.findById(roomId).orElseThrow(RoomNotFoundException::new);
        User user = userRepository.findByEmail(email).orElse( userRepository.save(new User(userName, email) ));
        Order order = new Order(start, end, user, room);
        return orderRepository.save(order);
    }
}


