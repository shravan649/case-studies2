package com.cg.payroll.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.payroll.bean.Associate;
@Controller
public class URIController {
	@RequestMapping(value="/")
	public String getIndexPage(){
		return "indexPage";
	}
	@RequestMapping(value="/login")
	public String getLoginPage(){
		return "loginPage";
	}
	@RequestMapping(value="/registration")
	public String getRegistrationPage(){
		return "registrationPage";
	}
	@ModelAttribute("associate")
	public Associate getAttribute(){
		return new Associate();
	}

}
