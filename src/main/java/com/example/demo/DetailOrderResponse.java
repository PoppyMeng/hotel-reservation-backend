package com.example.demo;
//look into spring boot projection.......

public class DetailOrderResponse {
    private Order order;
    public DetailOrderResponse(Order order){
        this.order=order;

    }
    public Long getId() {
        return order.getId();
    }
    public ShallowUserResponse getUser() {
        return new ShallowUserResponse(order.getUser());
    }
    public ShallowRoomResponse getRoom() {
        return new ShallowRoomResponse(order.getRoom());
    }

    public String getStartTime() {
        return order.getStartTime();
    }

    public String getEndTime() {
        return order.getEndTime();
    }
}
