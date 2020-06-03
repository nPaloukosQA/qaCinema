package com.qa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The standard screen doesn't exist")
public class StandardScreenNotFoundException extends EntityNotFoundException {
    private static final long serialVersionUID = 34759L;
}
