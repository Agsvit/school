package com.example.school.exception;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound() {

        super("Student not found.");
    }
    public StudentNotFound(String message) {

        super(message);
    }
}