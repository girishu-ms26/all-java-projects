package com.mphasis.springmvcdemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MyFirstController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		ModelAndView mav = new ModelAndView("HelloPage");
		mav.addObject("M1","Hi everyone from java 210 !!");
		mav.addObject("M2","Welcome to republic day program");
		mav.addObject("M3","This is awesome");
		return mav;
	}

}
