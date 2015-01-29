package com.accounting.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;




@Entity
@Table(name="tblReceivables")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Receivables implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	@Column(name="tblReceivables_FolioNumber", unique=true, nullable=false)
	private Long folioNumber;
	
	@Column(name="tblReceivables_TypeOfReceivable")
	private String receivableType;
	
	@Column(name="tblReceivables_TransactionDate")
	private Date transactionDate;
	
	@Column(name="tblReceivables_Amount")
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name="tblEmployee_EmployeeId")
	private Employees employees;

	@ManyToOne
	@JoinColumn(name="tblChartOfAccount_ChartId")
	private ChartOfAccounts charts;
	
	public Receivables() {
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
	public String getReceivableType() {
		return receivableType;
	}
	public void setReceivableType(String receivableType) {
		this.receivableType = receivableType;
	}
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
	
	
}
