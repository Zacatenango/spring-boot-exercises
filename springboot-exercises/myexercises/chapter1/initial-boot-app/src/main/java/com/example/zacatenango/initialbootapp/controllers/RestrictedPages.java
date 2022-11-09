package com.example.zacatenango.initialbootapp.controllers;

import com.example.zacatenango.initialbootapp.models.UserMessagesRepository;
import com.example.zacatenango.initialbootapp.models.UserMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller public class RestrictedPages
{
   private UserMessagesService userMessagesService;
   @Autowired public RestrictedPages(UserMessagesService userMessagesService)
   {
      super(); this.userMessagesService = userMessagesService;
   }

   @GetMapping("/userzone") public String userzone(Model viewcontext)
   {
      viewcontext.addAttribute("messages", this.userMessagesService.getAllUserMessages());
      return "userzone";
   }

   @GetMapping("/employeezone") public String employeezone() { return "employeezone"; }
}
