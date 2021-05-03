package com.cognizant.PharmacyMedicineSupplyPortal.model;

import java.util.Date;

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
	private Date dateOfExpiry;
	/**
	 * 
	 */
	private int noOfTablets;

}
