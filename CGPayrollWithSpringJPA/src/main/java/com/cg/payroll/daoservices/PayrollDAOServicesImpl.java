package com.cg.payroll.daoservices;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.payroll.bean.Associate;
import com.cg.payroll.bean.BankDetails;
import com.cg.payroll.bean.Salary;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.utilities.PayrollUtility;
@Component(value="payrollDAOServices")
public class PayrollDAOServicesImpl implements PayrollDAOServices {
@Autowired(required=true)
private EntityManagerFactory entityManagerFactory;
	@Override
	public int insertAssociate(Associate associate) throws SQLException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(associate);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate.getAssociateID();
	}

	@Override
	public boolean updateAssociate(Associate associate) throws SQLException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(associate);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}
	@Override
	public boolean deleteAssociate(int associateID) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Associate associate=entityManager.find(Associate.class, associateID);
		entityManager.remove(associate);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public Associate getAssociate(int associateID) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Associate associate = entityManager.find(Associate.class, associateID);
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate;
	}

	@Override
	public List<Associate> getAssociates() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		 Query query=entityManager.createQuery("SELECT a FROM Associate a");
		return (List<Associate>)query.getResultList();
	}	
}