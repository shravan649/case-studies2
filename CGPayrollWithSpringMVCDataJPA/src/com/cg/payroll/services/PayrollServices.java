package com.cg.payroll.services;

import java.sql.SQLException;
import java.util.List;

import com.cg.payroll.bean.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public interface PayrollServices {

	int acceptAssociateDetails(Associate associate)throws PayrollServicesDownException;

	float calculateNetSalary(int associateID)throws AssociateDetailsNotFoundException,PayrollServicesDownException,SQLException;
	
	boolean deleteAssociateDetails(int associateID)throws PayrollServicesDownException;
	
	boolean updateAssociateDetails(Associate associate)throws PayrollServicesDownException,SQLException;

	Associate getAssociateDetails(int associateID)throws AssociateDetailsNotFoundException, PayrollServicesDownException;

	List<Associate> getAllAssociateDetails()throws PayrollServicesDownException;

}