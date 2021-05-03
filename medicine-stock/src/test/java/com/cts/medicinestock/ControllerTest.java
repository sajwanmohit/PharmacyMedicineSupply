package com.cts.medicinestock;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.medicinestock.client.AuthClient;
import com.cts.medicinestock.controller.MedicineStockController;
import com.cts.medicinestock.model.Medicine;
import com.cts.medicinestock.service.MedicineService;

/**
 * @author POD 13
 *
 */
@ExtendWith(MockitoExtension.class)
@WebMvcTest(MedicineStockController.class)
class ControllerTest {

	/**
	 * Medicine Service Mock Bean
	 */
	@MockBean
	private MedicineService service;
	/**
	 * AuthClient Mock Bean
	 */
	@MockBean
	private AuthClient authClient;
	/**
	 * MockMvc
	 */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * @throws Exception
	 */
	@Test
	void retrieveAllStocksTest() throws Exception {
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
		doReturn(Boolean.TRUE).when(authClient).validate("authorization");
		when(service.retireveAllStock()).thenReturn(medicines);

		RequestBuilder request = MockMvcRequestBuilders.get("/all-stocks").accept(MediaType.APPLICATION_JSON).header("Authorization", "authorization");

		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"[{\"medicineName\":\"Orthoherb\",\"targetAilment\":\"Orthopaedics\",\"dateOfExpiry\":\"2021-04-04\",\"noOfTablets\":4000,\"chemicalComposition\":\"Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam\"},{\"medicineName\":\"Cholecalciferol\",\"targetAilment\":\"Orthopaedics\",\"dateOfExpiry\":\"2022-06-08\",\"noOfTablets\":8000,\"chemicalComposition\":\"C27H44O\"},{\"medicineName\":\"Gaviscon\",\"targetAilment\":\"General\",\"dateOfExpiry\":\"2020-06-04\",\"noOfTablets\":2000,\"chemicalComposition\":\"250mg Sodium Alginate,133.5mg Sodium Bicarbonate,80mg Calcium carbonate per 5ml\"},{\"medicineName\":\"Dolo-650\",\"targetAilment\":\"General\",\"dateOfExpiry\":\"2021-01-02\",\"noOfTablets\":500,\"chemicalComposition\":\"Acetaminophen(650mg)\"},{\"medicineName\":\"Cyclopam\",\"targetAilment\":\"Gynecology\",\"dateOfExpiry\":\"2021-12-04\",\"noOfTablets\":1500,\"chemicalComposition\":\"Dicyclomine,Paracetamol\"},{\"medicineName\":\"Hilact\",\"targetAilment\":\"Gynecology\",\"dateOfExpiry\":\"2021-10-10\",\"noOfTablets\":4000,\"chemicalComposition\":\"Artemether,Lumefantrine 120mg\"}]"))
				.andReturn();

	}
	
	/**
	 * @throws Exception
	 */
	@Test
	void retrieveAllStocksUnAuthorizedTest() throws Exception {
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
		doReturn(Boolean.FALSE).when(authClient).validate("authorization");
		
		when(service.retireveAllStock()).thenReturn(medicines);
		
		mockMvc.perform(get("/all-stocks").contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "authorization"))
				.andExpect(status().isUnauthorized());
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	void stocksNotFoundTest() throws Exception {
		List<Medicine> medicines = new ArrayList<>();

		doReturn(Boolean.TRUE).when(authClient).validate("authorization");
		
		when(service.retireveAllStock()).thenReturn(medicines);
		
		mockMvc.perform(get("/all-stocks").contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "authorization"))
				.andExpect(status().isNotFound());
	}
}