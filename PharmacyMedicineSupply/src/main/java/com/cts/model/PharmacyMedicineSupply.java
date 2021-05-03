package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class PharmacyMedicineSupply {

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
