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
public class StudentDTO {

    private Integer idStudent;
    @NotNull
    @Size(min = 3, max = 150)
    private String firstNameStudent;
    @Size(min = 3, max = 150)
    private String lastNameStudent;
    @NotNull
    @Size(min = 8, max = 11)
    private String nroDocumentStudent;
    @NotNull
    private Integer ageStudent;
}
