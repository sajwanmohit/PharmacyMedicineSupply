package com.cognizant.PharmacyMedicineSupplyPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.PharmacyMedicineSupplyPortal.client.AuthServiceClient;
import com.cognizant.PharmacyMedicineSupplyPortal.model.JwtResponse;
import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author POD 13
 *
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

	/**
	 * 
	 */
	@Autowired
	private AuthServiceClient authServiceClient;

	/**
	 *
	 */
	@Override
	public String validateUserNameAndPassword(Login login) {
		ResponseEntity<JwtResponse> response = null;
		try {
		response = authServiceClient.authenticateUserAndGetDetails(login);
		if (response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null) {
			log.warn(response.getBody().getToken());
			return response.getBody().getToken();
		} else {
			return null;
		}
		}
		catch(FeignException e){
			return null;
		}
	}

	/**
	 *
	 */
	@Override
	public String getUsername(Login login) {
		ResponseEntity<JwtResponse> response = null;
		response = authServiceClient.authenticateUserAndGetDetails(login);
		if (response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null) {
			return response.getBody().getUsername();
		} else {
			return "login";
		}
	}
}
