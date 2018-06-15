package com.cg.payroll.main;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.payroll.bean.Associate;
import com.cg.payroll.bean.BankDetails;
import com.cg.payroll.bean.Salary;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;


public class MainClass {

	public static void main(String[] args) throws PayrollServicesDownException, SQLException, AssociateDetailsNotFoundException {	
		try {
			ApplicationContext applicationContext=new ClassPathXmlApplicationContext("projectbeans.xml");
			PayrollServices payrollServices=(PayrollServices) applicationContext.getBean("payrollServices");

//		payrollServices.acceptAssociateDetails("shravan", "s", "ssk1@gmail.com", "java", "fresher", "BAN231", 13000, 23000, 500, 500, 12312, "sbi", "sbi0943");
//		payrollServices.acceptAssociateDetails("rohit", "s", "rohit@gmail.com", "java", "hr", "BAN232", 12000, 22800, 500, 500, 12312, "citi", "citi0943");
//		payrollServices.acceptAssociateDetails("ssk", "s", "ro@gmail.com", "java", "hr", "BAN234", 12000, 22800, 500, 500, 12312, "citi", "citi0943");
//				Associate associate=new Associate(3, 20000, "chintoo", "s", "dotnet", "hr", "DASD23", "chint@gmail.com", new Salary(24000, 600, 600), new BankDetails(234112, "hdfc", "hdfc002"));
//				payrollServices.updateAssociateDetails(associate);
//						payrollServices.deleteAssociateDetails(3);
//			System.out.println(payrollServices.getAssociateDetails(1));
				System.out.println(payrollServices.getAllAssociateDetails());
			System.out.println("true");
		} catch (PayrollServicesDownException e) {
			e.printStackTrace();
		}
	}
}		