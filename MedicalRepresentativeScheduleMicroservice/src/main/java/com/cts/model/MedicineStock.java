package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author POD 13
 *
 */
@SuppressWarnings("unused")
@AllArgsConstructor
public class MedicineStock {
	/**
	 * Medicine name
	 */
	@Getter
	private String medicineName;
	/**
	 * Chemical composition of medicine
	 */
	private String chemicalComposition;
	/**
	 * Ailment for which this medicine is used
	 */
	@Getter
	private String targetAilment;
	/**
	 * Expiry date of the medicine
	 */
	private String dateOfExpiry;
	/**
	 * Stock count of the medicine
	 */
	private int noOfTablets;

}
