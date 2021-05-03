
package com.cognizant.PharmacyMedicineSupplyPortal.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.PharmacyMedicineSupplyPortal.model.Medicine;

/**
 * @author POD 13
 *
 */
@FeignClient(name = "medicine-stock", url = "http://localhost:8091")
public interface StockClient {

	/**
	 * @param token
	 * @return
	 */
	@GetMapping("/all-stocks")
	public List<Medicine> retrieveAllMedicines(@RequestHeader("Authorization") String token);
}
