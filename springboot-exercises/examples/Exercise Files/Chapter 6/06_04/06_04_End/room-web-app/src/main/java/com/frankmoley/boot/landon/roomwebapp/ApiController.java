package com.frankmoley.boot.landon.roomwebapp;

import com.frankmoley.landon.aop.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private RoomServices roomServices;
    private CounterService counterService;

    @Autowired
    public ApiController(RoomServices roomServices, CounterService counterService){
        super();
        this.roomServices = roomServices;
        this.counterService = counterService;
    }

    @GetMapping("/rooms")
    @Timed
    public List<Room> getAllRooms(){
        this.counterService.increment("services.room-web-app.getAllRooms.invoked");
        return this.roomServices.getAllRooms();
    }
}
