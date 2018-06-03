/**
 * 
 */
package com.lordofpm.kafkademo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ezhang
 *
 */
@RestController
public class OrderController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Source source;

	/**
	 * 
	 */
	@RequestMapping(path = "/postTestMessage/{message}", method = RequestMethod.GET)
	public void postMessage(@PathVariable String message) {
		source.output().send(MessageBuilder.withPayload(message).build());
		logger.info("Sent out message " + message);
	}

	@StreamListener(Sink.INPUT)
	public void handleInput(String message) {
		logger.info("Get message from topic output:" + message);
	}
}