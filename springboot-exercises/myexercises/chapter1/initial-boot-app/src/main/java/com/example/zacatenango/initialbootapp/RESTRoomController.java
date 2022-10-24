package com.example.zacatenango.initialbootapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Implementing a REST API can be done by declaring a class annotated with @RestController @RequestMapping("<URL>")
@RestController @RequestMapping("/rooms_json") public class RESTRoomController
{
   private static List<Room> rooms = new ArrayList();
   static
   {
      for (int X=0; X<10; X++)
      {
         rooms.add(new Room(X, "Room " + X, "R" + X, "Q"));
      }
   }

   // On our GET response function, we return a plain Java object. Spring will automatically serialize it to JSON
   // using the Jackson library, and transparently return that object as JSON.
   @GetMapping public List<Room> getAllRooms_JSON()
   {
      return rooms;
   }
}
