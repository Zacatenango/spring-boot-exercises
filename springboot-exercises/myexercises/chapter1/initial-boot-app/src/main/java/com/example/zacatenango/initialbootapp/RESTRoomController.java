package com.example.zacatenango.initialbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Implementing a REST API can be done by declaring a class annotated with @RestController @RequestMapping("<URL>")
@RestController @RequestMapping("/api") public class RESTRoomController
{
   // Since I modularized my room list initialization, I need to receive it from an autowired constructor
   private ListOfRoomsService listOfRoomsService;
   @Autowired public RESTRoomController(ListOfRoomsService listOfRoomsService)
   {
      super();
      this.listOfRoomsService = listOfRoomsService;
   }

   // On our GET response function, we return either a POJO or a feijão. Spring will automatically serialize it to JSON
   // using the Jackson library, and transparently return that object as JSON.
   // Change from the previous iteration: instead of just returning a hard-coded static list, we return the list of
   // rooms returned by our list-of-rooms service object
   // Also, if I define twice a GetMapping URL, the request mapping that annotates the class will define a virtual
   // directory, and the function's annotation will define the API endpoint; in this case, our rooms API will be
   // accessed via /api/rooms
   // To get XML output instead of JSON, I need to receive an HTTP request with Accept: application/xml and have the
   // Jackson XML serializer (jackson-dataformat-xml) installed in my Maven dependencies
   @GetMapping("/rooms") public List<Room> getAllRooms_JSON() { return this.listOfRoomsService.getAllRooms(); }

   // HTTP request parameters:
   // We receive them as plain ol' function parameters annotated with @RequestParam. Now, browsing /api/oneroom?roomID=0
   // will fetch room 0 from the list of rooms, /api/oneroom?roomID=1 will fetch room 1, and so on.
   // Note: now that we have installed the XML serializer, we have to specify produces="application/json" on our
   // RequestMapping to get our endpoint to output JSON and set the appropriate HTTP Content-Type
   @GetMapping(value="/oneroom", produces="application/json") public Room getOneRoom_JSON(@RequestParam int roomID)
   {
      return this.listOfRoomsService.getAllRooms().get(roomID);
   }
}
