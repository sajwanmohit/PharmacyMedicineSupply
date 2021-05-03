package com.cts.date_formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author POD 13
 *
 */
@Slf4j
@Component
@NoArgsConstructor
public class DateFormat {

	/**
	 * @param date
	 * @return
	 */
	public String dateToString(final Date date) {
		log.info("Formatting Date to String");
		final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(date);
	}

	/**
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public Date stringToDate(final String date) throws ParseException {
		log.info("Formatting String to Date");
		log.info(date);
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(date);
	}
}
