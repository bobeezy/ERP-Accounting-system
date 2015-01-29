package com.accounting.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="tlbEmployees")
@DiscriminatorValue(value="Manager")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Manager extends Employees implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
}
