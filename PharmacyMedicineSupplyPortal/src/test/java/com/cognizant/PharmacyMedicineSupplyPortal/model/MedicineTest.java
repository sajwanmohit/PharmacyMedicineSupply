package com.cognizant.PharmacyMedicineSupplyPortal.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

/**
 * @author POD 13
 *
 */
class MedicineTest {

	/**
	 * 
	 */
	@InjectMocks
	private Medicine medicine;

	/**
	 * 
	 */
	@Test
	void testGetMedicineName() {
		Medicine medicine = new Medicine("Orthoherb", "Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam", "Orthopaedics",
				new Date(2021 - 04 - 04), 4000);

		String actual = medicine.getMedicineName();
		assertEquals("Orthoherb", actual, "Same medicine");
	}

	/**
	 * 
	 */
	@Test
	void testGetChemicalComposition() {
		Medicine medicine = new Medicine("Orthoherb", "Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam", "Orthopaedics",
				new Date(2021 - 04 - 04), 4000);

		String actual = medicine.getChemicalComposition();
		assertEquals("Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam", actual, "Same composotion");
	}

	/**
	 * 
	 */
	@Test
	void testGetTargetAilment() {
		Medicine medicine = new Medicine("Orthoherb", "Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam", "Orthopaedics",
				new Date(2021 - 04 - 04), 4000);

		String actual = medicine.getTargetAilment();
		assertEquals("Orthopaedics", actual, "Same ailment");
	}

	/**
	 * 
	 */
	@Test
	void testGetDateOfExpiry() {
		Medicine medicine = new Medicine("Orthoherb", "Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam", "Orthopaedics",
				new Date(2021 - 04 - 04), 4000);

		Date actual = medicine.getDateOfExpiry();
		assertEquals(new Date(2021 - 04 - 04), actual, "Same expiry");

	}

	/**
	 * 
	 */
	@Test
	void testGetNoOfTablets() {
		Medicine medicine = new Medicine("Orthoherb", "Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam", "Orthopaedics",
				new Date(2021 - 04 - 04), 4000);

		int actual = medicine.getNoOfTablets();
		assertEquals(4000, actual, "Equal stock");
	}

	/**
	 * 
	 */
	@Test
	void testSetMedicineName() {
		Medicine medicine = new Medicine();
		medicine.setMedicineName("Orthoherb");
		assertNotNull(medicine.getMedicineName());

	}

	/**
	 * 
	 */
	@Test
	void testSetChemicalComposition() {
		Medicine medicine = new Medicine();
		medicine.setChemicalComposition("Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam");
		assertNotNull(medicine.getChemicalComposition());
	}

	/**
	 * 
	 */
	@Test
	void testSetTargetAilment() {
		Medicine medicine = new Medicine();
		medicine.setTargetAilment("Orthopaedics");
		assertNotNull(medicine.getTargetAilment());
	}

	/**
	 * 
	 */
	@Test
	void testSetDateOfExpiry() {
		Medicine medicine = new Medicine();
		medicine.setDateOfExpiry(new Date(2021 - 04 - 04));
		assertNotNull(medicine.getDateOfExpiry());
	}

	/**
	 * 
	 */
	@Test
	void testSetNoOfTablets() {
		Medicine medicine = new Medicine();
		medicine.setNoOfTablets(1000);

		assertNotNull(medicine.getNoOfTablets());
	}

}
