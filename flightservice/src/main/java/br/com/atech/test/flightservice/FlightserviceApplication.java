package br.com.atech.test.flightservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FlightserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightserviceApplication.class, args);
	}

}
