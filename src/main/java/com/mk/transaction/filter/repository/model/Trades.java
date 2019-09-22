/**
 * An entity class represents all the data of the forex transaction and populate to the table for future 
 * reference purpose and based on this records different business rules will get validated. 
 * @author Sambed
 * @date 30/06/2019
 * @date last update - 
 * @change by - 
 */

package com.mk.transaction.filter.repository.model;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.mk.transaction.filter.repository.model.view.View;

@Entity
@ApiModel(description = "All detail about the TRADE_DETAIL")
public class Trades {

	/*
	 * An unique id for each transaction and based on which even validation result will be render to client 
	 */
	@Id
	@GeneratedValue
	@JsonView(View.ValidationResultView.class)
	private Long id;
	private String customer;
	private String ccyPair;
	private String type;
	private String direction;
	private Date tradeDate;
	private Double amount1;
	private Double amount2;
	private Double rate;
	private Date valueDate;
	private String legalEntity;
	private String trader;
	private String style;
	private String strategy;
	private Date deliveryDate;
	private Date expiryDate;
	private Date excerciseStartDate;
	private String payCcy;
	private Double premium;
	private String premiumCcy;
	private String premiumType;
	private Date premiumDate;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	@JsonView(View.ValidationResultView.class)
	private List<String> validationResult ;

	public List<String> getValidationResult() {
		return validationResult;
	}

	public void setValidationResult(List<String> validationResult) {
		this.validationResult = validationResult;
	}
	
	
	public Date getExcerciseStartDate() {
		return excerciseStartDate;
	}
	public void setExcerciseStartDate(Date excerciseStartDate) {
		this.excerciseStartDate = excerciseStartDate;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getPayCcy() {
		return payCcy;
	}
	public void setPayCcy(String payCcy) {
		this.payCcy = payCcy;
	}
	public Double getPremium() {
		return premium;
	}
	public void setPremium(Double premium) {
		this.premium = premium;
	}
	public String getPremiumCcy() {
		return premiumCcy;
	}
	public void setPremiumCcy(String premiumCcy) {
		this.premiumCcy = premiumCcy;
	}
	public String getPremiumType() {
		return premiumType;
	}
	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}
	public Date getPremiumDate() {
		return premiumDate;
	}
	public void setPremiumDate(Date premiumDate) {
		this.premiumDate = premiumDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCcyPair() {
		return ccyPair;
	}
	public void setCcyPair(String ccyPair) {
		this.ccyPair = ccyPair;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public Double getAmount1() {
		return amount1;
	}
	public void setAmount1(Double amount1) {
		this.amount1 = amount1;
	}
	public Double getAmount2() {
		return amount2;
	}
	public void setAmount2(Double amount2) {
		this.amount2 = amount2;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Date getValueDate() {
		return valueDate;
	}
	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}
	public String getLegalEntity() {
		return legalEntity;
	}
	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}
	public String getTrader() {
		return trader;
	}
	public void setTrader(String trader) {
		this.trader = trader;
	}
	
}
