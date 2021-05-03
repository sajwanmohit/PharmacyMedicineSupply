package com.cts.medicinestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import com.cts.medicinestock.client.AuthClient;
import com.cts.medicinestock.exception.MedicineNotFoundException;
import com.cts.medicinestock.exception.TokenInvalidException;
import com.cts.medicinestock.model.Medicine;
import com.cts.medicinestock.service.MedicineService;



/**
 * @author POD 13
 *
 */
@RestController
public class MedicineStockController {
	
	/**
	 * 
	 */
	@Autowired
	private AuthClient authClient;
	
	/**
	 * 
	 */
	@Autowired
	private MedicineService service;

	/**
	 * @return
	 */
	@GetMapping("/all-stocks")
	public List<Medicine> retrieveAllMedicines(@RequestHeader("Authorization")final String authorization) {
		final boolean response = authClient.validate(authorization);
		if (response) {
			final List<Medicine> stocks =  service.retireveAllStock();
			
			if(!stocks.isEmpty()) {
				return  stocks;
			}
			else
			{
				throw new MedicineNotFoundException("No Medicine Available"); 
			}
			
		} else {
			throw new TokenInvalidException("USER UNAUTHORIZED");
		}
		
		
	}
	
	
}
