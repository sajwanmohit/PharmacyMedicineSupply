package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author POD 13
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Invalid token..")
public class TokenInvalidException extends RuntimeException {
	/**
	 * @param msg
	 */
	public TokenInvalidException(final String msg) {
		super(msg);
	}
}