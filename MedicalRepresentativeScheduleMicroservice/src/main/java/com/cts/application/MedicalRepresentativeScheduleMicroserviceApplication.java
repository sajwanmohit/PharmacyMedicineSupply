package com.cts.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author POD 13
 *
 */
@SpringBootApplication
@EnableFeignClients("com.cts.feign")
@ComponentScan("com.cts")
public class MedicalRepresentativeScheduleMicroserviceApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MedicalRepresentativeScheduleMicroserviceApplication.class, args);
	}

}
