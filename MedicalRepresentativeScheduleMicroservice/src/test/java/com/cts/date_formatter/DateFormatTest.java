package com.cts.date_formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author POD 13
 *
 */
@ExtendWith(MockitoExtension.class)
class DateFormatTest {

	/**
	 * 
	 */
	/**
	 * 
	 */
	@InjectMocks
	private DateFormat dateFormat;

	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * 
	 */
	@Test
	void testDateToString() {
		final Date date = new Date(1_220_227_200L * 1000);
		String expected = "01-09-2008";
		final String actual = dateFormat.dateToString(date);
		assertEquals(expected, actual, "Equal date");
	}

	/**
	 * @throws ParseException
	 */
	@Test
	void testStringToDate() throws ParseException {
		
		String date = "2008-09-01";
		final Date expected = new Date(1_220_207_400L * 1000);
		final Date actual = dateFormat.stringToDate(date);
		assertEquals(expected, actual, "Equal date");
	}
	
	@Test
	void testStringToDateWrongFormat() throws ParseException {
		
		String date = "ascfdcfa";
		assertThrows(ParseException.class, ()->dateFormat.stringToDate(date), "Wrong Format");
	}

}
