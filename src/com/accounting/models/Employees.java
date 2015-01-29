package com.accounting.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;





@Entity
@Table(name="tblEmployees")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tblEmployees_EmployeeType")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3020869722425727716L;

	@Id
	@Column(name="tblEmployees_EmployeeId",unique=true,nullable=false)
	private long employeeId;
	
	@Column(name="tblEmployees_Name")
	private String name;
	
	@Column(name="tblEmployees_Surname")
	private String surname;
	
	@Column(name="tblEmployees_Telephone")
	private String telephone;
	
	@Column(name="tblEmployees_Address")
	private String address;
	
	@OneToMany(mappedBy="employees",fetch=FetchType.EAGER)
	private Set <Receivables> receivables;
	
	@OneToMany(mappedBy="employees")
	private Set <Payabless> payables;
	
	public Set<Receivables> getReceivables() {
		return receivables;
	}
	public void setReceivables(Set<Receivables> receivables) {
		this.receivables = receivables;
	}
	public Set<Payabless> getPayables() {
		return payables;
	}
	public void setPayables(Set<Payabless> payables) {
		this.payables = payables;
	}
	public Employees() {
		super();
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
