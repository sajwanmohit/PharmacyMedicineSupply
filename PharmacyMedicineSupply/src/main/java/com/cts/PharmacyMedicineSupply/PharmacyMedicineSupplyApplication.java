package com.cts.PharmacyMedicineSupply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author POD 13
 *
 */
@SpringBootApplication
@EnableFeignClients("com.cts.client")
@ComponentScan("com.cts")
public class PharmacyMedicineSupplyApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SpringApplication.run(PharmacyMedicineSupplyApplication.class, args);
	}

}
