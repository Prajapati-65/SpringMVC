package com.bridgeit.restController.model;

import org.springframework.stereotype.Controller;

@Controller 
public class Message {
 
    String name;
    String text;
 
    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }
 
    public String getName() {
        return name;
    }
 
    public String getText() {
        return text;
    }
 
}