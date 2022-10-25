package com.example.zacatenango.initialbootapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Since I just duplicated code while doing the web page view and the REST view, I'm going to refactor the whole thing
// to concentrate room list generation into a single class, so that it's more Spring-like
// I annotate it with @Service, because Spring has hard-coded design pattern support and this here is a "Service" design
// pattern: an operation offered as something that stands alone in the model, with no encapsulated state.
// The list of rooms qualifies as such, because it is not "state", it is just a hard-coded constant that never changes;
// therefore, its containing class can be considered a "service".
@Service public class ListOfRoomsService
{
   private static final List<Room> rooms = new ArrayList<>();
   static
   {
      for (int X=0; X<10; X++)
      {
         rooms.add(new Room(X, "Room " + X, "R" + X, "Q"));
      }
   }
   public List<Room> getAllRooms() { return rooms; }
}
