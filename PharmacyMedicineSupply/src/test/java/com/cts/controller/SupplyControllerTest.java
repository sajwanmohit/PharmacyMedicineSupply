package com.cts.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.client.AuthServiceClient;
import com.cts.client.StockClient;
import com.cts.model.MedicineDemand;
import com.cts.service.PharmaciesService;
import com.cts.service.PharmacyMedicineSupplyService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author POD 13
 *
 */
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = { SupplyController.class, PharmacyMedicineSupplyService.class, PharmaciesService.class,
		StockClient.class, AuthServiceClient.class })
@WebMvcTest
class SupplyControllerTest {

	/**
	 * 
	 */
	@InjectMocks
	private SupplyController supplyController;

	/**
	 * 
	 */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * 
	 */
	@MockBean
	private PharmacyMedicineSupplyService pharmacyMedicineSupplyServiceMock;

	/**
	 * 
	 */
	@MockBean
	private PharmaciesService pharmaciesServiceMock;

	/**
	 * 
	 */
	@MockBean
	private StockClient stockClientMock;

	/**
	 * 
	 */
	@MockBean
	private AuthServiceClient authClient;

	/**
	 * 
	 */
	@Autowired
	private ObjectMapper om;

	/**
	 * @throws Exception
	 */
//	@Test
//	void supplyControllerTest() throws Exception {
//
//		doReturn(Boolean.TRUE).when(authClient).validate("authorization");
//
//		List<String> pharmacyNames = new ArrayList<>();
//		String pharm1 = "PharmacyA";
//		String pharm2 = "PharmacyB";
//		String pharm3 = "PharmacyC";
//		String pharm4 = "PharmacyD";
//		String pharm5 = "PharmacyE";
//
//		pharmacyNames.add(pharm1);
//		pharmacyNames.add(pharm2);
//		pharmacyNames.add(pharm3);
//		pharmacyNames.add(pharm4);
//		pharmacyNames.add(pharm5);
//
//		doReturn(Lists.newArrayList(pharm1, pharm2, pharm3, pharm4, pharm5)).when(pharmaciesServiceMock)
//				.getPharmacyNames();
//
//		List<Medicine> medicines = new ArrayList<>();
//
//		Medicine medicine1 = new Medicine("Orthoherb", "Castor,Neem,Adulsa,Guggul,Eranda,Vasa,Vilvam", "Orthopaedics",
//				"04-04-2021", 4000);
//		Medicine medicine2 = new Medicine("Cholecalciferol", "C27H44O", "Orthopaedics", "08-06-2022", 8000);
//		Medicine medicine3 = new Medicine("Gaviscon",
//				"250mg Sodium Alginate,133.5mg Sodium Bicarbonate,80mg Calcium carbonate per 5ml", "General",
//				"04-06-2020", 2000);
//		Medicine medicine4 = new Medicine("Dolo-650", "Acetaminophen(650mg)", "General", "02-01-2021", 500);
//		Medicine medicine5 = new Medicine("Cyclopam", "Dicyclomine,Paracetamol", "Gynecology", "04-12-2021", 1500);
//		Medicine medicine6 = new Medicine("Hilact", "Artemether,Lumefantrine 120mg", "Gynecology", "10-10-2021", 4000);
//
//		medicines.add(medicine1);
//		medicines.add(medicine2);
//		medicines.add(medicine3);
//		medicines.add(medicine4);
//		medicines.add(medicine5);
//		medicines.add(medicine6);
//
//		doReturn(Lists.newArrayList(medicine1, medicine2, medicine3, medicine4, medicine5, medicine6))
//				.when(stockClientMock).retrieveAllMedicines("authorization");
//
//		List<PharmacyMedicineSupply> supply = new ArrayList<>();
//		supply.add(new PharmacyMedicineSupply("PharmacyA", "Hilact", 20));
//		supply.add(new PharmacyMedicineSupply("PharmacyB", "Hilact", 20));
//		supply.add(new PharmacyMedicineSupply("PharmacyC", "Hilact", 20));
//		supply.add(new PharmacyMedicineSupply("PharmacyD", "Hilact", 20));
//		supply.add(new PharmacyMedicineSupply("PharmacyE", "Hilact", 20));
//		supply.add(new PharmacyMedicineSupply("PharmacyA", "Cyclopam", 20));
//		supply.add(new PharmacyMedicineSupply("PharmacyB", "Cyclopam", 20));
//		supply.add(new PharmacyMedicineSupply("PharmacyC", "Cyclopam", 20));
//		supply.add(new PharmacyMedicineSupply("PharmacyD", "Cyclopam", 20));
//		supply.add(new PharmacyMedicineSupply("PharmacyE", "Cyclopam", 20));
//
//		List<MedicineDemand> medicineDemands = new ArrayList<>();
//		medicineDemands.add(new MedicineDemand("Hilact", 100));
//		medicineDemands.add(new MedicineDemand("Cyclopam", 100));
//
//		doReturn(supply).when(pharmacyMedicineSupplyServiceMock).get(pharmacyNames, medicines, medicineDemands);
//
//		mockMvc.perform(post("/PharmacySupply").contentType(MediaType.APPLICATION_JSON)
//				.content(om.writeValueAsString(medicineDemands)).accept(MediaType.APPLICATION_JSON)
//				.header("Authorization", "authorizaiton")).andDo(print())
//				.andExpect(status().isOk());
////				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
////				.andExpect(jsonPath("$.pharmacyName").value("PharmacyA"))
////				.andExpect(jsonPath("$.medicineName").value("Hilact")).andExpect(jsonPath("$.supplyCount").value(20))
////				.andExpect(jsonPath("$.pharmacyName").value("PharmacyB"))
////				.andExpect(jsonPath("$.medicineName").value("Hilact")).andExpect(jsonPath("$.supplyCount").value(20))
////				.andExpect(jsonPath("$.pharmacyName").value("PharmacyC"))
////				.andExpect(jsonPath("$.medicineName").value("Hilact")).andExpect(jsonPath("$.supplyCount").value(20))
////				.andExpect(jsonPath("$.pharmacyName").value("PharmacyD"))
////				.andExpect(jsonPath("$.medicineName").value("Hilact")).andExpect(jsonPath("$.supplyCount").value(20))
////				.andExpect(jsonPath("$.pharmacyName").value("PharmacyE"))
////				.andExpect(jsonPath("$.medicineName").value("Hilact")).andExpect(jsonPath("$.supplyCount").value(20))
////				.andExpect(jsonPath("$.pharmacyName").value("PharmacyA"))
////				.andExpect(jsonPath("$.medicineName").value("Cyclopam")).andExpect(jsonPath("$.supplyCount").value(20))
////				.andExpect(jsonPath("$.pharmacyName").value("PharmacyB"))
////				.andExpect(jsonPath("$.medicineName").value("Cyclopam")).andExpect(jsonPath("$.supplyCount").value(20))
////				.andExpect(jsonPath("$.pharmacyName").value("PharmacyC"))
////				.andExpect(jsonPath("$.medicineName").value("Cyclopam")).andExpect(jsonPath("$.supplyCount").value(20))
////				.andExpect(jsonPath("$.pharmacyName").value("PharmacyD"))
////				.andExpect(jsonPath("$.medicineName").value("Cyclopam")).andExpect(jsonPath("$.supplyCount").value(20))
////				.andExpect(jsonPath("$.pharmacyName").value("PharmacyE"))
////				.andExpect(jsonPath("$.medicineName").value("Cyclopam")).andExpect(jsonPath("$.supplyCount").value(20));
//
//	}

	
	/**
	 * @throws Exception
	 */
	@Test
	void supplyControllerTestNull() throws Exception {

		doReturn(Boolean.FALSE).when(authClient).validate("authorization");
		List<MedicineDemand> medicineDemands = new ArrayList<>();
		medicineDemands.add(new MedicineDemand("Hilact", 100));
		medicineDemands.add(new MedicineDemand("Cyclopam", 100));

		mockMvc.perform(post("/PharmacySupply").contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(medicineDemands)).accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "authorizaiton")).andExpect(status().isUnauthorized());

	}
}