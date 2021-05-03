package com.cts.medicinestock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.medicinestock.model.Medicine;
import com.cts.medicinestock.repository.MedicineStockRepository;
import com.cts.medicinestock.service.MedicineService;

/**
 * @author POD 13
 *
 */
@ExtendWith(MockitoExtension.class)
class ServiceTest {

	/**
	 * 
	 */
	@InjectMocks
	private MedicineService service;
	
	/**
	 * 
	 */
	@Mock
	private MedicineStockRepository repository;

	/**
	 * 
	 */
	@Test
	void medicineStockServiceTest() {
		List<Medicine> medicines = new ArrayList<>();
		medicines.add(new Medicine("Orthoherb", "Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam", "Orthopaedics",
				"2021-04-04", 4000));
		medicines.add(new Medicine("Cholecalciferol", "C27H44O", "Orthopaedics", "2022-06-08", 8000));
		medicines.add(new Medicine("Gaviscon",
				"250mg Sodium Alginate,133.5mg Sodium Bicarbonate,80mg Calcium carbonate per 5ml", "General",
				"2020-06-04", 2000));
		medicines.add(new Medicine("Dolo-650", "Acetaminophen(650mg)", "General", "2021-01-02", 500));
		medicines.add(new Medicine("Cyclopam", "Dicyclomine,Paracetamol", "Gynecology", "2021-12-04", 1500));
		medicines.add(new Medicine("Hilact", "Artemether,Lumefantrine 120mg", "Gynecology", "2021-10-10", 4000));

		when(repository.findAll()).thenReturn(medicines);

		List<Medicine> medicines1 = service.retireveAllStock();
		assertEquals(6, medicines1.size());
	}
}
