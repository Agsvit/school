package com.example.school.controller.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassResponseReturn {
    private Long id;
    private String name;
    private int capacity;
}
