package com.example.demo;
//look into spring boot projection.......

public class ShallowOrderResponse {
    private Order order;
    public ShallowOrderResponse(Order order){
        this.order=order;

    }
    public Long getId() {
        return order.getId();
    }
    public Long getUserId() {
        return order.getUser().getId();
    }
    public Long getRoomId() {
        return order.getRoom().getId();
    }

    public String getStartTime() {
        return order.getStartTime();
    }

    public String getEndTime() {
        return order.getEndTime();
    }
}
