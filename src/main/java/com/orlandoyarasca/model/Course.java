package com.orlandoyarasca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;

    @Column(nullable = false,length = 250)//, name = "nombre"
    private String name;

    @Column(nullable = false,length = 150)//, acronym = "siglas"
    private String acronym;

    @Column(nullable = false)//, status = "Estado"
    private Boolean status;
}
