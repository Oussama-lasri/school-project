package com.ousama.school.response;

import com.ousama.school.DTO.Student;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FullSchoolResponse {

    private String name ;
    private String email ;

    private List<Student> students ;

}
