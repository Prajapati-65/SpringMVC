package com.bridgeit.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@RequestMapping(value = "/admissionForm", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		System.out.println("dskfghsd");
		ModelAndView model = new ModelAndView("admissionForm");
		return model;
	}
	@RequestMapping(value = "/submitAdmissionForm")
	public ModelAndView submitAdmissionForm() {
		System.out.println("dskfghsd");
		ModelAndView model = new ModelAndView("submitAdmissionForm");
		return model;
	}
	
	@RequestMapping(value = "/admissionForm")
	public ModelAndView submit1AdmissionForm(@RequestParam("firstname") String fname , @RequestParam("lastname") String lname) 
	{
		ModelAndView model = new ModelAndView("admissionForm");
		model.addObject("msg" , "Hello Bridgelabz "+" First name "+fname+" Last name "+lname);
		return model;
	}
}
