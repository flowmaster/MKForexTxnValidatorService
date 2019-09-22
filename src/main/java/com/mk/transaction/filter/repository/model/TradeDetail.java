/**
 * A pojo class to map and bind the request body towards each trade detail transaction. 
 * @author Sambed
 * @date 30/06/2019
 * @date last update - 
 * @change by - 
 */

package com.mk.transaction.filter.repository.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.mk.transaction.filter.repository.model.view.View;

public class TradeDetail {

	/*
	 * Map the test element which is root in the given json schema to the trade object.
	 */
	@JsonView(View.ValidationResultView.class)
	private List<Trades> test;

	public List<Trades> getTest() {
		return test;
	}

	public void setTest(List<Trades> test) {
		this.test = test;
	}
	
}
