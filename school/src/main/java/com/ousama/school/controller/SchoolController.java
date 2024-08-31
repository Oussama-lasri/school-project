package com.ousama.school.controller;


import com.ousama.school.entities.School;
import com.ousama.school.response.FullSchoolResponse;
import com.ousama.school.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;
    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.findAll());
    }

    @GetMapping("/with-student/{school-id}")
    public ResponseEntity<FullSchoolResponse> getAllSchools(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolWithStudents(schoolId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school) {
        schoolService.save(school);
    }
}
