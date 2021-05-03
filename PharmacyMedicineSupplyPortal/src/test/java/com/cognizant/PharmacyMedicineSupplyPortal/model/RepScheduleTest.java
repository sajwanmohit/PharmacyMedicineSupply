package com.cognizant.PharmacyMedicineSupplyPortal.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * @author POD 13
 *
 */
class RepScheduleTest {

	/**
	 * 
	 */
	@Test
	void testGetRepName() {

		RepSchedule repSchedule = new RepSchedule("Rep1", "Doctor", "Ailment", "medicine", "07-07-20", "07-08-20",
				941132000);
		assertEquals("Same representative","Rep1", repSchedule.getRepName());
	}

	/**
	 * 
	 */
	@Test
	void testGetDoctorName() {
		RepSchedule repSchedule = new RepSchedule("Rep1", "Doctor", "Ailment", "medicine", "07-07-20", "07-08-20",
				941132000);
		assertEquals("Same doctor","Doctor", repSchedule.getDoctorName());
	}

	/**
	 * 
	 */
	@Test
	void testGetTreatingAilment() {
		RepSchedule repSchedule = new RepSchedule("Rep1", "Doctor", "Ailment", "medicine", "07-07-20", "07-08-20",
				941132000);
		assertEquals("Same ailment","Ailment", repSchedule.getTreatingAilment());
	}

	/**
	 * 
	 */
	@Test
	void testGetMedicine() {
		RepSchedule repSchedule = new RepSchedule("Rep1", "Doctor", "Ailment", "medicine", "07-07-20", "07-08-20",
				941132000);
		assertEquals("Same medicine","medicine", repSchedule.getMedicine());
	}

	/**
	 * 
	 */
	@Test
	void testGetSlot() {
		RepSchedule repSchedule = new RepSchedule("Rep1", "Doctor", "Ailment", "medicine", "07-07-20", "07-08-20",
				941132000);
		assertEquals("Same slot","07-07-20", repSchedule.getSlot());
	}

	/**
	 * 
	 */
	@Test
	void testGetDate() {
		RepSchedule repSchedule = new RepSchedule("Rep1", "Doctor", "Ailment", "medicine", "07-07-20", "07-08-20",
				941132000);
		assertEquals("Same date","07-08-20", repSchedule.getDate());
	}

	/**
	 * 
	 */
	@Test
	void testGetDoctorContact() {
		RepSchedule repSchedule = new RepSchedule("Rep1", "Doctor", "Ailment", "medicine", "07-07-20", "07-08-20",
				9411320000L);
		assertEquals("Same contact",9411320000L, repSchedule.getDoctorContact());
	}

	/**
	 * 
	 */
	@Test
	void testSetRepName() {
		RepSchedule repSchedule = new RepSchedule();
		repSchedule.setRepName("Rep1");
		assertNotNull(repSchedule.getRepName());
	}

	/**
	 * 
	 */
	@Test
	void testSetDoctorName() {
		RepSchedule repSchedule = new RepSchedule();
		repSchedule.setDoctorName("Doctor");
		assertNotNull(repSchedule.getDoctorName());
	}

	/**
	 * 
	 */
	@Test
	void testSetTreatingAilment() {
		RepSchedule repSchedule = new RepSchedule();
		repSchedule.setTreatingAilment("Ailment");
		assertNotNull(repSchedule.getTreatingAilment());
	}

	/**
	 * 
	 */
	@Test
	void testSetMedicine() {
		RepSchedule repSchedule = new RepSchedule();
		repSchedule.setMedicine("medicine");
		assertNotNull(repSchedule.getMedicine());
	}

	/**
	 * 
	 */
	@Test
	void testSetSlot() {
		RepSchedule repSchedule = new RepSchedule();
		repSchedule.setSlot("07-07-20");
		assertNotNull(repSchedule.getSlot());
	}

	/**
	 * 
	 */
	@Test
	void testSetDate() {
		RepSchedule repSchedule = new RepSchedule();
		repSchedule.setDate("07-07-20");
		assertNotNull(repSchedule.getDate());
	}

	/**
	 * 
	 */
	@Test
	void testSetDoctorContact() {
		RepSchedule repSchedule = new RepSchedule();
		repSchedule.setDoctorContact(941132000);
		assertNotNull(repSchedule.getDoctorContact());
	}

}
