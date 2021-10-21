package com.example.school.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherClassResponseReturn {
    private Long id;
    private String name;
    private String subject;
    private int age;

//    private List<ClassResponseRequest> classResponses;

}
