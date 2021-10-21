package com.example.school.controller.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherCreationRequest {

    private String name;
    private String subject;
    private int age;
//    private List<Long> classIds;

}
