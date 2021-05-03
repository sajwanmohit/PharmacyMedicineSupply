package com.cts.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.model.MedicineStock;

/**
 * @author POD 13
 *
 */
@Configuration
@FeignClient(name = "medicine-stock", url = "localhost:8091")
public interface MedicineStockFeign {

	/**
	 * @param authorization 
	 * @return
	 */
	@GetMapping("/all-stocks")
	List<MedicineStock> retrieveAllMedicines(@RequestHeader("Authorization")final String authorization);
}
