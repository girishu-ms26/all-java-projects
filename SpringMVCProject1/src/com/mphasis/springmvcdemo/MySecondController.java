package com.mphasis.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/greet")
public class MySecondController {
	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		
		ModelAndView mav = new ModelAndView("HelloPage");
		mav.addObject("M1","Hi Girishu");
		mav.addObject("M2","How are You");
		mav.addObject("M3","Welcome");
		return mav;
	}
	@RequestMapping("/bye")
	public ModelAndView sayBye() {
		
		ModelAndView mav = new ModelAndView("HelloPage");
		mav.addObject("M11", "Hi Girishu 1");
		mav.addObject("M22","How are You 1");
		mav.addObject("M33","Welcome 1");
		return mav;
		
	}
}
