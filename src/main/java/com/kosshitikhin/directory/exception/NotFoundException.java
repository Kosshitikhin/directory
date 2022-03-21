package com.kosshitikhin.directory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Data not found");
    }

    public NotFoundException(String message) {
        super(message);
    }

    public static NotFoundException entry() {
        return new NotFoundException("Such entry doesn't exist.");
    }
}
