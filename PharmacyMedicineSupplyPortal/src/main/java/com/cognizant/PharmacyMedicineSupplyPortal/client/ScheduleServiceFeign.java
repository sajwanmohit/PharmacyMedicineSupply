package com.cognizant.PharmacyMedicineSupplyPortal.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.PharmacyMedicineSupplyPortal.model.RepSchedule;

/**
 * @author POD 13
 *
 */
@FeignClient(name = "schedule-service", url = "http://localhost:8086")
public interface ScheduleServiceFeign {

	/**
	 * @param authorization
	 * @param scheduleStartDate
	 * @return
	 */
	@GetMapping(value = "/RepSchedule")
	public List<RepSchedule> scheduleMeeting(@RequestHeader("Authorization") String authorization,@RequestParam("scheduleStartDate") String scheduleStartDate);
}
