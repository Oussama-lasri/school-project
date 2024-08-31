package com.ousama.school.services;


import com.ousama.school.DTO.Student;
import com.ousama.school.client.StudentClient;
import com.ousama.school.entities.School;
import com.ousama.school.repository.SchoolRepository;
import com.ousama.school.response.FullSchoolResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final  StudentClient studentClient;

    public void save(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    public School findById(int id) {
        return schoolRepository.findById(id).get();
    }

    public void deleteById(int id) {
        schoolRepository.deleteById(id);
    }

    public FullSchoolResponse findSchoolWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId).orElse(School.builder()
                        .email("NOT FOUND")
                        .name("NOT FOUND")
                .build());

        var students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getEmail())
                .email(school.getEmail())
                .students(students).build();
    }
}
