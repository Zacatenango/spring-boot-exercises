package com.example.zacatenango.initialbootapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// This here is a Spring command line component. It runs when the Spring app is started, but it doesn't spawn a
// Jakarta web server. Instead, it runs the run() method of this class before the web server is started.
// It can be used to create a standalone command line application, but this kind of applications is the domain of the
// Spring fundamentals course instead.
// However, it is still useful for web applications, because in the event that my application requires startup code,
// it will be run on this component and it will be guaranteed to run before my web app starts.
@Component public class RoomCleaningPrimer implements CommandLineRunner
{
   private RestTemplate restTemplate;

   public RoomCleaningPrimer()
   {
      super();
      this.restTemplate = new RestTemplate();
   }

   @Override public void run(String... args) throws Exception
   {
      //String URL = "https://localhost:8000/api/oneroom?roomID=3";
      //Room oneroom = this.restTemplate.getForObject(URL, Room.class);
      System.out.println("Spring command line application started");
      System.out.println("Spring command line application ended");
   }
}
