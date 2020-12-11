package com.kapila.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EnrollmentAlreadyExistException extends RuntimeException {

	public EnrollmentAlreadyExistException(String exception) {
		super(exception);
	}

}
