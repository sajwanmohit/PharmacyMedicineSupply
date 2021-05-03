package com.cognizant.PharmacyMedicineSupplyPortal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.cognizant.PharmacyMedicineSupplyPortal.client.StockClient;
import com.cognizant.PharmacyMedicineSupplyPortal.client.SupplyClient;
import com.cognizant.PharmacyMedicineSupplyPortal.entity.DemandAndSupply;
import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;
import com.cognizant.PharmacyMedicineSupplyPortal.model.MD;
import com.cognizant.PharmacyMedicineSupplyPortal.model.Medicine;
import com.cognizant.PharmacyMedicineSupplyPortal.model.MedicineSupplyAndDemand;
import com.cognizant.PharmacyMedicineSupplyPortal.model.PharmacyMedicineSupply;
import com.cognizant.PharmacyMedicineSupplyPortal.service.DataBaseService;
import com.cognizant.PharmacyMedicineSupplyPortal.service.LoginService;

/**
 * @author POD 13
 *
 */
@Controller
public class DataController {

	/**
	 * 
	 */
	HashMap<String, String> medicineDemands = new HashMap<String, String>();

	/**
	 * 
	 */
	@Autowired
	private DataBaseService dataService;

	/**
	 * 
	 */
	@Autowired
	private SupplyClient supplyClient;

	/**
	 * 
	 */
	@Autowired
	private StockClient stockClient;

	/**
	 * 
	 */
	@Autowired
	private LoginService loginService;

	/**
	 * @param demandCount
	 * @param model
	 * @param login
	 * @param medicineName
	 * @return
	 */
	@PostMapping("/add/{medicineName}")
	public String add(@RequestParam("demandCount") String demandCount, Model model,
			@SessionAttribute("login") Login login, @PathVariable("medicineName") String medicineName) {

		String response = loginService.validateUserNameAndPassword(login);
		List<Medicine> stocks = stockClient.retrieveAllMedicines(response);
		medicineDemands.put(medicineName, demandCount);
		model.addAttribute("stocks", stocks);
		model.addAttribute("demandList", medicineDemands);
		return "medicine-supply";
	}

	/**
	 * @param model
	 * @param login
	 * @return
	 */
	@GetMapping("/add")
	public String add(Model model, @SessionAttribute("login") Login login) {
		String response = loginService.validateUserNameAndPassword(login);
		List<Medicine> stocks = stockClient.retrieveAllMedicines(response);
		model.addAttribute("stocks", stocks);
		model.addAttribute("demandList", medicineDemands);
		return "medicine-supply";
	}

	/**
	 * @param model
	 * @param login
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/supply")
	public String supplyMedicine(ModelMap model, @SessionAttribute("login") Login login) throws Exception {
		String response = loginService.validateUserNameAndPassword(login);
		String username = loginService.getUsername(login);

		List<MD> listOfMedicineDemands = new ArrayList<>();

		List<MedicineSupplyAndDemand> medicineSupplyAndDemand = new ArrayList<>();
		for (Map.Entry<String, String> entry : medicineDemands.entrySet()) {

			listOfMedicineDemands.add(new MD(entry.getKey(), Integer.parseInt(entry.getValue())));
		}

		List<PharmacyMedicineSupply> supply = supplyClient.getSupply(response, listOfMedicineDemands);

		for (MD medicineDemand : listOfMedicineDemands) {
			int s = 0;
			for (PharmacyMedicineSupply medicineSupply : supply) {
				if (medicineDemand.getMedicineName().equals(medicineSupply.getMedicineName())) {
					s += medicineSupply.getSupplyCount();
				}
			}
			medicineSupplyAndDemand.add(
					new MedicineSupplyAndDemand(medicineDemand.getMedicineName(), medicineDemand.getDemandCount(), s));
		}

		for (MedicineSupplyAndDemand medicineSupply : medicineSupplyAndDemand) {

			dataService.save(new DemandAndSupply(medicineSupply.getMedicineName(), username,
					medicineSupply.getDemandCount(), medicineSupply.getSupplyCount()));
		}

		model.addAttribute("medicineSupply", supply);
		medicineDemands.clear();
		return "supply";
	}

}
