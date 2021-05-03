package com.cognizant.PharmacyMedicineSupplyPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;
import com.cognizant.PharmacyMedicineSupplyPortal.service.RegisterService;

/**
 * @author POD 13
 *
 */
@Controller
public class SignupController {

	/**
	 * 
	 */
	@Autowired
	private RegisterService registerService;

	/**
	 * @param login
	 * @return
	 */
	@PostMapping("/signup")
	public String registerUser(@ModelAttribute("login") Login login) {
		String response = registerService.registerUserNameAndPassword(login);
		
		if (response != null) {
			return "redirect:login";
		} else {
			return "redirect:signup";
		}

	}

	/**
	 * @param login
	 * @return
	 */
	@GetMapping("/signup")
	public String displaySignupPage(@ModelAttribute("login") Login login) {
		return "signup";
	}

}
