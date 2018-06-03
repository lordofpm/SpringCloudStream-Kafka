/**
 * 
 */
package com.lordofpm.kfcposmock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lordofpm.coreschema.domain.Order;

/**
 * @author ezhang
 *
 */
@RestController
public class OrderController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(path = "/${location.country}/posprocessor", method = RequestMethod.POST)
	public String postOrderToPOS(@RequestBody Order order) {
		logger.info("Got and processed order successfully and order id is " + order.getId());
		return "success";
	}
}