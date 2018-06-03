package com.lordofpm.vtexmock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.lordofpm")
public class VtexmockApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtexmockApplication.class, args);
	}
}
