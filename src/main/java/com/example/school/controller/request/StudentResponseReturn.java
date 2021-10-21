package com.example.school.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponseReturn {
    private Long id;
    private String name;
    private int age;
    private Long classId;
    private String className;
}
