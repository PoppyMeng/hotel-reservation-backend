package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }


    @GetMapping("/userName/{userName}")
    public List<User> findUser(@PathVariable String userName) {
        return userRepository.findUser(userName);
    }

    @GetMapping("/userId/{id}")
    public User findUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }
    @PostMapping
    private User createUser(@RequestBody User user)
    {
        return userRepository.saveOrUpdate(user);

    }
    @GetMapping("/userId/{id}/orders")
    public List<Order> findOrderByUser(@PathVariable Long id) {

//        List<Order> allOrders = orderfindAll();
//        List<Order> res = (List<Order>) allOrders.stream()
//                .filter(order -> order.getId() == id);
//        return res;
        return userRepository.findById(id).map(user-> user.getOrders())
                .orElseThrow(UserNotFoundException::new);

    }

}


//getReservation

