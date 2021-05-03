package com.cts.medicinestock.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author POD 13
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
	/**
	 * 
	 */
	@Id
	private String medicineName;
	/**
	 * 
	 */
	private String chemicalComposition;
	/**
	 * 
	 */
	private String targetAilment;
	/**
	 * 
	 */
	private String dateOfExpiry;
	/**
	 * 
	 */
	private int noOfTablets;

}
