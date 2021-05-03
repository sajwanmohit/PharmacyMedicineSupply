package com.cognizant.PharmacyMedicineSupplyPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.PharmacyMedicineSupplyPortal.entity.DemandAndSupply;
import com.cognizant.PharmacyMedicineSupplyPortal.repository.MedicineSupplyAndDemandRespository;

/**
 * @author POD 13
 *
 */
@Service
public class DataBaseServiceImpl implements DataBaseService {

	/**
	 * 
	 */
	@Autowired
	private MedicineSupplyAndDemandRespository medsRepo;

	/**
	 *
	 */
	@Override
	public DemandAndSupply save(DemandAndSupply demandSupply) {
		return medsRepo.save(demandSupply);

	}

}
