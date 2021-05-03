package com.cognizant.PharmacyMedicineSupplyPortal.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author POD 13
 *
 */
class LoginTest {

	/**
	 * 
	 */
	@Test
	void testGetUsername() {

		Login login = new Login();
		login.setUsername("username");
		login.setPassword("password");

		String actual = login.getUsername();
		assertEquals("username", actual, "Same login username");

	}

	/**
	 * 
	 */
	@Test
	void testGetPassword() {
		Login login = new Login();
		login.setUsername("username");
		login.setPassword("password");

		String actual = login.getPassword();
		assertEquals("password", actual, "Same Password");
	}

	/**
	 * 
	 */
	@Test
	void testSetUsername() {
		Login login = new Login();
		login.setUsername("username");
		login.setPassword("password");

		assertNotNull(login.getUsername());
	}

	/**
	 * 
	 */
	@Test
	void testSetPassword() {
		Login login = new Login();
		login.setUsername("username");
		login.setPassword("password");

		assertNotNull(login.getPassword());
	}

}
