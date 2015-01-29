package com.accounting.connectionClass;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Helper {
	
	private static final SessionFactory sessionFactory =buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
		try{
		return new Configuration().configure().buildSessionFactory();
		}
		catch(Throwable ex){
			System.err.println("Creation Failed"+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static void shutDown()
	{
		getSessionFactory().close();
	}
			

}
