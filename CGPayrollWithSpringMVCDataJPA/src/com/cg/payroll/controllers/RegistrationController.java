package com.cg.payroll.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.payroll.bean.Associate;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;

@Controller
public class RegistrationController {
	@Autowired
	PayrollServices payrollServices;
	@RequestMapping(value="/registerUser")
	public String registerUser(@Valid@ModelAttribute("associate")Associate associate, BindingResult result){
		try {
			if(result.hasErrors())return "registrationPage";
			payrollServices.acceptAssociateDetails(associate);
			return "successPage";
		} catch (PayrollServicesDownException e) {		
		return "errorPage";
		}		
	}
}
