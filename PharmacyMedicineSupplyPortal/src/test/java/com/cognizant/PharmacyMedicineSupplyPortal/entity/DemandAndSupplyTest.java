package com.cognizant.PharmacyMedicineSupplyPortal.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author POD 13
 *
 */
@ExtendWith(MockitoExtension.class)
class DemandAndSupplyTest {

	/**
	 * 
	 */
	@Test
	void testGetId() {
		DemandAndSupply demandAndSupply = new DemandAndSupply(1, "username", "medicine", 1000, 1000);
		assertEquals(1, demandAndSupply.getId(), "Equal Integer");
	}

	/**
	 * 
	 */
	@Test
	void testGetUsername() {
		DemandAndSupply demandAndSupply = new DemandAndSupply(1, "username", "medicine", 1000, 1000);
		assertEquals("username", demandAndSupply.getUsername(), "Same username");
	}

	/**
	 * 
	 */
	@Test
	void testGetMedicineName() {
		DemandAndSupply demandAndSupply = new DemandAndSupply(1, "username", "medicine", 1000, 1000);
		assertEquals("medicine", demandAndSupply.getMedicineName(), "Same medicine");
	}

	/**
	 * 
	 */
	@Test
	void testGetDemand() {
		DemandAndSupply demandAndSupply = new DemandAndSupply(1, "username", "medicine", 1000, 1000);
		assertEquals(1000, demandAndSupply.getDemand(), "Equal Demand");
	}

	/**
	 * 
	 */
	@Test
	void testGetSupply() {
		DemandAndSupply demandAndSupply = new DemandAndSupply(1, "medicine", "username", 1000, 1000);
		assertEquals(1000, demandAndSupply.getSupply(), "Equal Supply");
	}

	/**
	 * 
	 */
	@Test
	void testSetId() {
		DemandAndSupply demandAndSupply = new DemandAndSupply();
		demandAndSupply.setId(1);
		assertNotNull(demandAndSupply.getId());
	}

	/**
	 * 
	 */
	@Test
	void testSetUsername() {
		DemandAndSupply demandAndSupply = new DemandAndSupply();
		demandAndSupply.setUsername("username");

		assertNotNull(demandAndSupply.getUsername());
	}

	/**
	 * 
	 */
	@Test
	void testSetMedicineName() {
		DemandAndSupply demandAndSupply = new DemandAndSupply();
		demandAndSupply.setMedicineName("medicine");

		assertNotNull(demandAndSupply.getMedicineName());
	}

	/**
	 * 
	 */
	@Test
	void testSetDemand() {
		DemandAndSupply demandAndSupply = new DemandAndSupply();
		demandAndSupply.setDemand(1000);

		assertNotNull(demandAndSupply.getDemand());
	}

	/**
	 * 
	 */
	@Test
	void testSetSupply() {
		DemandAndSupply demandAndSupply = new DemandAndSupply();
		demandAndSupply.setSupply(1000);
		assertNotNull(demandAndSupply.getSupply());
	}

}
