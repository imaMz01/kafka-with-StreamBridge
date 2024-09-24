package com.streamBridge.consumer;

import com.streamBridge.consumer.Payload.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.function.Consumer;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}


	@Bean
	public Consumer<String> consumeUser() {
		return user -> System.out.println("Received message: " + user.toString());
	}
}
