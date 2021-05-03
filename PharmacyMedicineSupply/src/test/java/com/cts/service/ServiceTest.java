package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.service.PharmaciesService;

/**
 * @author POD 13
 *
 */
@ExtendWith(MockitoExtension.class)
class ServiceTest {

	
	/**
	 * 
	 */
	@InjectMocks
	PharmaciesService service;
	
	/**
	 * 
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * 
	 */
	@Test
	void getPhatmacyNamesTest() {
		
		List<String> expected = new ArrayList<>();
		expected.add("PharmacyA");
		expected.add("PharmacyB");
		expected.add("PharmacyC");
		expected.add("PharmacyD");
		expected.add("PharmacyE");

		List<String> actual = service.getPharmacyNames();
		assertEquals(actual, expected,"Equal List");

	}
}
