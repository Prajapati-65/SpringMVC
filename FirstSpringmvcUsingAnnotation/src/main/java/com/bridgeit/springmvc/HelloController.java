package com.bridgeit.springmvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello/{firstName}/{lastName}")
	public ModelAndView helloWorld(@PathVariable("firstName") String fname, @PathVariable("lastName") String lname)
	{
		ModelAndView modelandview = new ModelAndView("welcome");
		modelandview.addObject("msg" ,"Hello bridgeit  First name--> "+fname +" Last Name --> "+lname);
		return modelandview;
	}


	
	/*
	@RequestMapping("/hello/{firstName}/{lastName}")
	public ModelAndView helloWorld(@PathVariable Map<String, String> pathval)
	{
		String fname = pathval.get("firstName");
		String lname = pathval.get("lastName");
		
		ModelAndView modelandview = new ModelAndView("welcome");
		modelandview.addObject("msg" ,"Hello bridgeit  First name--> "+fname +" Last Name --> "+lname);
		return modelandview;
	}
	
	*/
	
	
	
	
	
	
	
	
	/*
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld()
	{
		ModelAndView modelandview = new ModelAndView("welcome");
		modelandview.addObject("msg" ,"Hello bridgeit ");
		return modelandview;
	}
	
	@RequestMapping("/hi")
	public ModelAndView hiWorld()
	{
		ModelAndView modelandview = new ModelAndView("welcome");
		modelandview.addObject("msg" ,"Hi bridgeit--");
		return modelandview;
	}
	
	*/
	
	
	
	
}
