package com.example.demo;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;


public interface OrderRepository extends CrudRepository<Order, Long> {

//    Optional<Order> findById(Long id);
//    Iterable <Order> findAll();
    List<Order> findByUserId(Long userId);
    List<Order> findByRoomId(Long roomId);
//    Order saveOrUpdate(Order order);

}