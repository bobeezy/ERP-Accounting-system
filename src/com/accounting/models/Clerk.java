package com.accounting.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DiscriminatorValue(value="Clerk")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Clerk extends Employees implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Clerk() {}
}
