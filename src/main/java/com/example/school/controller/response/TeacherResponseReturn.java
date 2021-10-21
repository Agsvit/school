package com.example.school.controller.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherResponseReturn {
    private Long id;
    private String name;
    private String subject;
    private int age;

}
