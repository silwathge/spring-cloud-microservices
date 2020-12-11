package com.kapila.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ServiceNotAvaiableException extends RuntimeException {

	public ServiceNotAvaiableException(String exception) {
		super(exception);
	}

}
