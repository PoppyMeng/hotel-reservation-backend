package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderService orderService;
    @GetMapping
    public Iterable<ShallowOrderResponse> findAll() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(),false)
                .map(ShallowOrderResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ShallowOrderResponse findOrderById(@PathVariable Long id) {

        Order order=orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new);
        return new ShallowOrderResponse(order);
    }

    @PostMapping
    private ShallowOrderResponse createOrder(@RequestBody OrderPostRequest request)
    {
        Room room=roomRepository.findById(request.roomId)
                .orElseThrow(RoomNotFoundException::new);
        User user=userRepository.findById(request.userId)
                .orElseThrow(UserNotFoundException::new);
        Order order=new Order(request.startTime, request.endTime, user, room );
        return new ShallowOrderResponse(orderRepository.save(order));

    }
    @PostMapping ("/book")
    private DetailOrderResponse bookARoom(@RequestBody BookARoomRequest request)
    {
       Order order =orderService.bookARoom(request.email, request.userName,
               request.roomId, request.startTime, request.endTime);
        return new DetailOrderResponse(order);

    }



}


