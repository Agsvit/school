package com.example.school.controller.request;

import com.example.school.controller.response.ClassResponseReturn;
import lombok.*;

import java.util.List;

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

    private List<ClassResponseReturn> classResponses;

}
