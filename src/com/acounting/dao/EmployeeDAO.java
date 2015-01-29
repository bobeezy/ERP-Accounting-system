package com.acounting.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accounting.connectionClass.Helper;
import com.accounting.models.Employees;


public class EmployeeDAO {
	
	private SessionFactory session=Helper.getSessionFactory();
	
	public Long saveEmployee(Employees employees)
	{
		
		Session sess=session.openSession();
		sess.beginTransaction();
		sess.saveOrUpdate(employees);
		sess.getTransaction().commit();
		
		sess.close();
		
		return employees.getEmployeeId();
	}
	
	
	public List<Employees> viewAllEmployee()
	{
		Session sess=session.openSession();
		sess.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Employees> employeeList=sess.getNamedQuery("ViewEmployees").list();
		sess.close();
		return employeeList;
	}
	
	public Employees getEmployee(long employeeId)
	{
		Session sess=session.openSession();
		sess.beginTransaction();
		Query query = sess.getNamedQuery("GetEmployee");
		query.setLong(0, employeeId);
		Employees employees=(Employees) query.uniqueResult();
		sess.close();
		return (Employees) employees;
	}
	

public void updateEmployees(Employees employees){
		
		Session sess = session.openSession();
		sess.beginTransaction();

		sess.update(employees);
		sess.getTransaction().commit();

		sess.close();
	}
}
