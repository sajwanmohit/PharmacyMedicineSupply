package com.cognizant.PharmacyMedicineSupplyPortal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * @author POD 13
 *
 */
class InputDateTest {

	/**
	 * 
	 */
	@Test
	void testGetDate() {
		InputDate date = new InputDate("22-03-1998");
		assertEquals("22-03-1998", date.getDate(),"Same Date");
	}

	/**
	 * 
	 */
	@Test
	void testSetDate() {
		InputDate date = new InputDate();
		date.setDate("22-03-1998");
		assertNotNull(date.getDate());
	}

}
