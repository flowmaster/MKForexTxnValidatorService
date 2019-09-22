/**
 * A repository implementation of the custom query executor . 
 * @author Sambed
 * @date 30/06/2019
 * @date last update - 
 * @change by - 
 */

package com.mk.transaction.filter.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class TradeCustomRepositoryImpl implements TradeCustomRepository {

	@PersistenceContext
	private EntityManager em; 
	
	/**
	 * Execute the business rule for each require transaction.
	 */
	@Override
	public List<String> findQueryResult(String customQuery,Long id) {
		Query q = em.createNativeQuery(customQuery);
		q.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<String> result = q.getResultList();
		
		return result;
	}

}
