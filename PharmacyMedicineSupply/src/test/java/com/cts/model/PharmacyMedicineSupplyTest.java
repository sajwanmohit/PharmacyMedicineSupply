package com.cts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class PharmacyMedicineSupplyTest {

	@Test
	void testGetPharmacyName() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply("pharmacy", "medicine", 1000);
		assertEquals("pharmacy", pharmacyMedicineSupply.getPharmacyName());
	}

	@Test
	void testGetMedicineName() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply("pharmacy", "medicine", 1000);
		assertEquals("medicine", pharmacyMedicineSupply.getMedicineName());
	}

	@Test
	void testGetSupplyCount() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply("pharmacy", "medicine", 1000);
		assertEquals(1000, pharmacyMedicineSupply.getSupplyCount());
	}

	@Test
	void testSetPharmacyName() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply();
		pharmacyMedicineSupply.setPharmacyName("pharmacy");
		assertNotNull(pharmacyMedicineSupply.getPharmacyName());
	}

	@Test
	void testSetMedicineName() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply();
		pharmacyMedicineSupply.setMedicineName("medicine");
		assertNotNull(pharmacyMedicineSupply.getMedicineName());
	}

	@Test
	void testSetSupplyCount() {
		PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply();
		pharmacyMedicineSupply.setSupplyCount(1000);
		assertEquals(1000, pharmacyMedicineSupply.getSupplyCount(),"Equal");
	}

}
