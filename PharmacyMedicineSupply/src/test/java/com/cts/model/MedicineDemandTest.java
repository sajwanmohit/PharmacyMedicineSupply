package com.cts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class MedicineDemandTest {

	@Test
	void testGetMedicineName() {
		MedicineDemand medicineDemand = new MedicineDemand("medicine", 1000);
		assertEquals("medicine", medicineDemand.getMedicineName());
	}

	@Test
	void testGetDemandCount() {
		MedicineDemand medicineDemand = new MedicineDemand("medicine", 1000);
		assertEquals(1000, medicineDemand.getDemandCount());
	}

	@Test
	void testSetMedicineName() {
		MedicineDemand medicineDemand = new MedicineDemand();
		medicineDemand.setMedicineName("medicine");
		assertNotNull(medicineDemand.getMedicineName());
	}

	@Test
	void testSetDemandCount() {
		MedicineDemand medicineDemand = new MedicineDemand();
		medicineDemand.setDemandCount(1000);
		assertEquals(1000, medicineDemand.getDemandCount(), "Equal");
	}

}
