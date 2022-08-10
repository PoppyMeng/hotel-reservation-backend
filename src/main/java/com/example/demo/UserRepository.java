package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

//This interface is Data Access Object (DAO)


public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findUser(String userName);

    Optional<User> findById(Long id);
    List<User> findByEmail(String email);
    List<User> findAll();
    User saveOrUpdate(User user);


}


