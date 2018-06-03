/**
 * 
 */
package com.lordofpm.kafkademo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.core.env.Environment;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lordofpm.coreschema.domain.Order;
import com.lordofpm.kafkademo.channel.OrderChannel;

/**
 * @author ezhang
 *
 */
@Service
public class OrderService {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Environment environment;
	@Autowired
	private OrderChannel orderChannel;

	@Scheduled(fixedRateString = "${scheduling.fetchOrderperiod}")
	public void getOrderFromVtexAndPost2Kafka() {
		RestTemplate template = new RestTemplate();
		String vtexService = environment.getProperty("location.vtexService");
		logger.debug("VTEX service is:" + vtexService);
		Order order = template.getForObject(vtexService, Order.class);
		logger.info("Get order from VTEX service:" + order);

		orderChannel.publish().send(MessageBuilder.withPayload(order).build());
		logger.info("Sent order " + order + " to Kafka successfully.");
	}

	@StreamListener(OrderChannel.ORDER_SUBSCRIBE)
	public void handleOrder(Order order) {
		RestTemplate template = new RestTemplate();
		String kfcPosService = environment.getProperty("location.kfcPosService");
		logger.debug("kfcPos service is:" + kfcPosService);
		String result = template.postForObject(kfcPosService, order, String.class);
		logger.info("Post order " + order + " in Kafka to KFC POS and result is " + result);
	}
}
