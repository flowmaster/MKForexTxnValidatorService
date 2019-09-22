/**
 * A repository interface which interact with database with HQL contains various abstract method  with different
 * entity. 
 * @author Sambed
 * @date 30/06/2019
 * @date last update - 
 * @change by - 
 */

package com.mk.transaction.filter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mk.transaction.filter.repository.model.Trades;
public interface TradeRepository extends JpaRepository<Trades, Long> ,TradeCustomRepository {

	/**
	 * Get all the business rules for type of forex transaction.
	 * @param type
	 * @return
	 */
	@Query("select br.customQuery from BizRule br where br.type in( ?1 ,'ALL')")
	List<String> getRulesForProduct(String type);
	
	/**
	 * Find all the currency related attribute of the forex transaction independent to type of it .
	 * @param id
	 * @return
	 */
	@Query("select td.ccyPair,td.payCcy,td.premiumCcy,td.premiumType from Trades td where td.id = ?1")
	List<String> findByCurrency(Long id);
	
	/**
	 * Get the respective error message for each business rule which fails in validation.
	 * @param query
	 * @return
	 */
	@Query("select br.exceptionMessage from BizRule br where br.customQuery = ?1")
	String findByException(String query);
	
}
