package com.cts.medicinestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.medicinestock.model.Medicine;

/**
 * @author POD 13
 *
 */
public interface MedicineStockRepository extends JpaRepository<Medicine, String>{

}
