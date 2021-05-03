package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.cts.model.Medicine;
import com.cts.model.MedicineDemand;
import com.cts.model.PharmacyMedicineSupply;

/**
 * @author POD 13
 *
 */
class MedicineSupplyServiceTest {

	/**
	 * 
	 */
	@InjectMocks
	PharmacyMedicineSupplyService service;

	/**
	 * 
	 */
	@Test
	void PharmacyMedicineSupplyServiceIFTest() {
		PharmacyMedicineSupplyService service = new PharmacyMedicineSupplyService();
		List<String> pharmacyNames = new ArrayList<>();
		pharmacyNames.add("PharmacyA");
		pharmacyNames.add("PharmacyB");
		pharmacyNames.add("PharmacyC");
		pharmacyNames.add("PharmacyD");
		pharmacyNames.add("PharmacyE");

		List<MedicineDemand> medicineDemands = new ArrayList<>();
		medicineDemands.add(new MedicineDemand("Hilact", 100));
		medicineDemands.add(new MedicineDemand("Cyclopam", 100));

		List<Medicine> medicines = new ArrayList<>();
		medicines.add(new Medicine("Orthoherb", "Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam", "Orthopaedics",
				"04-04-2021", 4000));
		medicines.add(new Medicine("Cholecalciferol", "C27H44O", "Orthopaedics", "08-06-2022", 8000));
		medicines.add(new Medicine("Gaviscon",
				"250mg Sodium Alginate,133.5mg Sodium Bicarbonate,80mg Calcium carbonate per 5ml", "General",
				"04-06-2020", 2000));
		medicines.add(new Medicine("Dolo-650", "Acetaminophen(650mg)", "General", "02-01-2021", 500));
		medicines.add(new Medicine("Cyclopam", "Dicyclomine,Paracetamol", "Gynecology", "04-12-2021", 1500));
		medicines.add(new Medicine("Hilact", "Artemether,Lumefantrine 120mg", "Gynecology", "10-10-2021", 4000));

		List<PharmacyMedicineSupply> expected = service.get(pharmacyNames, medicines, medicineDemands);
		List<PharmacyMedicineSupply> actual = new ArrayList<>();
		actual.add(new PharmacyMedicineSupply("PharmacyA", "Hilact", 20));
		actual.add(new PharmacyMedicineSupply("PharmacyB", "Hilact", 20));
		actual.add(new PharmacyMedicineSupply("PharmacyC", "Hilact", 20));
		actual.add(new PharmacyMedicineSupply("PharmacyD", "Hilact", 20));
		actual.add(new PharmacyMedicineSupply("PharmacyE", "Hilact", 20));
		actual.add(new PharmacyMedicineSupply("PharmacyA", "Cyclopam", 20));
		actual.add(new PharmacyMedicineSupply("PharmacyB", "Cyclopam", 20));
		actual.add(new PharmacyMedicineSupply("PharmacyC", "Cyclopam", 20));
		actual.add(new PharmacyMedicineSupply("PharmacyD", "Cyclopam", 20));
		actual.add(new PharmacyMedicineSupply("PharmacyE", "Cyclopam", 20));

		assertEquals(expected, actual);

	}

	/**
	 * 
	 */
	@Test
	void PharmacyMedicineSupplyServiceElseTest() {
		PharmacyMedicineSupplyService service = new PharmacyMedicineSupplyService();
		List<String> pharmacyNames = new ArrayList<>();
		pharmacyNames.add("PharmacyA");
		pharmacyNames.add("PharmacyB");
		pharmacyNames.add("PharmacyC");
		pharmacyNames.add("PharmacyD");
		pharmacyNames.add("PharmacyE");

		List<MedicineDemand> medicineDemands = new ArrayList<>();
		medicineDemands.add(new MedicineDemand("Hilact", 5000));
		medicineDemands.add(new MedicineDemand("Cyclopam", 2000));

		List<Medicine> medicines = new ArrayList<>();
		medicines.add(new Medicine("Orthoherb", "Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam", "Orthopaedics",
				"04-04-2021", 4000));
		medicines.add(new Medicine("Cholecalciferol", "C27H44O", "Orthopaedics", "08-06-2022", 8000));
		medicines.add(new Medicine("Gaviscon",
				"250mg Sodium Alginate,133.5mg Sodium Bicarbonate,80mg Calcium carbonate per 5ml", "General",
				"04-06-2020", 2000));
		medicines.add(new Medicine("Dolo-650", "Acetaminophen(650mg)", "General", "02-01-2021", 500));
		medicines.add(new Medicine("Cyclopam", "Dicyclomine,Paracetamol", "Gynecology", "04-12-2021", 1500));
		medicines.add(new Medicine("Hilact", "Artemether,Lumefantrine 120mg", "Gynecology", "10-10-2021", 4000));

		List<PharmacyMedicineSupply> expected = service.get(pharmacyNames, medicines, medicineDemands);
		List<PharmacyMedicineSupply> actual = new ArrayList<>();
		actual.add(new PharmacyMedicineSupply("PharmacyA", "Hilact", 800));
		actual.add(new PharmacyMedicineSupply("PharmacyB", "Hilact", 800));
		actual.add(new PharmacyMedicineSupply("PharmacyC", "Hilact", 800));
		actual.add(new PharmacyMedicineSupply("PharmacyD", "Hilact", 800));
		actual.add(new PharmacyMedicineSupply("PharmacyE", "Hilact", 800));
		actual.add(new PharmacyMedicineSupply("PharmacyA", "Cyclopam", 300));
		actual.add(new PharmacyMedicineSupply("PharmacyB", "Cyclopam", 300));
		actual.add(new PharmacyMedicineSupply("PharmacyC", "Cyclopam", 300));
		actual.add(new PharmacyMedicineSupply("PharmacyD", "Cyclopam", 300));
		actual.add(new PharmacyMedicineSupply("PharmacyE", "Cyclopam", 300));

		assertEquals(expected, actual);

	}

}
