package com.cts.medicinestock;

import static org.junit.Assert.assertTrue;

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
class MedicineStockApplicationTest {
	
	/**
	 * 
	 */
	@Test
	void contextLoads() {
		assertTrue(true);
		String[] args = {};
		MedicineStockApplication.main(args);
	}
}
