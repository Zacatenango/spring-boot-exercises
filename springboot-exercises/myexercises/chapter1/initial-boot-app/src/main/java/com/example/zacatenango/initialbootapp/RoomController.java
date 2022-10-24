package com.example.zacatenango.initialbootapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

// To define a class as a Spring MVC controller, we annotate it with @Controller
// We also have to give it a request mapping URL with @RequestMapping
// According to Spring documentation, templates are automatically picked up from src/main/resources/templates according
// to the servlet's mapping
@Controller @RequestMapping("/rooms") public class RoomController
{
   private static List<Room> rooms = new ArrayList();

   // For the purposes of this exercise, a hardcoded list of rooms will do
   // This is a static block. Static blocks are run as soon as the class is loaded in memory. When this actually happens
   // is a good question, but it's guaranteed to have run by the time we need our class for the first time.
   // One use for this is to initialize a class's static variables with values more complex than just a simple literal.
   // In this case, we're initializing it with a list of room objects.
   // Note: Static blocks do not replace psvmSa. They used to be able to replace it on Java 1.5 and earlier, but not
   // anymore. Java will specifically look for psvmSa, and if it's absent, it will refuse to start the program.
   static
   {
      for (int X=0; X<10; X++)
      {
         rooms.add(new Room(X, "Room " + X, "R" + X, "Q"));
      }
   }

   // To populate our application context, we put a GetMapping function but without giving the mapping an URL
   // We have that function receive an org.springframework.ui.Model parameter
   @GetMapping public String getAllRooms(Model model)
   {
      // Using model.addAttribute(), we add our rooms list object to the template context and call it "rooms"
      model.addAttribute("rooms", rooms);
      // We return the name of our attribute
      return "rooms";
   }
}
