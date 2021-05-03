package com.cognizant.PharmacyMedicineSupplyPortal.service;

import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;

/**
 * @author POD 13
 *
 */
public interface LoginService {

	/**
	 * @param login
	 * @return
	 */
	String validateUserNameAndPassword(Login login);

	/**
	 * @param login
	 * @return
	 */
	String getUsername(Login login);

}
