package com.bridgeit.restController.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeit.restController.model.Message;
 
 
@RestController
public class HelloRestController {
 
    @RequestMapping("/")
    public String welcome() {
        return "Welcome to RestController .......";
    }
 
    @RequestMapping("/hello/{player}")
    public Message message(@PathVariable("player") String player) {
        Message msg = new Message(player, "Hello " + player);
        return msg;
    }
}
