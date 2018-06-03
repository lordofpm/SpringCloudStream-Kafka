/**
 * 
 */
package com.lordofpm.vtexmock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lordofpm.coreschema.domain.Order;
import com.lordofpm.coreschema.mockservice.SimpleOrderFactory;

/**
 * @author ezhang
 *
 */
@RestController
public class OrderController {
	@Autowired
	private Environment environment;

	@Autowired
	private SimpleOrderFactory simpleOrderFactory;

	@RequestMapping(path = "/${location.country}/order/placedOrer", method = RequestMethod.GET)
	public Order getPlacedOrer() {
		return simpleOrderFactory.getOrderByTimestamp(environment.getProperty("location.country"));
	}
}