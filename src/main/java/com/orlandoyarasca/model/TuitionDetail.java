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
public class TuitionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idTuitionDetail;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_tuition",foreignKey = @ForeignKey(name = "FK_DETAIL_TUITION"))
    private Tuition tuition;

    @ManyToOne
    @JoinColumn(nullable = false,name = "id_course",foreignKey = @ForeignKey(name = "FK_DETAIL_COURSE"))
    private Course course;

    @Column(nullable = false)
    private String classroom;

}
