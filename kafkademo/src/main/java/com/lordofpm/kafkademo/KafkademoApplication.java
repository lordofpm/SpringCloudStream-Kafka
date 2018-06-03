package com.lordofpm.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.lordofpm.kafkademo.channel.OrderChannel;

@SpringBootApplication
@ComponentScan(basePackages = { "com.lordofpm" })
@EnableBinding({ OrderChannel.class, Sink.class, Source.class })
@EnableScheduling
public class KafkademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkademoApplication.class, args);
	}
}
