package com.example.school.exception;

public class ClassNotFound extends RuntimeException {
    public ClassNotFound() {

        super("Class not found.");
    }
    public ClassNotFound(String message) {

        super(message);
    }
}
