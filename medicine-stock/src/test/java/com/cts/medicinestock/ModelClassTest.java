package com.cts.medicinestock;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.cts.medicinestock.model.Medicine;

/**
 * @author POD 13
 *
 */
class ModelClassTest {

	/**
	 * 
	 */
	@Test
	void medicineModelClassTest() {

		Medicine medicine = new Medicine();
		medicine.setMedicineName("PanD");
		medicine.setChemicalComposition("Fe");
		medicine.setDateOfExpiry("2021-10-10");
		medicine.setNoOfTablets(100);
		medicine.setTargetAilment("General");

		Medicine expected = new Medicine("PanD", "Fe", "General", "2021-10-10", 100);
		assertNotNull(expected);
		
	
		

	}
}
