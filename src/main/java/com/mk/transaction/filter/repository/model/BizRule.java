/**
 * An entity class represents all the business rules which needs to be validate for an transaction in a database 
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
public class BizRule {
	
	/*
	 * This is the primary of the table and represents a biz rule id.
	 */
	@Id
	private Long id;
	
	/*
	 * It contains the type of forex transaction for which the rule needs to validate.
	 */
	private String type;
	
	/*
	 * The business validate logic in the form of a query to validate for each fx transaction .
	 */
	private String customQuery;
	
	/*
	 * An exception message which needs to send to client while we have fails such business rule.
	 */
	private String exceptionMessage;
	
	/*
	 * We have leverage of make active or inactive the rule on run time.
	 */
	private String active;
	
	//getter setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCustomQuery() {
		return customQuery;
	}
	public void setCustomQuery(String customQuery) {
		this.customQuery = customQuery;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
}
