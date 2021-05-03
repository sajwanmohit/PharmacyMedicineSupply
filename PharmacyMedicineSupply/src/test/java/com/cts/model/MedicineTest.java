package com.cts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class MedicineTest {

	@Test
	void testGetMedicineName() {
		Medicine medicine = new Medicine("PanD", "Fe", "General", "2021-10-10", 100);
		assertEquals("PanD", medicine.getMedicineName());
	}

	@Test
	void testGetChemicalComposition() {
		Medicine medicine = new Medicine("PanD", "Fe", "General", "2021-10-10", 100);
		assertEquals("Fe", medicine.getChemicalComposition());
	}

	@Test
	void testGetTargetAilment() {
		Medicine medicine = new Medicine("PanD", "Fe", "General", "2021-10-10", 100);
		assertEquals("General", medicine.getTargetAilment());
	}

	@Test
	void testGetDateOfExpiry() {
		Medicine medicine = new Medicine("PanD", "Fe", "General", "2021-10-10", 100);
		assertEquals("2021-10-10", medicine.getDateOfExpiry());
	}

	@Test
	void testGetNoOfTablets() {
		Medicine medicine = new Medicine("PanD", "Fe", "General", "2021-10-10", 100);
		assertEquals(100, medicine.getNoOfTablets());
	}

	@Test
	void testSetMedicineName() {
		Medicine medicine = new Medicine();
		medicine.setMedicineName("PanD");
		assertNotNull(medicine.getMedicineName());
	}

	@Test
	void testSetChemicalComposition() {
		Medicine medicine = new Medicine();
		medicine.setChemicalComposition("Fe");
		assertNotNull(medicine.getChemicalComposition());
	}

	@Test
	void testSetTargetAilment() {
		Medicine medicine = new Medicine();
		medicine.setTargetAilment("General");
		assertNotNull(medicine.getTargetAilment());
	}

	@Test
	void testSetDateOfExpiry() {
		Medicine medicine = new Medicine();
		medicine.setDateOfExpiry("2021-10-10");
		assertNotNull(medicine.getDateOfExpiry());
	}

	@Test
	void testSetNoOfTablets() {
		Medicine medicine = new Medicine();
		medicine.setNoOfTablets(100);
		assertEquals(100, medicine.getNoOfTablets(),"Equal");
	}

}
