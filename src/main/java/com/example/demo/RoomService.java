package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;


//    List<Room> findAvailableRooms(String in, String out){
//        int roomNum=numOfRooms();
//
//
//
//
//    }
//    @GetMapping
//    public List findAvailableRoom( String inTime, String outTime){
//        return roomRepository.findByTime(inTime, outTime)
//                .orElseThrow(RoomNotFoundException::new);
//    }

 //ArrayList<Order> reservation =[[1,2], [2,5], [6,9], [3,6]]
//    .sort() by order.startTime => [[1,2], [2,5], [3,6],[6,9]]
//    priorityqueue=[]
//    roomNeeded=0
//    for r in reservations:
//        if not priorityqueue or priorityqueue[0]>r[0]:
//            roomNeeded+=1
//        else:
//            heapq.pop(priorityqueue)
//        heapq.add(priorityqueue, r[1])
//        return len(reservations)-roomNeeded //number of available rooms


    //parse string into localdatetime
    //don't use datetime!!
}
