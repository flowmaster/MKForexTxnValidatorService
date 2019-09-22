/**
 * An entity object represents all the ISO codes for different currencies.
 * driven mode.
 * @author Sambed
 * @date 30/06/2019
 * @date last update - 
 * @change by - 
 */
package com.mk.transaction.filter.repository.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ISO4217 {

	/*
	 * This is the three character alphabetic code for each country currency. 
	 */
	@Id
	private String alphabeticCode;
	
	/*
	 * Country for which the above currency code driven.
	 */
	private String country;
	
	public String getAlphabeticCode() {
		return alphabeticCode;
	}
	public void setAlphabeticCode(String alphabeticCode) {
		this.alphabeticCode = alphabeticCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
