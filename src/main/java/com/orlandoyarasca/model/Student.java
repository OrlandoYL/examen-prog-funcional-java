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
public class Student {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;

    @Column(nullable = false,length = 150)//, firstName = "nombre"
    private String firstName;

    @Column(nullable = false,length = 150)//, lastName = "apellidos"
    private String lastName;

    @Column(nullable = false,length = 8,unique = true)//, nroDocument = "Dni"
    private String nroDocument;

    @Column(nullable = false)//, age = "Edad"
    private Integer age;
}
