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
            // Third filter: requests to /employeezone will be restricted to users with the STAFF role
            // Fourth filter: requests to /actuator will be restricted to users with the ADMIN role
            // Fifth filter: requests to /reservedzone and /actuator will be restricted to users with the OWNER role
      ).
      // Part 2: Specify login form
      formLogin
      (
         (form) ->
            // Login page is /login. Unauthenticated requests must be permitted, or login will be impossible
            // If I use the MVC framework, Spring Security will only provide the POST mapping for /login and leave
            // the GET mapping to myself. Therefore, I must create separately a controller that provides the /login GET
            // In this case I created it on class LoginController
            // We will use for now a minimal form snarfed from https://spring.io/guides/gs/securing-web/
            form.loginPage("/login").permitAll()
      ).
      // Part 3: Specify logout form
      logout
      (
         // Logout must also be allowed for everyone
         // Note: this defines the security of the logout URL, not the logout itself; logout must be implemented
         // manually with a regular view controller.
         // In this case I did it with class LogoutController, by working with the underlying servlet request and response
         (logout) -> logout.logoutUrl("/logout").permitAll()
      );

      // We finish our filter chain function by returning a built HTTP configuration
      return http.build();
   }

   // Next, we need an user details service bean.
   // We will start with a simple hard-coded user directory
   // We obviously are going to have to figure out how to use an actual user repository on a real backend!
   @Bean public UserDetailsService userDetailsService()
   {
      // To add multiple hard-coded users, we need to create several instances of UserDetails, create an
      // InMemoryUserDetailsManager, and add each user to that manager
      // Note: withDefaultPasswordEncoder is apparently marked as deprecated as a warning against using it on Production,
      // which is something I'm going to take care of shortly
      UserDetails regularuser = User.withDefaultPasswordEncoder().username("regularuser").password("sooperseekrit").roles("USER").build();
      UserDetails employee = User.withDefaultPasswordEncoder().username("employee").password("sooperseekrit").roles("STAFF").build();
      UserDetails sysadmin = User.withDefaultPasswordEncoder().username("sysadmin").password("sooperseekrit").roles("ADMIN").build();
      UserDetails zacatenango = User.withDefaultPasswordEncoder().username("zacatenango").password("sooperseekrit").roles("OWNER").build();

      // With our users created, we create an empty InMemoryUserDetailsManager and add our users
      InMemoryUserDetailsManager usersdatabase = new InMemoryUserDetailsManager();
      usersdatabase.createUser(regularuser);
      usersdatabase.createUser(employee);
      usersdatabase.createUser(sysadmin);
      usersdatabase.createUser(zacatenango);

      // We return our hard-coded users database
      return usersdatabase;
   }
}
