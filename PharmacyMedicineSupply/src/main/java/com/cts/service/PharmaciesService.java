package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author POD 13
 *
 */
@Service
public class PharmaciesService {


	/**
	 * @return
	 */
	public List<String> getPharmacyNames() {
		List<String> pharmacyNames = new ArrayList<>();
		pharmacyNames.add("PharmacyA");
		pharmacyNames.add("PharmacyB");
		pharmacyNames.add("PharmacyC");
		pharmacyNames.add("PharmacyD");
		pharmacyNames.add("PharmacyE");
		return pharmacyNames;
		

	}
}
