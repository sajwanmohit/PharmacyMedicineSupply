package com.cts.PharmacyMedicineSupply;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author POD 13
 *
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PharmacyMedicineSupplyApplicationTest {
	
	
	/**
	 * 
	 */
	@Test
	void testMain() {
		assertTrue(true);
		String[] args = {};
		PharmacyMedicineSupplyApplication.main(args);
	}


}
