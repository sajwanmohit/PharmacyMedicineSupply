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
class RepScheduleTest {

	/**
	 * 
	 */
	@Test
	void testEqualsObject() {
		RepSchedule rep = new RepSchedule();
		RepSchedule rep1 = new RepSchedule("Rep_1", "Doc_1", "Orthopaedics", "medicine1, medicine2", "1 PM to 2 PM",
				"04-08-2021", 9884122113L);
		RepSchedule rep2 = new RepSchedule("Rep_1", "Doc_1", "Orthopaedics", "medicine1, medicine2", "1 PM to 2 PM",
				"04-08-2021", 9884122113L);
		RepSchedule rep3 = new RepSchedule("Rep_2", "Doc_2", "General", "medicine3, medicine4", "1 PM to 2 PM",
				"05-08-2021", 9876543210L);
		RepSchedule rep4 = new RepSchedule(null, "Doc_1", "Orthopaedics", "medicine1, medicine2", "1 PM to 2 PM",
				"04-08-2021", 9884122113L);
		RepSchedule rep5 = new RepSchedule("Rep_1", null,"Orthopaedics", "medicine1, medicine2", "1 PM to 2 PM",
				"04-08-2021", 9884122113L);
		RepSchedule rep6 = new RepSchedule("Rep_1", "Doc_1", null, "medicine1, medicine2", "1 PM to 2 PM",
				"04-08-2021", 9884122113L);
		RepSchedule rep7 = new RepSchedule("Rep_1", "Doc_1", "Orthopaedics", null, "1 PM to 2 PM",
				"04-08-2021", 9884122113L);
		RepSchedule rep8 = new RepSchedule("Rep_1", "Doc_1", "Orthopaedics", "medicine1, medicine2", null,
				"04-08-2021", 9884122113L);
		RepSchedule rep9 = new RepSchedule("Rep_1", "Doc_1", "Orthopaedics", "medicine1, medicine2", "1 PM to 2 PM",
				null, 9884122113L);
		RepSchedule rep10 = new RepSchedule("Rep_1", "Doc_1", "Orthopaedics", "medicine1, medicine2", "1 PM to 2 PM",
				null, 9884122110L);
		RepSchedule rep11 = new RepSchedule("Rep_13", "Doc_1", "Orthopaedics", "medicine1, medicine2", "1 PM to 2 PM",
				null, 9884122113L);
		RepSchedule rep12 = new RepSchedule("Rep_1", "Doc_1", "Orthopaedics", "medicindse1, medicine2", null,
				"04-08-2021", 9884122113L);
		RepSchedule rep13 = new RepSchedule("Rep_1", "Doc_1", "Orthopaedics", "medicine1, medicine2", "1PM to 2 PM",
				null, 9884122113L);
		RepSchedule rep14 = new RepSchedule("Rep_1", "Doc_1", "Orthopaedadfics", "medicine1, medicine2", "1 PM to 2 PM",
				null, 9884122113L);
		
		assertEquals(Boolean.TRUE,rep1.equals(rep1), "Returns true");
		assertEquals(Boolean.TRUE,rep1.equals(rep2), "Returns true");
		assertEquals(Boolean.FALSE,rep1.equals(null), "Return false");
		assertEquals(Boolean.FALSE,rep1.equals(rep3), "Return false");
		assertEquals(Boolean.FALSE,rep9.equals(rep8), "Return false");
		assertEquals(Boolean.FALSE,rep9.equals(rep10), "Return false");
		assertEquals(Boolean.FALSE,rep4.equals(rep5), "Return false");
		assertEquals(Boolean.FALSE,rep9.equals(rep11), "Return false");
		assertEquals(Boolean.FALSE,rep7.equals(rep8), "Return false");
		assertEquals(Boolean.FALSE,rep8.equals(rep12), "Return false");
		assertEquals(Boolean.FALSE,rep4.equals(rep1), "Return false");
		assertEquals(Boolean.FALSE,rep8.equals(rep1), "Return false");
		assertEquals(Boolean.FALSE,rep5.equals(rep6), "Return false");
		assertEquals(Boolean.FALSE,rep9.equals(rep13), "Return false");
		assertEquals(Boolean.FALSE,rep6.equals(rep1), "Return false");
		assertEquals(Boolean.FALSE,rep9.equals(rep14), "Return false");
		
		assertEquals(rep1.hashCode(), rep2.hashCode(),"Equal hash code");
		assertNotEquals(rep.hashCode(), rep1.hashCode(),"Not Equal hash code");
	}

}
