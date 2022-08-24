package com.example.demo;
import javax.persistence.*;
import java.util.*;

@Entity
@Table (name="users")
public class User {
    public User(String userName, String email) {
        this.userName = userName;
        this.email = email.toLowerCase();
        this.orders=new ArrayList<Order>();
    }
    public User(){
        this.orders=new ArrayList<Order>();
    }
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

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }
    public void setOrder(List<Order> orders) {
        this.orders = orders;
    }

}

