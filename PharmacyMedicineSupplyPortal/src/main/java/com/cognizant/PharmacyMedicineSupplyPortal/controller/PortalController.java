package com.cognizant.PharmacyMedicineSupplyPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;
import com.cognizant.PharmacyMedicineSupplyPortal.service.LoginService;

/**
 * @author POD 13
 *
 */
@Controller
public class PortalController {

	/**
	 * 
	 */
	@Autowired
	private LoginService loginService;

	/**
	 * @param model
	 * @param login
	 * @return
	 */
	@RequestMapping("/client-portal")
	public String displayItems(ModelMap model, @SessionAttribute("login") Login login) {
		String response = loginService.validateUserNameAndPassword(login);
		if (response != null) {
			return "home";
		} else {
			return "redirect:login";
		}
	}

	/**
	 * @return
	 */
	@RequestMapping("/schedule")
	public String schedule() {
		return null;
	}

}
