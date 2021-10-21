package com.example.school.exception;

public class TeacherNotFound extends RuntimeException {
    public TeacherNotFound() {

        super("Teacher not found.");
    }
    public TeacherNotFound(String message) {

        super(message);
    }
}
