package com.orlandoyarasca.service;

import com.orlandoyarasca.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService extends ICrudService<Student,Integer>{
    Page<Student> findPage(Pageable pageable);
    List<Student> findAllOrderAgeDesc();

}
