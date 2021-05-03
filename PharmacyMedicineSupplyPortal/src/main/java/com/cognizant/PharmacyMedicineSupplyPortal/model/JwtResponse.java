package com.cognizant.PharmacyMedicineSupplyPortal.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author POD 13
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

	/**
	 * 
	 */
	private long id;
	/**
	 * 
	 */
	private String token;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private List<String> roles;

}