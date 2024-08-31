package com.ousama.school.client;

import com.ousama.school.DTO.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "students" , url = "${application.config.student-url}")
public interface StudentClient {

    @GetMapping("school/{school-id}")
    List<Student> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId);

}
