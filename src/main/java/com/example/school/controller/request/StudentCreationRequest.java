package com.example.school.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreationRequest {
    private String name;
    private int age;
    private Long classId;
}
