package com.example.zacatenango.initialbootapp;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// If Spring MVC is in use, logout must be implemented manually with a view controller
@Controller public class LogoutController
{
   // To perform logout we're going to have to delve into the low-level Jakarta Servlet API and retrieve our HTTP
   // request and response objects. This is done by passing jakarta.servlet.http.HttpServletRequest and
   // HttpServletResponse parameters into our view controller function.
   // No problem with doing that, because we're not going to operate these objects directly; we're still going to
   // stick to Spring's built-in facilities.
   @PostMapping("/logout") public String logout(HttpServletRequest request, HttpServletResponse response)
   {
      // We get an instance of Spring's authentication facility
      Authentication spring_auth_facility = SecurityContextHolder.getContext().getAuthentication();
      if (spring_auth_facility != null)
      {
         // If the auth facility loaded properly, we load an instance of our security context handler and run
         // logout(request, response, <authentication facility>)
         new SecurityContextLogoutHandler().logout(request, response, spring_auth_facility);
      }

      // If we return "redirect:<URL>" instead of just a view name, Spring will redirect to that view instead.
      return "redirect:/login?logout";
   }
}
