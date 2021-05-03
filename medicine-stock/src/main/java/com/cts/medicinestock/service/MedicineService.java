package com.cts.medicinestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.medicinestock.model.Medicine;
import com.cts.medicinestock.repository.MedicineStockRepository;

/**
 * @author POD 13
 *
 */
@Component
public class MedicineService {

	/**
	 * 
	 */
	@Autowired
	private MedicineStockRepository repository;

	/**
	 * @return
	 */
	public List<Medicine> retireveAllStock() {

		return repository.findAll();

	}
}
