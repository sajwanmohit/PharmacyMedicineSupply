package com.cts.model;

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
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {

	/**
	 * 
	 */
	private String medicineName;
	/**
	 * 
	 */
	private String chemicalComposition;
	/**
	 * 
	 */
	private String targetAilment;
	/**
	 * 
	 */
	private String dateOfExpiry;
	/**
	 * 
	 */
	private int noOfTablets;

}
