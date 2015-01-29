package com.accounting.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DiscriminatorValue(value="MoneyOut")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MoneyOut  extends ChartOfAccounts{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MoneyOut() {
		super();
		
	}
	

}
