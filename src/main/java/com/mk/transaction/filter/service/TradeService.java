/**
 * Provides service to controller and delegate the response after performing necessary action on the request. 
 * driven mode.
 * @author Sambed
 * @date 30/06/2019
 * @date last update - 
 * @change by - 
 */

package com.mk.transaction.filter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.transaction.filter.repository.TradeRepository;
import com.mk.transaction.filter.repository.model.TradeDetail;
import com.mk.transaction.filter.repository.model.Trades;

@Service
public class TradeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TradeService.class);
	
	/*
	 * Injecting repository to service. 
	 */
	@Autowired
	TradeRepository repository;

	private static final String SUCCESS = "SUCCESS" ;

	/*
	 * Declaring the predicate rule for response on the different business rules execution result and based 
	 * on this we can filter the validation .
	 */
	public static Predicate<String> errorPred = s-> !(SUCCESS).equalsIgnoreCase(s);



	/**
	 * Responder on the forex trade transaction and delegate the response back , post validation of all required
	 * rules.
	 * @param tradeDet
	 * @return TradeDetail
	 */
	public TradeDetail tradeValidator(TradeDetail tradeDet)
	{
		List<Trades> validatedTrades = tradeDet.getTest() // this list contains all validation list data
				.stream()
				.map(trades -> rulevalidation(trades))
				.collect(Collectors.toCollection(() -> new ArrayList<Trades>()));
		tradeDet.setTest(validatedTrades);
		return tradeDet ;
	}

	/**
	 * Perform on each transaction and validate the business rules along with it sets the result to it.
	 * This result could contain even the error response while we see the transaction violate the concern rule(s).
	 * @param trade
	 * @return Trades
	 */
	private Trades rulevalidation(Trades trade){
		List<String> result = new ArrayList<String>();
		Trades tradeReg = repository.save(trade);
		//contains the customer query exactly in bizrule table
		List<String> pruductRules = repository.getRulesForProduct(trade.getType().toUpperCase());
		pruductRules.forEach(query -> result.add(getCustomeQueryExeccutor(query,tradeReg.getId())));
		if((trade.getDeliveryDate()!= null) && (!isWeekDay(trade.getDeliveryDate())))
		{
			result.add("VALUE DATE CAN NOT FALL ON WEEKEND");
		}

		if(result.stream().filter(errorPred).count() > 0 ) 
		{
			LOGGER.info("Error exists on this transaction with "+trade.getId());
			trade.setValidationResult(result.stream().filter(errorPred).collect(Collectors.toCollection(() -> new ArrayList<String>())));
		}
		else{
			trade.setValidationResult(Arrays.asList(SUCCESS));
		}
		return trade ;
	}

	/**
	 * Validate each rule which in the form of query and map the result to it.
	 * @param query
	 * @param id
	 * @return
	 */
	private String getCustomeQueryExeccutor(String query,Long id)
	{
		List<String> custReslt = repository.findQueryResult(query,id);
		String result =  custReslt.size() > 0 ? SUCCESS : repository.findByException(query); 
		return result;
	}

	/**
	 * Check the value date if on the weekdays or not.
	 * @param date
	 * @return
	 */
	private boolean isWeekDay(Date date){
		boolean isWeekDay = true ;
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
				cl.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
		{
			isWeekDay = false ;
		}
		return isWeekDay;
	}


}
