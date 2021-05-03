package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.client.AuthServiceClient;
import com.cts.client.StockClient;
import com.cts.exception.TokenInvalidException;
import com.cts.model.Medicine;
import com.cts.model.MedicineDemand;
import com.cts.model.PharmacyMedicineSupply;
import com.cts.service.PharmaciesService;
import com.cts.service.PharmacyMedicineSupplyService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author POD 13
 *
 */
@Slf4j
@RestController
public class SupplyController {

	/**
	 * 
	 */
	@Autowired
	private AuthServiceClient authClient;

	/**
	 * 
	 */
	@Autowired
	private PharmaciesService pharmacyService;

	/**
	 * 
	 */
	@Autowired
	private StockClient stockClient;

	/**
	 * 
	 */
	@Autowired
	private PharmacyMedicineSupplyService medicineSupplyService;

	/**
	 * @param authorization
	 * @param medicineDemands
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/PharmacySupply", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<PharmacyMedicineSupply> getSupply(@RequestHeader("Authorization") String authorization,
			@RequestBody List<MedicineDemand> medicineDemands){
		log.debug("in getSupply() of SupplyController " + authorization);

		boolean response = authClient.validate(authorization);
		log.debug("Validated : " + response);
		if (response) {

			List<String> pharmacyNames = pharmacyService.getPharmacyNames();
			log.debug("collecting");
			List<Medicine> stocks = stockClient.retrieveAllMedicines(authorization);
			log.debug("collected");
			return medicineSupplyService.get(pharmacyNames, stocks, medicineDemands);
			
		}else {
			throw new TokenInvalidException("USER UNAUTHORIZED");
		}
	}
}
