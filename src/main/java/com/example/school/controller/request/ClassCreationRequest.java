package com.example.school.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassCreationRequest {
    private Long id;
    private String name;
    private int capacity;
}
