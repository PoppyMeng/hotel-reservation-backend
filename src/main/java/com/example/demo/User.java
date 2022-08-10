package com.example.demo;
import javax.persistence.*;
import java.util.*;

@Entity
@Table (name="users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy="user")
    private List<Order> orders;

    public List<Order> getOrders(){ return orders;}
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    public String getName() {
        return userName;
    }

    public List<Order> getOrder() {
        return orders;
    }

    public void setName(String userName) {
        this.userName = userName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setOrder(List<Order> orders) {
        this.orders = orders;
    }

}

