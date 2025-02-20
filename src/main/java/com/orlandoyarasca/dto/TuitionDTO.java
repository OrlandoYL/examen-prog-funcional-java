package com.orlandoyarasca.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.orlandoyarasca.model.Student;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TuitionDTO {

    private Integer idTuition;

    @NotNull
    @JsonIncludeProperties(value = {"idStudent"})
    private Student student;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    private boolean enabled;

    @NotNull
    @JsonManagedReference
    private List<TuitionDetailDTO> details;
}
