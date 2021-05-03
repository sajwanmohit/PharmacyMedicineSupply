package com.cognizant.PharmacyMedicineSupplyPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author POD 13
 *
 */
@SpringBootApplication
@EnableFeignClients
public class PharmacyMedicineSupplyPortalApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PharmacyMedicineSupplyPortalApplication.class, args);
	}

}
