package com.cts.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.TokenInvalidException;
import com.cts.feign.AuthServiceFeign;
import com.cts.model.RepSchedule;
import com.cts.service.ScheduleService;
import com.opencsv.exceptions.CsvValidationException;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author POD 13
 *
 */
@Slf4j
@RestController
@NoArgsConstructor
public class ScheduleController {

	/**
	 * 
	 */
	@Autowired
	private ScheduleService service;
	
	/**
	 * 
	 */
	@Autowired
	private AuthServiceFeign authClient;

	/**
	 * @param authorization
	 * @param scheduleStartDate
	 * @return
	 * @throws ParseException
	 * @throws CsvValidationException
	 * @throws IOException
	 */
	@GetMapping("/RepSchedule")
	public List<RepSchedule> scheduleMeeting(@RequestHeader("Authorization")String authorization,
			@RequestParam("scheduleStartDate")String scheduleStartDate) throws ParseException, CsvValidationException, IOException {
		
		final boolean response = authClient.validate(authorization);
		if (response) {
			log.info("Date input given.");
			log.debug("Entering Service layer");
			return service.scheduleMeeting(authorization,scheduleStartDate);
		} else {
			throw new TokenInvalidException("USER UNAUTHORIZED");
		}
	}
}
