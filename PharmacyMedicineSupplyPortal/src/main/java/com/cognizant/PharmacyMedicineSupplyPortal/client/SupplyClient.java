package com.cognizant.PharmacyMedicineSupplyPortal.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.PharmacyMedicineSupplyPortal.model.MD;
import com.cognizant.PharmacyMedicineSupplyPortal.model.PharmacyMedicineSupply;

/**
 * @author POD 13
 *
 */
@FeignClient(name = "supply-service", url = "http://localhost:8082")
public interface SupplyClient {

	/**
	 * @param authorization
	 * @param medicineDemands
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/PharmacySupply")
	public List<PharmacyMedicineSupply> getSupply(@RequestHeader("Authorization") String authorization,
			@RequestBody List<MD> medicineDemands) throws Exception;

}
