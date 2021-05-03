package com.cts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author POD 13
 *
 */
@ExtendWith(MockitoExtension.class)
class DoctorTest {

	
	@Test
	void testEqualsObject() {
		Doctor doc = new Doctor("doctorName", "treatingAilment", 9876543210L);
		Doctor doc1 = new Doctor("doctorName1", "treatingAilment1", 8976543210L);
		Doctor doc2 = new Doctor("doctorName", "treatingAilment", 9876543210L);
		Doctor doc3 = new Doctor(null,"treatingAilment", 9876543210L);
		Doctor doc4 = new Doctor("doctorName",null, 9876543210L);
		
		assertEquals(Boolean.TRUE,doc.equals(doc), "Returns true");
		assertEquals(Boolean.TRUE,doc.equals(doc2), "Returns true");
		assertEquals(Boolean.FALSE,doc.equals(doc1), "Return false");
		assertEquals(Boolean.FALSE,doc.equals(doc3), "Return false");
		assertEquals(Boolean.FALSE,doc.equals(doc4), "Return false");
		assertEquals(Boolean.FALSE,doc3.equals(doc4), "Return false");
		assertEquals(Boolean.FALSE,doc4.equals(doc), "Return false");
		
		assertEquals(doc.hashCode(), doc2.hashCode(),"Equal hash code");
		assertNotEquals(doc.hashCode(), doc1.hashCode(),"Not Equal hash code");
		
	}

}
