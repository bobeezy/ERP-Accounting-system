package com.acounting.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accounting.connectionClass.Helper;
import com.accounting.models.Receivables;

public class ReceivablesDAO {
	
	private SessionFactory session=Helper.getSessionFactory();
	HttpServletRequest sesss;
	
	public Long saveReceivables(Receivables income) {

		Session sess=session.openSession();
	
		sess.beginTransaction();
		
		sess.save(income);
		sess.getTransaction().commit();
		
		sess.close();
		return income.getFolioNumber();
	}
	
	public List<Receivables> viewReceivables() {
		
		Session sess=session.openSession();
		sess.beginTransaction();
		Query query = sess.getNamedQuery("ViewReceivables");
		@SuppressWarnings("unchecked")
		List<Receivables> receives= query.list();
		sess.close();
		return receives;
	}
	
	public Receivables getReceivables(long folioNumber)
	{
		Session sess=session.openSession();
		sess.beginTransaction();
		
		Query query=sess.getNamedQuery("GetReceivable");
		query.setLong(0,folioNumber );
		Receivables receivables=(Receivables)query.uniqueResult();
		sess.close();
		return (Receivables) receivables;
	}
	
	public void updateRecievables(Receivables receivables)
	{
		Session sess=session.openSession();
		sess.beginTransaction();
		
		sess.update(receivables);
		sess.getTransaction().commit();
		sess.close();
	}
}
