package com.orlandoyarasca.dto;

import com.orlandoyarasca.model.Student;

import java.util.List;

public record CourseStudentRecord(
        String courseName,
        List<StudentOfCourseDTO> students
) {
}
