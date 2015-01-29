package com.accounting.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tblChart")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "GetEmployee", query = "Select * from tblEmployees where tblEmployees_EmployeeId=?", resultClass = Employees.class),
		@NamedNativeQuery(name = "ViewEmployees", query = "Select * from tblEmployees", resultClass = Employees.class),
		@NamedNativeQuery(name = "ViewChart", query = "Select * from tblChart", resultClass = ChartOfAccounts.class),
		@NamedNativeQuery(name = "GetCharts", query = "Select * from tblChart where tblChart_ChartId=?",resultClass = ChartOfAccounts.class),
		@NamedNativeQuery(name = "GetPayable", query = "Select * from tblPayables where tblPayables_FolioNumber=?",resultClass = Payabless.class),
		@NamedNativeQuery(name = "GetReceivable", query = "Select * from tblReceivables where tblReceivables_FolioNumber=?",resultClass = Receivables.class) })

@NamedQueries(value = { @NamedQuery(name = "ViewReceivables", query = "From Receivables"),
		@NamedQuery(name = "ViewPayables", query = "From Payabless") })

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ChartOfAccounts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tblChart_ChartId", unique = true, nullable = false)
	private Long chartId;

	@Column(name = "tblChart_ChartNumber")
	private Long chartNumber;

	@Column(name = "tblChart_Description")
	private String chartDescription;

	
	@OneToMany(mappedBy="charts",cascade=CascadeType.ALL)
	private List <Payabless> payables;

	@OneToMany(mappedBy="charts",cascade=CascadeType.ALL)
	private List<Receivables> receivables;
	 

	public ChartOfAccounts() {
		super();
	}

	public Long getChartId() {
		return chartId;
	}

	public void setChartId(Long chartId) {
		this.chartId = chartId;
	}

	public String getChartDescription() {
		return chartDescription;
	}

	public void setChartDescription(String chartDescription) {
		this.chartDescription = chartDescription;
	}

	public Long getChartNumber() {
		return chartNumber;
	}

	public void setChartNumber(Long chartNumber) {
		this.chartNumber = chartNumber;
	}

	public List<Payabless> getPayables() {
		return payables;
	}

	public void setPayables(List<Payabless> payables) {
		this.payables = payables;
	}

	public List<Receivables> getReceivables() {
		return receivables;
	}

	public void setReceivables(List<Receivables> receivables) {
		this.receivables = receivables;
	}

	

}
