package com.cognizant.PharmacyMedicineSupplyPortal.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author POD 13
 *
 */
class JwtResponseTest {

	/**
	 * 
	 */
	@Test
	void testGetId() {
		List<String> roles = new ArrayList<>();
		roles.add("role");
		JwtResponse jwtResponse = new JwtResponse(1, "token", "username", roles);
		assertEquals(1, jwtResponse.getId(), "Same Id");
	}

	/**
	 * 
	 */
	@Test
	void testGetToken() {
		List<String> roles = new ArrayList<>();
		roles.add("role");
		JwtResponse jwtResponse = new JwtResponse(1, "token", "username", roles);
		assertEquals("token", jwtResponse.getToken(), "Same Token");
	}

	/**
	 * 
	 */
	@Test
	void testGetUsername() {
		List<String> roles = new ArrayList<>();
		roles.add("role");
		JwtResponse jwtResponse = new JwtResponse(1, "token", "username", roles);
		assertEquals("username", jwtResponse.getUsername(), "Same username");
	}

	/**
	 * 
	 */
	@Test
	void testGetRoles() {
		List<String> roles = new ArrayList<>();
		roles.add("role");
		JwtResponse jwtResponse = new JwtResponse(1, "token", "username", roles);
		assertEquals(roles, jwtResponse.getRoles(), "Equal roles");
	}

	/**
	 * 
	 */
	@Test
	void testSetId() {
		JwtResponse jwtResponse = new JwtResponse();
		jwtResponse.setId(1);
		assertNotNull(jwtResponse.getId());
	}

	/**
	 * 
	 */
	@Test
	void testSetToken() {
		JwtResponse jwtResponse = new JwtResponse();
		jwtResponse.setToken("token");
		assertNotNull(jwtResponse.getToken());

	}

	/**
	 * 
	 */
	@Test
	void testSetUsername() {
		JwtResponse jwtResponse = new JwtResponse();
		jwtResponse.setUsername("username");
		assertNotNull(jwtResponse.getUsername());
	}

	/**
	 * 
	 */
	@Test
	void testSetRoles() {
		List<String> roles = new ArrayList<>();
		roles.add("role");
		JwtResponse jwtResponse = new JwtResponse();
		jwtResponse.setRoles(roles);
		assertNotNull(jwtResponse.getRoles());
	}

}