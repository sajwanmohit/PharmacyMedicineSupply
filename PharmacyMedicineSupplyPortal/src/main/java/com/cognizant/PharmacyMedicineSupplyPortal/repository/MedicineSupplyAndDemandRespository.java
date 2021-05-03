package com.cognizant.PharmacyMedicineSupplyPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.PharmacyMedicineSupplyPortal.entity.DemandAndSupply;

/**
 * @author POD 13
 *
 */
@Repository
public interface MedicineSupplyAndDemandRespository extends JpaRepository<DemandAndSupply, Integer> {

}
