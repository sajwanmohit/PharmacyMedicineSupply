package com.cts.application;

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
class MedicalRepresentativeScheduleMicroserviceApplicationTests {
	
	
	/**
	 * 
	 */
	@Test
	void contextLoads() {
		assertTrue(true);
		String[] args = {};
		MedicalRepresentativeScheduleMicroserviceApplication.main(args);
	}

}
