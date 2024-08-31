package com.ousama.school.DTO;


import jakarta.persistence.Entity;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    private String firstname;
    private String lastName;
    private String email;
}
