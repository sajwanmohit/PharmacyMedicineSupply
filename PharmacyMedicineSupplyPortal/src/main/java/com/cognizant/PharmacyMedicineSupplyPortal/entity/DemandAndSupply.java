package com.cognizant.PharmacyMedicineSupplyPortal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DemandSupply")
public class DemandAndSupply {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String medicineName;
	/**
	 * 
	 */
	private int demand;
	/**
	 * 
	 */
	private int supply;

	/**
	 * @param medicineName
	 * @param username
	 * @param demand
	 * @param supply
	 */
	public DemandAndSupply(String medicineName, String username, int demand, int supply) {
		this.medicineName = medicineName;
		this.demand = demand;
		this.username = username;
		this.supply = supply;
	}
}
