package com.cognizant.PharmacyMedicineSupplyPortal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author POD 13
 *
 */
class MedicineSupplyAndDemandTest {

	/**
	 * 
	 */
	@Test
	void testGetMedicineName() {
		MedicineSupplyAndDemand medicineSupplyAndDemand = new MedicineSupplyAndDemand("medicine", 1000, 1000);
		assertEquals("medicine", medicineSupplyAndDemand.getMedicineName(), "Same medicine");
	}

	/**
	 * 
	 */
	@Test
	void testGetDemandCount() {
		MedicineSupplyAndDemand medicineSupplyAndDemand = new MedicineSupplyAndDemand("medicine", 1000, 1000);
		assertEquals(1000, medicineSupplyAndDemand.getDemandCount(), "Equal demand count");
	}

	/**
	 * 
	 */
	@Test
	void testGetSupplyCount() {
		MedicineSupplyAndDemand medicineSupplyAndDemand = new MedicineSupplyAndDemand("medicine", 1000, 1000);
		assertEquals(1000, medicineSupplyAndDemand.getSupplyCount(), "Equal supply count");
	}

	/**
	 * 
	 */
	@Test
	void testSetMedicineName() {
		MedicineSupplyAndDemand medicineSupplyAndDemand = new MedicineSupplyAndDemand();
		medicineSupplyAndDemand.setMedicineName("medicine");
		assertEquals("medicine", medicineSupplyAndDemand.getMedicineName(), "Same medicine");
	}

	/**
	 * 
	 */
	@Test
	void testSetDemandCount() {
		MedicineSupplyAndDemand medicineSupplyAndDemand = new MedicineSupplyAndDemand();
		medicineSupplyAndDemand.setDemandCount(1000);
		assertEquals(1000, medicineSupplyAndDemand.getDemandCount(), "Equal demand count");
	}

	/**
	 * 
	 */
	@Test
	void testSetSupplyCount() {
		MedicineSupplyAndDemand medicineSupplyAndDemand = new MedicineSupplyAndDemand();
		medicineSupplyAndDemand.setSupplyCount(1000);
		assertEquals(1000, medicineSupplyAndDemand.getSupplyCount(), "Equal Supply count");
	}

}
