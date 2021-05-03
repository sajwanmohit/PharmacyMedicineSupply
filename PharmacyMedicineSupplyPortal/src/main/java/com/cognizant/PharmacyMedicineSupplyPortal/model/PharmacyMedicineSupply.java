package com.cognizant.PharmacyMedicineSupplyPortal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author POD 13
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PharmacyMedicineSupply {

	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private String pharmacyName;
	/**
	 * 
	 */
	private String medicineName;
	/**
	 * 
	 */
	private int supplyCount;

}
