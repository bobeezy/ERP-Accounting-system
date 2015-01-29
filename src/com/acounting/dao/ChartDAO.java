package com.acounting.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accounting.connectionClass.Helper;
import com.accounting.models.ChartOfAccounts;

public class ChartDAO // implements ChartInterface
{

	private SessionFactory session = Helper.getSessionFactory();

	public Long saveChart(ChartOfAccounts chart) {

		Session sess = session.openSession();
		sess.beginTransaction();
		sess.save(chart);
		Long ids = chart.getChartId();
		sess.getTransaction().commit();
		sess.close();

		return ids;
	}

	public List<ChartOfAccounts> viewCharts() {

		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();

		sess.beginTransaction();

		Query query = sess.getNamedQuery("ViewChart");
		@SuppressWarnings("unchecked")
		List<ChartOfAccounts> chat = query.list();

		sess.close();
		return chat;
	}

	public ChartOfAccounts getCharts(long chartId)
	{
		Session sess=session.openSession();
		sess.beginTransaction();
		Query query = sess.getNamedQuery("GetCharts");
		query.setLong(0, chartId);
		ChartOfAccounts chartOfAccounts=(ChartOfAccounts) query.uniqueResult();
		sess.close();
		return (ChartOfAccounts) chartOfAccounts;
	}

	public void updateChart(ChartOfAccounts chartOfAccounts) {

		Session sess = session.openSession();
		sess.beginTransaction();

		sess.update(chartOfAccounts);
		sess.getTransaction().commit();

		sess.close();
	}
}
