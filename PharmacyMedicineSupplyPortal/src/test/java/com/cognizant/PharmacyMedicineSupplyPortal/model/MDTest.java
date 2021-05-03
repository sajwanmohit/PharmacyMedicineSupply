package com.cognizant.PharmacyMedicineSupplyPortal.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author POD 13
 *
 */
class MDTest {

	/**
	 * 
	 */
	@Test
	void testGetMedicineName() {
		MD md = new MD("medicine", 1000);
		assertEquals("medicine", md.getMedicineName(), "Same medicine");
	}

	/**
	 * 
	 */
	@Test
	void testGetDemandCount() {
		MD md = new MD("medicine", 1000);
		assertEquals(1000, md.getDemandCount(), "Same demand count");
	}

	/**
	 * 
	 */
	@Test
	void testSetMedicineName() {
		MD md = new MD();
		md.setMedicineName("medicine");
		assertNotNull(md.getMedicineName());
	}

	/**
	 * 
	 */
	@Test
	void testSetDemandCount() {
		MD md = new MD();
		md.setDemandCount(1000);
		assertNotNull(md.getDemandCount());
	}

}
