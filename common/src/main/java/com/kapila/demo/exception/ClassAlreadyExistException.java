package com.kapila.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ClassAlreadyExistException extends RuntimeException {

	public ClassAlreadyExistException(String exception) {
		super(exception);
	}

}
