package com.smhrd.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super(id + "NotFoundException");
    }
}
