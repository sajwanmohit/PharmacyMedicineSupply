package com.cognizant.PharmacyMedicineSupplyPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;
import com.cognizant.PharmacyMedicineSupplyPortal.service.LoginService;

/**
 * @author POD 13
 *
 */
@SessionAttributes("login")
@Controller
public class LoginController {

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
	@GetMapping("/login")
	public String displayLoginPage(Model model, Login login) {
		return "login";
	}

	/**
	 * @param login
	 * @return
	 */
	@PostMapping("/login")
	public String parseLoginPage(@ModelAttribute("login") Login login,RedirectAttributes redirectAtt) {
		String response = loginService.validateUserNameAndPassword(login);
		
		if (response != null) {
			return "redirect:client-portal";
		} else {
			redirectAtt.addFlashAttribute("message", "Enter valid credentials");
			return "redirect:login";
		}

	}

}
