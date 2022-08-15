package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<ShallowUserResponse> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .map(ShallowUserResponse::new).collect(Collectors.toList());
    }


    @GetMapping("/userName/{userName}")
    public List<ShallowUserResponse> findUser(@PathVariable String userName) {
        return userRepository.findUserByUserName(userName).stream()
                .map(ShallowUserResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/userId/{id}")
    public ShallowUserResponse findUser(@PathVariable Long id) {
        User user=userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return new ShallowUserResponse(user);

    }
    @GetMapping("/userId/{id}/orders")
    public List<ShallowOrderResponse> findOrderByUserId(@PathVariable Long id) {
        User user=userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return user.getOrders().stream().map(ShallowOrderResponse::new).collect(Collectors.toList());

    }
    @GetMapping("/email/{email}/orders")
    public List<DetailOrderResponse> findOrderByEmail(@PathVariable String email) {
        User user=userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return user.getOrders().stream().map(DetailOrderResponse::new).collect(Collectors.toList());

    }
    @PostMapping
    private  ShallowUserResponse createUser(@RequestBody User user)
    {

        return new ShallowUserResponse(userRepository.save(user));
    }

}



