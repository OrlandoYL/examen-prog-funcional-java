package com.orlandoyarasca.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseStudentDTO {
    // Constructor
    public CourseStudentDTO(String courseName, List<String> students) {
        this.courseName = courseName;
        this.students = students;
    }
    private String courseName;
    private List<String> students;
}
