package com.example.zacatenango.initialbootapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller public class RestrictedPages
{
   @GetMapping("/userzone") public String userzone() { return "userzone"; }
   @GetMapping("/employeezone") public String employeezone() { return "employeezone"; }
}
