package com.cts.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author POD 13
 *
 */
@FeignClient(name = "auth", url = "localhost:8081/api/auth")
public interface AuthServiceClient {

	/**
	 * @param token
	 * @return
	 */
	@PostMapping("/validate")
	public boolean validate(@RequestHeader("Authorization") String token);

}