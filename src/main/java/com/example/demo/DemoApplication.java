package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting process");
		Thread.sleep(5000);
		System.out.println("finish process");
	}


	//This bean is create to enable metrics. This is the workaround defined in https://github.com/spring-projects/spring-integration/issues/3420
	@Bean
	MeterRegistry otherMeterRegistry(){
		return new SimpleMeterRegistry();
	}
}
