package com.cts.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author POD 13
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	
	/**
	 * Doctor name
	 */
	private String doctorName;
	/**
	 * Ailment treated by doctor 
	 */
	private String treatingAilment;
	/**
	 * Doctor contact
	 */
	private long contact;

}
