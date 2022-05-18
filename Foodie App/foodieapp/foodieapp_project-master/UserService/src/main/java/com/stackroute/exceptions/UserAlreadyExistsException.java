package com.stackroute.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.CONFLICT,reason="User Already exists")
public class UserAlreadyExistsException {

	private static final long serialVersionUID = 1L;

}
