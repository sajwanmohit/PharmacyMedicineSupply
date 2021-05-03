package com.cognizant.PharmacyMedicineSupplyPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.PharmacyMedicineSupplyPortal.client.AuthServiceClient;
import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author POD 13
 *
 */
@Slf4j
@Service
public class RegisterServiceImpl implements RegisterService {

	/**
	 * 
	 */
	@Autowired
	private AuthServiceClient authServiceClient;

	/**
	 *
	 */
	@Override
	public String registerUserNameAndPassword(Login user) {
		ResponseEntity<Login> response = null;
		try {
		response = authServiceClient.register(user);
		if (response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null) {
			log.debug("Body: {} ", response.getBody());
			return "login";
		}
		
	
	}
	catch(FeignException e) {
		return null;
	}
		return null;
}
}