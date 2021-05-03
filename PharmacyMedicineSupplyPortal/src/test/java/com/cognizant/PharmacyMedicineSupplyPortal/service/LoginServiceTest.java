package com.cognizant.PharmacyMedicineSupplyPortal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.PharmacyMedicineSupplyPortal.client.AuthServiceClient;
import com.cognizant.PharmacyMedicineSupplyPortal.model.JwtResponse;
import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;

/**
 * @author POD 13
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

	/**
	 * 
	 */
	@InjectMocks
	private LoginServiceImpl loginService;

	/**
	 * 
	 */
	@Mock
	private AuthServiceClient authClient;

	/**
	 * 
	 */
	@Test
	void testGetUsernameSuccess() {
		Login login = new Login("username", "password");
		List<String> roles = new ArrayList<>();
		roles.add("roles");
		ResponseEntity<JwtResponse> response = new ResponseEntity(new JwtResponse(1, "token", "username", roles),
				HttpStatus.OK);

		doReturn(response).when(authClient).authenticateUserAndGetDetails(login);

		String actual = loginService.getUsername(login);

		assertEquals("username", actual);

	}

	/**
	 * 
	 */
	@Test
	void testGetUsernameFailed() {
		Login login = new Login("username", "password");
		List<String> roles = new ArrayList<>();
		roles.add("roles");
		ResponseEntity<JwtResponse> response = new ResponseEntity(new JwtResponse(), HttpStatus.NOT_FOUND);

		doReturn(response).when(authClient).authenticateUserAndGetDetails(login);

		String actual = loginService.getUsername(login);

		assertEquals("login", actual);

	}

	/**
	 * 
	 */
	@Test
	void validateUserNameAndPasswordSuccess() {
		Login login = new Login("username", "password");
		List<String> roles = new ArrayList<>();
		roles.add("roles");
		ResponseEntity<JwtResponse> response = new ResponseEntity(new JwtResponse(1, "token", "username", roles),
				HttpStatus.OK);

		doReturn(response).when(authClient).authenticateUserAndGetDetails(login);

		String actual = loginService.validateUserNameAndPassword(login);

		String expected = response.getBody().getToken();
		assertEquals(expected, actual);

	}

	@Test
	void validateUserNameAndPasswordFailed() {
		Login login = new Login("username", "password");
		List<String> roles = new ArrayList<>();
		roles.add("roles");
		ResponseEntity<JwtResponse> response = new ResponseEntity(new JwtResponse(), HttpStatus.NOT_FOUND);

		doReturn(response).when(authClient).authenticateUserAndGetDetails(login);

		String actual = loginService.validateUserNameAndPassword(login);

		assertEquals("login", actual);

	}

}
