package com.cognizant.PharmacyMedicineSupplyPortal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.PharmacyMedicineSupplyPortal.entity.DemandAndSupply;
import com.cognizant.PharmacyMedicineSupplyPortal.repository.MedicineSupplyAndDemandRespository;

/**
 * @author POD 13
 *
 */
@ExtendWith(MockitoExtension.class)
class DataBaseServiceTest {

	/**
	 * 
	 */
	@Mock
	private MedicineSupplyAndDemandRespository medsRepo;

	/**
	 * 
	 */
	@InjectMocks
	private DataBaseServiceImpl databaseService;

	/**
	 * @throws Exception
	 */

	/**
	 * 
	 */
	@Test
	void testSave() {
		DemandAndSupply demandAndSupply = new DemandAndSupply("medicineName", "username", 200, 200);

		doReturn(demandAndSupply).when(medsRepo).save(demandAndSupply);

		DemandAndSupply actual = databaseService.save(demandAndSupply);

		assertEquals(demandAndSupply, actual,"Same objects");
	}

}
