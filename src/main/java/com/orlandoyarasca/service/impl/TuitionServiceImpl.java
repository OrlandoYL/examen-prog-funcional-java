package com.orlandoyarasca.service.impl;


import com.orlandoyarasca.dto.CourseStudentDTO;
import com.orlandoyarasca.dto.CourseStudentRecord;
import com.orlandoyarasca.dto.StudentOfCourseDTO;
import com.orlandoyarasca.model.Course;
import com.orlandoyarasca.model.Student;
import com.orlandoyarasca.model.Tuition;
import com.orlandoyarasca.model.TuitionDetail;
import com.orlandoyarasca.repository.IGenericRepo;
import com.orlandoyarasca.repository.ITuitionRepo;
import com.orlandoyarasca.service.ITuitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class TuitionServiceImpl extends CRUDImpl<Tuition,Integer> implements ITuitionService {
    //@Autowired
    private final ITuitionRepo repo;

    @Override
    protected IGenericRepo<Tuition, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<CourseStudentRecord> findByStudentGroupBy() {
        Stream<Tuition> tuitionStream = repo.findAll().stream();

        Stream<List<TuitionDetail>> lsStream = tuitionStream.map(Tuition::getDetails);

        Stream<TuitionDetail> streamDetail = lsStream.flatMap(Collection::stream); //list -> list.stream()
        Map<Course,List<Student>> byCourse = streamDetail
                .collect(groupingBy(TuitionDetail::getCourse, mapping(
                                tuitionDetail -> tuitionDetail.getTuition().getStudent(),
                                toList()
                        )
                ));
        //List<CourseStudentRecord> courseListStudents =

        return byCourse.entrySet().stream()
                .map(e -> {
                    String nameOfCourse = e.getKey().getName();
                    List<StudentOfCourseDTO> students = e.getValue().stream()
                            .map(c->new StudentOfCourseDTO(c.getFirstName(),c.getLastName()))
                            .collect(toList());
                    return new CourseStudentRecord(nameOfCourse,students);
                })            .toList();
    }
}
