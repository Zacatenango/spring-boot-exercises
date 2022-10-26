package com.example.zacatenango.initialbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

// To define a class as a Spring MVC controller, we annotate it with @Controller
// We also have to give it a request mapping URL with @RequestMapping
// So we define 3 names in this view controller:
// Name 1: the servlet URL, which is "roomlist", and will be used as the page's URL
// Name 2: the name of our variable in the template context, through which we'll access our object
// Name 3: the view's name, which will double as our template filename in src/main/resources/templates/<view name>.html
// Right here we have Name 1, which is the view's URL
@Controller @RequestMapping("/roomlist") public class RoomController
{
   // Since I modularized my room list initialization, I need to receive it from an autowired constructor
   private ListOfRoomsService listOfRoomsService;
   @Autowired public RoomController(ListOfRoomsService listOfRoomsService)
   {
      super();
      this.listOfRoomsService = listOfRoomsService;
   }

   // To populate our application context, we put a GetMapping function but without giving the mapping an URL
   // We have that function receive an org.springframework.ui.Model parameter
   // Note: this Model is not an MVC model, it's a web template model; it is actually our view.
   @GetMapping public String getAllRooms(Model model)
   {
      // Using model.addAttribute(), we add our rooms list object to the template context and call it "rooms"
      // This is our Name 2.
      model.addAttribute("rooms", this.listOfRoomsService.getAllRooms());
      // We return the name of our view. Spring will take this as the base name of our template, without ".html"
      // This is Name 3.
      return "room";
   }
}

// So, to wrap it up:
// - roomlist is our URL, it is defined in the request mapping
// - rooms is our rooms list in the template context
// - room is our view name, and it corresponds to template src/main/resources/templates/room.html
