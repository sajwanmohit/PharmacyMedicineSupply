package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.date_formatter.DateFormat;
import com.cts.feign.MedicineStockFeign;
import com.cts.model.Doctor;
import com.cts.model.MedicineStock;
import com.cts.model.RepSchedule;
import com.google.common.collect.Lists;
import com.opencsv.exceptions.CsvValidationException;

/**
 * @author POD 13
 *
 */
@ExtendWith(MockitoExtension.class)
class ScheduleServiceTest {

	/**
	 * 
	 */
	@InjectMocks
	private ScheduleService scheduleService;
	/**
	 * 
	 */
	@Mock
	private MedicineStockFeign feign;

	/**
	 * 
	 */
	@Mock
	private DateFormat format;

	/**
	 * 
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * @throws IOException
	 * @throws CsvValidationException
	 */
	@Test
	void testReadCSV() throws CsvValidationException, IOException {

		List<Doctor> actual = scheduleService.readCSV();

		List<Doctor> expected = new ArrayList<>();
		expected.add(new Doctor("Doc_1", "Orthopaedics", 9884122113L));
		expected.add(new Doctor("Doc_2", "General", 9876543210L));
		expected.add(new Doctor("Doc_3", "General", 9123456780L));
		expected.add(new Doctor("Doc_4", "Orthopaedics", 7891234560L));
		expected.add(new Doctor("Doc_5", "Gynecology", 8976543210L));

		assertEquals(expected, actual,"List is equal");

	}

	/**
	 * 
	 */
	@Test
	void testReadRepresentatives() {
		scheduleService.setNoOfRep(3);
		List<String> actual = scheduleService.readRepresentatives();
		List<String> expected = new ArrayList<>();
		expected.add("Rep_1");
		expected.add("Rep_2");
		expected.add("Rep_3");
		assertEquals(expected, actual, "List is equal");
	}

	/**
	 * Testing medicine By Ailment Function
	 */
	@Test
	void testMedicineByAilment() {
		MedicineStock m1 = new MedicineStock("medicineName", "chemicalComposition", "General", "dateOfExpiry", 1000);
		MedicineStock m2 = new MedicineStock("medicineName2", "chemicalComposition2", "General", "dateOfExpiry2", 1000);
		doReturn(Lists.newArrayList(m1, m2)).when(feign).retrieveAllMedicines("authorization");

		List<MedicineStock> actual = scheduleService.medicineByAilment("authorization","General");
		List<MedicineStock> result = new ArrayList<>();
		List<MedicineStock> meds = feign.retrieveAllMedicines("authorization");
		for (MedicineStock m : meds) {
			if (m.getTargetAilment().equalsIgnoreCase("General")) {
				result.add(m);
			}
		}

		assertEquals(result, actual,"List of medicines based on ailment is tested");

	}
	
	
	/**
	 * 
	 */
	@Test
	void testMedicineByAilmentNoMatch() {
		MedicineStock m1 = new MedicineStock("medicineName", "chemicalComposition", "General", "dateOfExpiry", 1000);
		MedicineStock m2 = new MedicineStock("medicineName2", "chemicalComposition2", "General", "dateOfExpiry2", 1000);
		doReturn(Lists.newArrayList(m1, m2)).when(feign).retrieveAllMedicines("authorization");

		List<MedicineStock> actual = scheduleService.medicineByAilment("authorization","asfadsgad");
		List<MedicineStock> result = new ArrayList<>();

		assertEquals(result, actual,"No matching ailment so empty list");

	}
	

	/**
	 * @throws ParseException
	 * @throws CsvValidationException
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked"})
	@Test
	void testScheduleMeeting() throws ParseException, CsvValidationException, IOException {
		
		scheduleService.setNoOfRep(3);

		RepSchedule rep1 = new RepSchedule("Rep_1", "Doc_1", "Orthopaedics", "medicine1, medicine2", "1 PM to 2 PM",
				"04-08-2021", 9884122113L);
		RepSchedule rep2 = new RepSchedule("Rep_2", "Doc_2", "General", "medicine3, medicine4", "1 PM to 2 PM",
				"05-08-2021", 9876543210L);
		RepSchedule rep3 = new RepSchedule("Rep_3", "Doc_3", "General", "medicine3, medicine4", "1 PM to 2 PM",
				"06-08-2021", 9123456780L);
		RepSchedule rep4 = new RepSchedule("Rep_1", "Doc_4", "Orthopaedics", "medicine1, medicine2", "1 PM to 2 PM",
				"07-08-2021", 7891234560L);
		RepSchedule rep5 = new RepSchedule("Rep_2", "Doc_5", "Gynecology", "medicine5, medicine6", "1 PM to 2 PM",
				"09-08-2021", 8976543210L);
		List<RepSchedule> actual = new ArrayList<>();
		List<RepSchedule> expected = new ArrayList<>();
		expected.add(rep1);
		expected.add(rep2);
		expected.add(rep3);
		expected.add(rep4);
		expected.add(rep5);

		MedicineStock medicine1 = new MedicineStock("medicine1", "chemicalComposition", "Orthopaedics", "dateOfExpiry",
				1000);
		MedicineStock medicine2 = new MedicineStock("medicine2", "chemicalComposition", "Orthopaedics", "dateOfExpiry",
				1000);
		MedicineStock medicine3 = new MedicineStock("medicine3", "chemicalComposition", "General", "dateOfExpiry",
				1000);
		MedicineStock medicine4 = new MedicineStock("medicine4", "chemicalComposition", "General", "dateOfExpiry",
				1000);
		MedicineStock medicine5 = new MedicineStock("medicine5", "chemicalComposition", "Gynecology", "dateOfExpiry",
				1000);
		MedicineStock medicine6 = new MedicineStock("medicine6", "chemicalComposition", "Gynecology", "dateOfExpiry",
				1000);

		List<MedicineStock> medicineList1 = new ArrayList<>();
		medicineList1.add(medicine1);
		medicineList1.add(medicine2);
		List<MedicineStock> medicineList2 = new ArrayList<>();
		medicineList2.add(medicine3);
		medicineList2.add(medicine4);
		List<MedicineStock> medicineList3 = new ArrayList<>();
		medicineList3.add(medicine5);
		medicineList3.add(medicine6);

		when(scheduleService.medicineByAilment("authorization","Orthopaedics")).thenReturn(medicineList1,
				medicineList2, medicineList2, medicineList1, medicineList3);


		doReturn(new Date(1_628_015_400L * 1000)).when(format).stringToDate("2021-08-04");

			doReturn("04-08-2021").when(format).dateToString(new Date(1_628_015_400L * 1000));
			doReturn("05-08-2021").when(format).dateToString(new Date(1_628_101_800L * 1000));
			doReturn("06-08-2021").when(format).dateToString(new Date(1_628_188_200L * 1000));
			doReturn("07-08-2021").when(format).dateToString(new Date(1_628_274_600L * 1000));
			doReturn("09-08-2021").when(format).dateToString(new Date(1_628_447_400L * 1000));

		actual = scheduleService.scheduleMeeting("authorization","2021-08-04");
		assertEquals(expected, actual,"List is equal");
	}
	
	
	/**
	 * @throws ParseException
	 * @throws CsvValidationException
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked"})
	@Test
	void testScheduleMeetingStartSunday() throws ParseException, CsvValidationException, IOException {
		
		scheduleService.setNoOfRep(3);

		RepSchedule rep1 = new RepSchedule("Rep_1", "Doc_1", "Orthopaedics", "medicine1, medicine2", "1 PM to 2 PM",
				"02-08-2021", 9884122113L);
		RepSchedule rep2 = new RepSchedule("Rep_2", "Doc_2", "General", "medicine3, medicine4", "1 PM to 2 PM",
				"03-08-2021", 9876543210L);
		RepSchedule rep3 = new RepSchedule("Rep_3", "Doc_3", "General", "medicine3, medicine4", "1 PM to 2 PM",
				"04-08-2021", 9123456780L);
		RepSchedule rep4 = new RepSchedule("Rep_1", "Doc_4", "Orthopaedics", "medicine1, medicine2", "1 PM to 2 PM",
				"05-08-2021", 7891234560L);
		RepSchedule rep5 = new RepSchedule("Rep_2", "Doc_5", "Gynecology", "medicine5, medicine6", "1 PM to 2 PM",
				"06-08-2021", 8976543210L);
		List<RepSchedule> actual = new ArrayList<>();
		List<RepSchedule> expected = new ArrayList<>();
		expected.add(rep1);
		expected.add(rep2);
		expected.add(rep3);
		expected.add(rep4);
		expected.add(rep5);

		MedicineStock medicine1 = new MedicineStock("medicine1", "chemicalComposition", "Orthopaedics", "dateOfExpiry",
				1000);
		MedicineStock medicine2 = new MedicineStock("medicine2", "chemicalComposition", "Orthopaedics", "dateOfExpiry",
				1000);
		MedicineStock medicine3 = new MedicineStock("medicine3", "chemicalComposition", "General", "dateOfExpiry",
				1000);
		MedicineStock medicine4 = new MedicineStock("medicine4", "chemicalComposition", "General", "dateOfExpiry",
				1000);
		MedicineStock medicine5 = new MedicineStock("medicine5", "chemicalComposition", "Gynecology", "dateOfExpiry",
				1000);
		MedicineStock medicine6 = new MedicineStock("medicine6", "chemicalComposition", "Gynecology", "dateOfExpiry",
				1000);

		List<MedicineStock> medicineList1 = new ArrayList<>();
		medicineList1.add(medicine1);
		medicineList1.add(medicine2);
		List<MedicineStock> medicineList2 = new ArrayList<>();
		medicineList2.add(medicine3);
		medicineList2.add(medicine4);
		List<MedicineStock> medicineList3 = new ArrayList<>();
		medicineList3.add(medicine5);
		medicineList3.add(medicine6);

		when(scheduleService.medicineByAilment("authorization","Orthopaedics")).thenReturn(medicineList1,
				medicineList2, medicineList2, medicineList1, medicineList3);


		doReturn(new Date(1_627_756_200L * 1000)).when(format).stringToDate("2021-08-01");

			doReturn("02-08-2021").when(format).dateToString(new Date(1_627_842_600L * 1000));
			doReturn("03-08-2021").when(format).dateToString(new Date(1_627_929_000L * 1000));
			doReturn("04-08-2021").when(format).dateToString(new Date(1_628_015_400L * 1000));
			doReturn("05-08-2021").when(format).dateToString(new Date(1_628_101_800L * 1000));
			doReturn("06-08-2021").when(format).dateToString(new Date(1_628_188_200L * 1000));

		actual = scheduleService.scheduleMeeting("authorization","2021-08-01");
		assertEquals(expected, actual,"Start date is given date+1");
	}
	
	
	/**
	 * @throws ParseException
	 * @throws CsvValidationException
	 * @throws IOException
	 */
	@Test
	void testScheduleBeforeTodayDate() throws ParseException, CsvValidationException, IOException {

		List<RepSchedule> actual = new ArrayList<>();
		List<RepSchedule> expected = new ArrayList<>();

		doReturn(new Date(1_596_220_200L * 1000)).when(format).stringToDate("2020-08-01");

		actual = scheduleService.scheduleMeeting("authorization","2020-08-01");
		assertEquals(expected, actual,"Result is empty list");
	}

}
