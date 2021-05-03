package com.cognizant.PharmacyMedicineSupplyPortal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.cognizant.PharmacyMedicineSupplyPortal.client.ScheduleServiceFeign;
import com.cognizant.PharmacyMedicineSupplyPortal.model.InputDate;
import com.cognizant.PharmacyMedicineSupplyPortal.model.Login;
import com.cognizant.PharmacyMedicineSupplyPortal.model.RepSchedule;
import com.cognizant.PharmacyMedicineSupplyPortal.service.LoginService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author POD 13
 *
 */
@Controller
@Slf4j
public class ScheduleController {

	/**
	 * 
	 */
	@Autowired
	private ScheduleServiceFeign feign;
	
	/**
	 * 
	 */
	@Autowired
	private LoginService loginService;

	/**
	 * @param startDate
	 * @param map
	 * @return
	 */
	@GetMapping("/schedule")
	public String home(@ModelAttribute("startDate") InputDate startDate, ModelMap map) {
		return "schedule";
	}

	/**
	 * @param login
	 * @param startDate
	 * @param map
	 * @return
	 */
	@PostMapping("/schedule")
	public String scheduleMeeting(@SessionAttribute("login") Login login,@ModelAttribute("startDate") InputDate startDate, ModelMap map) {
		String response = loginService.validateUserNameAndPassword(login);
		log.debug("schedule post method" + startDate.getDate());
		List<RepSchedule> list = new ArrayList<>();
		list = feign.scheduleMeeting(response,startDate.getDate());
		map.put("scheduleList", list);
		return "schedule";
	}
}
