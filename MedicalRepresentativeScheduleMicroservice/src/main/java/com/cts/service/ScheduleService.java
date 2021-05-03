package com.cts.service;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.date_formatter.DateFormat;
import com.cts.feign.MedicineStockFeign;
import com.cts.model.Doctor;
import com.cts.model.MedicineStock;
import com.cts.model.RepSchedule;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author POD 13
 *
 */
@Slf4j
@Component
@NoArgsConstructor
public class ScheduleService {

	/**
	 * 
	 */
	@Autowired
	private MedicineStockFeign feign;
	
	/**
	 * 
	 */
	@Setter
	@Value("${app.noOfRep}")
	private int noOfRep;
	

	/**
	 * 
	 */
	@Autowired
	private DateFormat format;

	/**
	 * @return
	 * @throws CsvValidationException
	 * @throws IOException
	 */
	public List<Doctor> readCSV() throws CsvValidationException, IOException {
		CSVReader reader = null;
		FileReader fileReader = null;
		List<Doctor> doctorList = new ArrayList<>();
			fileReader = new FileReader("docInfo.csv");
			log.info("Reading file");
			reader = new CSVReader(fileReader);
			String[] line;
			while ((line = reader.readNext()) != null) {
				Doctor doc = new Doctor();
				doc.setDoctorName(line[0]);
				doc.setTreatingAilment(line[1]);
				doc.setContact(Long.parseLong(line[2]));
				doctorList.add(doc);
				log.info(doc.toString() + " Added to list");
			}
			reader.close();
			fileReader.close();
		return doctorList;
	}

	/**
	 * @return
	 */
	public List<String> readRepresentatives() {
		List<String> repList = new ArrayList<>();
		log.info("Adding representatives");
		for(int itr=1;itr<=noOfRep;itr++) {
			repList.add("Rep_"+itr);
		}
		return repList;
	}

	
	/**
	 * @param authorization
	 * @param ailment
	 * @param authorization 
	 * @return
	 */
	public List<MedicineStock> medicineByAilment(final String authorization,final String ailment) {
		log.info("Fetching whole medicine stock");
		List<MedicineStock> medicineStock = feign.retrieveAllMedicines(authorization);
		log.info(medicineStock.toString());
		List<MedicineStock> result = new ArrayList<>();
		for (MedicineStock medicine : medicineStock) {
			if (medicine.getTargetAilment().equalsIgnoreCase(ailment)) {
				result.add(medicine);
			}
		}
		return result;
	}

	
	/**
	 * @param authorization
	 * @param date
	 * @param authorization 
	 * @return
	 * @throws ParseException
	 * @throws CsvValidationException
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public List<RepSchedule> scheduleMeeting(final String authorization, final String date) throws ParseException, CsvValidationException, IOException {
		
		log.info("Getting Doctor list");
		List<Doctor> doctorList = readCSV();
		log.info("Getting Representatives list");
		List<String> repList = readRepresentatives();
		List<RepSchedule> schedule = new ArrayList<>();
		Date inputDate;
		inputDate = format.stringToDate(date);
		log.info("Formatted Date is : " + inputDate.toString());
		Calendar c = Calendar.getInstance();
		c.setTime(inputDate);
		int count = 0;
		int dateCount = 0;
		int repCount = 0;
		final int day = inputDate.getDay();
		if(day == 0) {
			c.add(Calendar.DAY_OF_MONTH, 1);
			inputDate = c.getTime();
		}
		if (inputDate.after(new Date())) {
			while (count < doctorList.size()) {
				RepSchedule rep = new RepSchedule();
				c.setTime(inputDate);
				if (repCount > noOfRep-1) {
					repCount = 0;
				}
				List<String> medicine = new ArrayList<>();
				List<MedicineStock> medicineStock = medicineByAilment(authorization,doctorList.get(count).getTreatingAilment());
				for (MedicineStock med : medicineStock) {
					medicine.add(med.getMedicineName());
					log.info(medicine.toString());
				}
				log.info("Entering the details to schedule meeting");
				rep.setRepName(repList.get(repCount));
				rep.setDoctorName(doctorList.get(count).getDoctorName());
				rep.setTreatingAilment(doctorList.get(count).getTreatingAilment());
				rep.setMedicine(medicine.toString().substring(1, medicine.toString().length()-1));
				rep.setSlot("1 PM to 2 PM");
				c.add(Calendar.DAY_OF_MONTH, dateCount);
				Date schedDate = c.getTime();
				if (schedDate.getDay() == 6) {
					dateCount++;
				}
				rep.setDate(format.dateToString(schedDate));
				rep.setDoctorContact(doctorList.get(count).getContact());
				schedule.add(rep);
				log.info("Added schedule successfully");
				count++;
				dateCount++;
				repCount++;
			}

		}

		return schedule;
	}
}
