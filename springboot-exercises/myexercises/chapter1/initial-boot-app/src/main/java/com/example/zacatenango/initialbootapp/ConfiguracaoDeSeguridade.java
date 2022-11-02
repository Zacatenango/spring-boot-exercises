package com.example.zacatenango.initialbootapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// Spring security confugration:
// We start by creating a new class annotated with @Configuration @EnableWebSecurity
@Configuration @EnableWebSecurity public class ConfiguracaoDeSeguridade
{
   // This class has the following function, which receives an HTTP security parameter
   // It works by creating a chain of function calls within a lambda that takes a parameter. Each function call will
   // add URL filters and authentication actions to the security chain, which is what implements the security
   // configuration
   // Note: no, the course's approach doesn't work, it has been deprecated already
   @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
   {
      // Part 1: HTTP request authorization
      http.authorizeHttpRequests
      (
         (requests) ->
            // First filter: unauthenticated requests to / and /home will be permitted
            // This happens because I'm calling permitAll() directly on my antMatchers(), which Spring takes as meaning "all users"
            requests.antMatchers("/", "/home").permitAll().
            // Second filter: all other paths will have to be authenticated
            anyRequest().authenticated()
            // Third filter: requests to /employeezone will be restricted to users in the STAFF group
            // Fourth filter: requests to /reservedzone will be restricted to users in the OWNERS group
      ).
      // Part 2: Specify login form
      formLogin
      (
         (form) ->
            // Login page is /login. Unauthenticated requests must be permitted, or login will be impossible
            // Spring ships with a built in view controller for login whose name is "login", so our template must be
            // src/main/resources/templates/login.html
            // We will use for now a minimal form snarfed from https://spring.io/guides/gs/securing-web/
            form.loginPage("/login").permitAll()
      ).
      // Part 3: Specify logout form
      logout
      (
         // Logout must also be allowed for everyone
         (logout) -> logout.permitAll()
      );

      // We finish our filter chain function by returning a built HTTP configuration
      return http.build();
   }

   // Next, we need an user details service bean.
   // We will start with a simple hard-coded user directory
   // We obviously are going to have to figure out how to use an actual user repository on a real backend!
   @Bean public UserDetailsService userDetailsService()
   {
      // We just up and build an UserDetails object with username "zacatenango", password "sooperseekrit", role "USER"
      UserDetails user = User.withDefaultPasswordEncoder()
         .username("zacatenango")
         .password("sooperseekrit")
         .roles("USER")
         .build();

      return new InMemoryUserDetailsManager(user);
   }
}
