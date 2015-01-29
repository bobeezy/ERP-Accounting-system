package com.accounting.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DiscriminatorValue(value="MoneyIn")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MoneyIn extends ChartOfAccounts {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MoneyIn() {
		super();
		// TODO Auto-generated constructor stub
	}

}
