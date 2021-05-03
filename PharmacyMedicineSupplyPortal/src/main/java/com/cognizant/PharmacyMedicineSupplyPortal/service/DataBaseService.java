package com.cognizant.PharmacyMedicineSupplyPortal.service;

import com.cognizant.PharmacyMedicineSupplyPortal.entity.DemandAndSupply;

/**
 * @author POD 13
 *
 */
public interface DataBaseService {

	/**
	 * @param demandSupply
	 * @return
	 */
	public DemandAndSupply save(DemandAndSupply demandSupply);
}
