package com.cognizant.PharmacyMedicineSupplyPortal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author POD 13
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepSchedule {
	/**
	 * Representative name
	 */
	private String repName;
	/**
	 * Name of Doctor assigned to representative
	 */
	private String doctorName;
	/**
	 * Ailment treated by doctor
	 */
	private String treatingAilment;
	/**
	 * Medicines available for the ailment treated by doctor
	 */
	private String medicine;
	/**
	 * Appointment time
	 */
	private String slot;
	/**
	 * Appointment date
	 */
	private String date;
	/**
	 * Doctor contact number
	 */
	private long doctorContact;
}
