/**
 * Controller to provide service to end point for trade validator .It reads the data on the given schema and 
 * deliver the JSON of transaction id along with validation statement which contains SUCCESS or any error on the 
 * transaction field.
 * @author Sambed
 * @date 30/06/2019
 * @date last update - 
 * @change by - 
 */

package com.mk.transaction.filter.controller;


import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.mk.transaction.filter.repository.model.TradeDetail;
import com.mk.transaction.filter.repository.model.view.View;
import com.mk.transaction.filter.service.TradeService;

@RestController
public class TradeController {

	@Autowired
	TradeService authService;
	
	/**
	 * This expose with POST method endpoint for the trade transaction validation and provides respective response to it. 
	 * @param tradeDet
	 * @return TradeDetail
	 */
	@ApiOperation(value = "Forex Trade Validator")
	@PostMapping("/fxtrade-validator")
	@JsonView(View.ValidationResultView.class)
	public ResponseEntity<TradeDetail> tradeValidator(@RequestBody TradeDetail tradeDet)
	{
		tradeDet =  authService.tradeValidator(tradeDet);
		return ResponseEntity.ok().body(tradeDet);
	}

}
