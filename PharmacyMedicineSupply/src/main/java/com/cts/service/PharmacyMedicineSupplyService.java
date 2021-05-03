package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.model.Medicine;
import com.cts.model.MedicineDemand;
import com.cts.model.PharmacyMedicineSupply;

/**
 * @author POD 13
 *
 */
@Service
public class PharmacyMedicineSupplyService {
	
	

	/**
	 * @param pharmacyNames
	 * @param stocks
	 * @param medicineDemands
	 * @return
	 */
	public List<PharmacyMedicineSupply> get(List<String> pharmacyNames, List<Medicine> stocks,
			List<MedicineDemand> medicineDemands) {

		List<PharmacyMedicineSupply> medicineSupply = new ArrayList<>();

		for (MedicineDemand meds : medicineDemands) {
			for (Medicine stock : stocks) {
				if (meds.getMedicineName().equals(stock.getMedicineName())) {

					if (meds.getDemandCount() <= stock.getNoOfTablets()) {
						int supplyCount = meds.getDemandCount() / pharmacyNames.size();
						for (int i = 0; i < pharmacyNames.size(); i++) {
							medicineSupply.add(new PharmacyMedicineSupply(pharmacyNames.get(i), meds.getMedicineName(),
									supplyCount));
						}

					} else {
						int supplyCount = stock.getNoOfTablets() / pharmacyNames.size();
						for (int i = 0; i < pharmacyNames.size(); i++) {
							medicineSupply.add(new PharmacyMedicineSupply(pharmacyNames.get(i), meds.getMedicineName(),
									supplyCount));
						}

					}
				}
			}
		}
		return medicineSupply;
	}
}
