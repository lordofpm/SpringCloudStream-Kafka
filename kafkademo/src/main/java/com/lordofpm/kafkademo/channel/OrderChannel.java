/**
 * 
 */
package com.lordofpm.kafkademo.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ezhang
 *
 */
public interface OrderChannel {
	public static final String ORDER_PUBLISH = "order" + Source.OUTPUT;
	public static final String ORDER_SUBSCRIBE = "order" + Sink.INPUT;

	@Input(value = ORDER_SUBSCRIBE)
	SubscribableChannel subscribe();

	@Output(value = ORDER_PUBLISH)
	MessageChannel publish();
}
