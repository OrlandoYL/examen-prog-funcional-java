package com.orlandoyarasca.service.impl;


import com.orlandoyarasca.model.Course;
import com.orlandoyarasca.model.Student;
import com.orlandoyarasca.repository.IGenericRepo;
import com.orlandoyarasca.repository.ICourseRepo;
import com.orlandoyarasca.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course,Integer> implements ICourseService {
    //@Autowired
    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }


}
