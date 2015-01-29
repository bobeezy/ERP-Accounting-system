package com.accounting.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="tblPayables")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Payabless implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6291419976741608713L;

	@Id
	@Column(name="tblPayables_FolioNumber", unique=true, nullable=false)
	private Long folioNumber;

	@Column(name="tblPayables_TypeOfPayableType")
	private String payableType;
	
	@Column(name="tblPayables_TransactionDate")
	private Date transactionDate;
	
	@Column(name="tblPayables_Amount")
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name="tblEmployee_EmployeeId")
	private Employees employees;

	@ManyToOne
	@JoinColumn(name="tblChartOfAccount_ChartId")
	private ChartOfAccounts charts;
	
	public Employees getEmployee() {
		return employees;
	}
	public void setEmployee(Employees employee) {
		this.employees = employee;
	}
	public ChartOfAccounts getChart() {
		return charts;
	}
	public void setChart(ChartOfAccounts chart) {
		this.charts = chart;
	}
	public Payabless() {
		super();
	}
	public Long getFolioNumber() {
		return folioNumber;
	}
	public void setFolioNumber(Long folioNumber) {
		this.folioNumber = folioNumber;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPayableType() {
		return payableType;
	}
	public void setPayableType(String payableType) {
		this.payableType = payableType;
	}
	
	
	
}
