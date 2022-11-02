package com.example.zacatenango.initialbootapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// This is a minimal login controller that makes /login respond to GET requests.
// It is necessary, because when Spring Security detects the MVC framework in use, it will only provide the POST mapping
// and leave the GET mapping to the developer
@Controller public class LoginController
{
   @GetMapping("/login") public String login()
   {
      return "login";
   }
}
