package com.cts.medicinestock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author POD 13
 *
 */
@EnableFeignClients("com.cts.medicinestock.client")
@SpringBootApplication
public class MedicineStockApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MedicineStockApplication.class, args);
	}

}
