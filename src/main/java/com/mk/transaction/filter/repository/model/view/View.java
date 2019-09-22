/**
 * This is a view fragmentation class in a hierarchical structure .
 * Each view is meant for a response by this we are only expose to the detail which only required by the client.
 * ValidationResultView - This only used for the validate the forex transaction put request.
 * @author Sambed
 * @date 30/06/2019
 * @date last update - 
 * @change by -
 */
package com.mk.transaction.filter.repository.model.view;

public class View {
	/**
	 *This view used to render validated response for each transaction. 
	 */
	public interface ValidationResultView {}
	
}
