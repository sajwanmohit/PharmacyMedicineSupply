
package com.cts.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.model.Medicine;

/**
 * @author POD 13
 *
 */
@FeignClient(name = "medicine-stock", url = "localhost:8091")
public interface StockClient {

	/**
	 * @param authorization
	 * @return
	 */
	@GetMapping("/all-stocks")
	public List<Medicine> retrieveAllMedicines(@RequestHeader("Authorization") String authorization);
}
