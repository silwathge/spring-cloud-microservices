package com.kapila.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class StudentAlreadyExistException extends RuntimeException {

	public StudentAlreadyExistException(String exception) {
		super(exception);
	}

}
