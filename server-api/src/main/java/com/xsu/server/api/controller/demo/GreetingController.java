package com.xsu.server.api.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name",required = false,defaultValue = "World")String name,Model model){
        model.addAttribute("name",name);
        System.out.println("this is greeting");

        return "greeting";
    }
}
