/**
 * A repository interface which interact with database with HQL contains to have custom query which dynamically
 * send at run time with parameter.
 * @author Sambed
 * @date 30/06/2019
 * @date last update - 
 * @change by - 
 */

package com.mk.transaction.filter.repository;

import java.util.List;

public interface TradeCustomRepository {
	
	/**
	 * Gives the result of the business rule.
	 * @param customQuery
	 * @param id
	 * @return
	 */
	List<String> findQueryResult(String customQuery,Long id);
}
