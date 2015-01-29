package com.acounting.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accounting.connectionClass.Helper;
import com.accounting.models.Payabless;

public class PayablesDAO {
	private SessionFactory session=Helper.getSessionFactory();
	public void savePayables(Payabless payments) {
		
		Session sess=session.openSession();
		sess.beginTransaction();
		sess.save(payments);
		
		sess.getTransaction().commit();
		sess.close();
		
	}

	public List<Payabless> viewPayments() {
		SessionFactory session=Helper.getSessionFactory();
		Session sess=session.openSession();
		
		sess.beginTransaction();
		Query query = sess.getNamedQuery("ViewPayables");
	
	@SuppressWarnings("unchecked")
	List<Payabless> payss= query.list();
	sess.close();
		return payss;
	}
	public Payabless getPayable(Long folioNumber)
	{
		Session sess=session.openSession();
		sess.beginTransaction();
		
		Query query=sess.getNamedQuery("GetPayable");
		query.setLong(0, folioNumber);
		Payabless payabless=(Payabless) query.uniqueResult();
		sess.close();
		return (Payabless) payabless;
		
	}
	
	public void updatePayables(Payabless payabless)
	{
		Session sess=session.openSession();
		sess.beginTransaction();
		sess.update(payabless);
		sess.close();
	}
}
