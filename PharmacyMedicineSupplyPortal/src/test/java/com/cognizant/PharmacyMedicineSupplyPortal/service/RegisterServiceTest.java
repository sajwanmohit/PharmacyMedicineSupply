package com.cognizant.PharmacyMedicineSupplyPortal.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.PharmacyMedicineSupplyPortal.client.AuthServiceClient;
import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;

/**
 * @author POD 13
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@ExtendWith(MockitoExtension.class)
class RegisterServiceTest {

	/**
	 * 
	 */
	@InjectMocks
	private RegisterServiceImpl registerService;

	/**
	 * 
	 */
	@Mock
	private AuthServiceClient authClient;

	/**
	 * 
	 */
	@Test
	public void registerUserSuccessTest() {

		ResponseEntity<Login> response = new ResponseEntity(new Login(), HttpStatus.NOT_FOUND);

		Login l = new Login();
		l.setUsername("username");
		l.setPassword("password");

		doReturn(response).when(authClient).register(l);

		String actual = registerService.registerUserNameAndPassword(l);

		assertNull(actual);

	}

	/**
	 * 
	 */
	@Test
	public void registerUserFailedTest() {

		ResponseEntity<Login> response = new ResponseEntity(new Login("username", "password"), HttpStatus.OK);

		Login l = new Login();
		l.setUsername("username");
		l.setPassword("password");

		doReturn(response).when(authClient).register(l);

		String actual = registerService.registerUserNameAndPassword(l);

		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertNotNull(response.getBody());

		assertEquals("login", actual);

	}

}
