package com.cognizant.PharmacyMedicineSupplyPortal.model;

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
public class MedicineSupplyAndDemand {

	/**
	 * 
	 */
	private String medicineName;
	/**
	 * 
	 */
	private int demandCount;
	/**
	 * 
	 */
	private int supplyCount;

}
