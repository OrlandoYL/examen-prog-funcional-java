package com.orlandoyarasca.service.impl;


import com.orlandoyarasca.model.Student;
import com.orlandoyarasca.repository.IGenericRepo;
import com.orlandoyarasca.repository.IStudentRepo;
import com.orlandoyarasca.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.*;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student,Integer> implements IStudentService {
    //@Autowired
    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Student> findPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<Student> findAllOrderAgeDesc() {
        return repo.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .collect(toList());
    }
}
