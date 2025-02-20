package com.orlandoyarasca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tuition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idTuition;

    @ManyToOne
    @JoinColumn(name = "id_student",nullable = false,foreignKey = @ForeignKey(name = "FK_TUITION_STUDENT"))
    private Student student;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "tuition",cascade = CascadeType.ALL)
    private List<TuitionDetail> details;
}
