package com.mk.transaction.filter.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mk.transaction.filter.controller.TradeController;
import com.mk.transaction.filter.service.TradeService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = TradeController.class, secure = false)
public class TradeControllerTest {
	
	/**
	 * This stipulate to have a exception assertion rule .
	 */
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	/**
	 * Invoke the before advice of the Mockito for initiation
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Inject mockmvc 
	 */
	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * Inject trade service as a mock bean
	 */
	@MockBean
	TradeService tradeService;
	
	/**
	 * Injecting controller to serve end point 
	 */
	@InjectMocks
	TradeController tradeController;	

	
	/**
	 * Invokes sign-up verification end point and match the expected and returned status code .
	 */
	@Test
	public void signupVerificationTest(){
		String signinJson = "{ \"test\": [      {\"customer\":\"PLUTO1\",\"ccyPair\":\"EURUSD\",\"type\":\"Spot\",\"direction\":\"BUY\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.12,\"valueDate\":\"2016-08-15\",\"legalEntity\":\"CS Zurich\",\"trader\":\"JohannBaumfiddler\"}]}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/fxtrade-validator")
				.accept(MediaType.APPLICATION_JSON).content(signinJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
