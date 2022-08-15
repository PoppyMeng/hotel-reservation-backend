package com.example.demo;
//POJO or DTO--data transfer object
import javax.persistence.Column;

public class OrderPostRequest {

    public String startTime;
    public String endTime;
    public Long userId;
    public Long roomId;


}
