package com.cognizant.PharmacyMedicineSupplyPortal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.PharmacyMedicineSupplyPortal.model.JwtResponse;
import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;

/**
 * @author POD 13
 *
 */
@FeignClient(name = "authentication-service", url = "http://localhost:8081/api/auth")
public interface AuthServiceClient {

	/**
	 * @param login
	 * @return
	 */
	@PostMapping("/signin")
	ResponseEntity<JwtResponse> authenticateUserAndGetDetails(@RequestBody Login login);

	/**
	 * @param token
	 * @return
	 */
	@PostMapping("/validate")
	public boolean validateAndReturnUser(@RequestHeader("Authorization") String token);

	/**
	 * @param user
	 * @return
	 */
	@PostMapping("/register")
	public ResponseEntity<Login> register(@RequestBody Login user);

}