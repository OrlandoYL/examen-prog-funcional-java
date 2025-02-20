package com.orlandoyarasca.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    private Integer idCourse;

    @NotNull
    @Size(min = 3, max = 150)
    private String nameOfCourse;

    @Size(min = 5, max = 15)
    private String acronymOfCourse;

    @NotNull
    private Boolean statusOfCourse;
}
