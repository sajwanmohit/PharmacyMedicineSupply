
package com.cts.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author POD 13
 *
 */
@FeignClient(name = "authentication-service", url = "localhost:8081/api/auth") // dns/auth-service
public interface AuthServiceFeign {


	/**
	 * @param token
	 * @return
	 */
	@PostMapping("/validate")
	boolean validate(@RequestHeader("Authorization") String token);

}