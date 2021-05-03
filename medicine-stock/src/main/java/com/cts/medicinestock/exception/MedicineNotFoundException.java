package com.cts.medicinestock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author POD 13
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Invalid token..")
public class MedicineNotFoundException extends RuntimeException  {
	/**
	 * @param msg
	 */
	public  MedicineNotFoundException(final String msg) {
		super(msg);
	}
}
