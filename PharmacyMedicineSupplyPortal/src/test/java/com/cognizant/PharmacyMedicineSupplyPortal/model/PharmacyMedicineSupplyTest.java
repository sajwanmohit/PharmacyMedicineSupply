package com.cognizant.PharmacyMedicineSupplyPortal.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author POD 13
 *
 */
class PharmacyMedicineSupplyTest {

	/**
	 * 
	 */
	@Test
	void testGetId() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply(1, "pharmacy", "medicine", 100);
		assertEquals(1, pharmacyMedicineSupply.getId(),"Same id");
	}

	/**
	 * 
	 */
	@Test
	void testGetPharmacyName() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply(1, "pharmacy", "medicine", 100);
		assertEquals("pharmacy", pharmacyMedicineSupply.getPharmacyName(),"Same Pharmacy");
	}

	/**
	 * 
	 */
	@Test
	void testGetMedicineName() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply(1, "pharmacy", "medicine", 100);
		assertEquals("medicine", pharmacyMedicineSupply.getMedicineName(),"Same medicine");
	}

	/**
	 * 
	 */
	@Test
	void testGetSupplyCount() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply(1, "pharmacy", "medicine", 100);
		assertEquals(100, pharmacyMedicineSupply.getSupplyCount(),"Equal supply count");
	}

	/**
	 * 
	 */
	@Test
	void testSetId() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply();
		pharmacyMedicineSupply.setId(1);
		assertNotNull(pharmacyMedicineSupply.getId());
	}

	/**
	 * 
	 */
	@Test
	void testSetPharmacyName() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply();
		pharmacyMedicineSupply.setPharmacyName("pharmacy");
		assertNotNull(pharmacyMedicineSupply.getPharmacyName());
	}

	/**
	 * 
	 */
	@Test
	void testSetMedicineName() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply();
		pharmacyMedicineSupply.setMedicineName("medicine");
		assertNotNull(pharmacyMedicineSupply.getMedicineName());
	}

	/**
	 * 
	 */
	@Test
	void testSetSupplyCount() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply();
		pharmacyMedicineSupply.setSupplyCount(100);
		assertNotNull(pharmacyMedicineSupply.getSupplyCount());
	}

}
