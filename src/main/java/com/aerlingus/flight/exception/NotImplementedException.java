package com.aerlingus.flight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class NotImplementedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotImplementedException(String message) {
        super(message);
    }
}