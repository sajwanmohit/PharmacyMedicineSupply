package com.cognizant.PharmacyMedicineSupplyPortal.service;

import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;

/**
 * @author POD 13
 *
 */
public interface RegisterService {

	/**
	 * @param login
	 * @return
	 */
	String registerUserNameAndPassword(Login login);
}
