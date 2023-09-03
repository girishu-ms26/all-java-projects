package com.mphasis.studentadmissiondemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
	
	@RequestMapping(value="/showAdmissionForm", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		
		ModelAndView model = new ModelAndView("AdmissionForm");
				
		return model;
	}
	
	@RequestMapping("/showAdmissionStatus")
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String Sname,
											@RequestParam("branch") String Sbranch) {
		ModelAndView model = new ModelAndView("AdmissionStatusPage");
		model.addObject("Message","Student Name is "+Sname+" and Branch is "+Sbranch);
		return model;
		
	}
}
