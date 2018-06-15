package com.cg.payroll.daoservices;

import java.sql.SQLException;
import java.util.List;

import com.cg.payroll.bean.Associate;

public interface PayrollDAOServices {

	int insertAssociate(Associate associate)throws SQLException;

	boolean updateAssociate(Associate associate)throws SQLException;

	boolean deleteAssociate(int associateID);

	Associate getAssociate(int associateID);

	List<Associate> getAssociates();

}