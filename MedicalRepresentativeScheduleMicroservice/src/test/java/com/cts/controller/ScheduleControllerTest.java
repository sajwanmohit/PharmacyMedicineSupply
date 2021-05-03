package com.cts.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.feign.AuthServiceFeign;
import com.cts.model.RepSchedule;
import com.cts.service.ScheduleService;
import com.google.common.collect.Lists;

/**
 * @author POD 13
 *
 */
@AutoConfigureMockMvc
@ContextConfiguration(classes = {ScheduleController.class, ScheduleService.class, AuthServiceFeign.class})
@WebMvcTest
class ScheduleControllerTest {

	/**
	 * 
	 */
	@InjectMocks
	private ScheduleController scheduleController;

	/**
	 * 
	 */
	@MockBean
	private ScheduleService service;

	/**
	 * 
	 */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * 
	 */
	@MockBean
	private AuthServiceFeign authClient;

	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * @throws Exception
	 */
	@Test
	void testScheduleMeeting() throws Exception {
		
		RepSchedule s1 = new RepSchedule("repName", "doctorName", "treatingAilment", "medicine", "1PM to 2PM",
				"06-08-2020", 9876543210L);
		RepSchedule s2 = new RepSchedule("repName1", "doctorName1", "treatingAilment1", "medicine1", "1PM to 2PM",
				"07-08-2020", 9876503210L);
		doReturn(Lists.newArrayList(s1, s2)).when(service).scheduleMeeting("authorization","2020-08-06");
		doReturn(Boolean.TRUE).when(authClient).validate("authorization");
		

		mockMvc.perform(get("/RepSchedule").contentType(MediaType.APPLICATION_JSON)
				.param("scheduleStartDate", "2020-08-06").header("Authorization", "authorization"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",hasSize(2)))
				.andExpect(jsonPath("$[0].repName", is("repName")))
				.andExpect(jsonPath("$[0].doctorName", is("doctorName")))
				.andExpect(jsonPath("$[0].treatingAilment", is("treatingAilment")))
				.andExpect(jsonPath("$[0].medicine", is("medicine")))
				.andExpect(jsonPath("$[0].slot", is("1PM to 2PM")))
				.andExpect(jsonPath("$[0].date", is("06-08-2020")))
				.andExpect(jsonPath("$[0].doctorContact", is(9_876_543_210L)))
				.andExpect(jsonPath("$[1].repName", is("repName1")))
				.andExpect(jsonPath("$[1].doctorName", is("doctorName1")))
				.andExpect(jsonPath("$[1].treatingAilment", is("treatingAilment1")))
				.andExpect(jsonPath("$[1].medicine", is("medicine1")))
				.andExpect(jsonPath("$[1].slot", is("1PM to 2PM")))
				.andExpect(jsonPath("$[1].date", is("07-08-2020")))
				.andExpect(jsonPath("$[1].doctorContact", is(9_876_503_210L)));
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	void testScheduleMeetingWrongAuthorization() throws Exception {
		RepSchedule s1 = new RepSchedule("repName", "doctorName", "treatingAilment", "medicine", "1PM to 2PM",
				"06-08-2020", 987654321);
		RepSchedule s2 = new RepSchedule("repName1", "doctorName1", "treatingAilment1", "medicine1", "1PM to 2PM",
				"07-08-2020", 987650321);
		doReturn(Lists.newArrayList(s1, s2)).when(service).scheduleMeeting("authorization","2020-08-06");
		doReturn(Boolean.FALSE).when(authClient).validate("authorization");
		

		mockMvc.perform(get("/RepSchedule").contentType(MediaType.APPLICATION_JSON)
				.param("scheduleStartDate", "2020-08-06").header("Authorization", "authorization"))
				.andExpect(status().isUnauthorized());
		
	}


}
