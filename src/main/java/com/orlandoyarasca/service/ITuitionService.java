package com.orlandoyarasca.service;

import com.orlandoyarasca.dto.CourseStudentRecord;
import com.orlandoyarasca.model.Course;
import com.orlandoyarasca.model.Student;
import com.orlandoyarasca.model.Tuition;
import com.orlandoyarasca.model.TuitionDetail;

import java.util.List;
import java.util.Map;

public interface ITuitionService extends ICrudService<Tuition,Integer>{
    List<CourseStudentRecord> findByStudentGroupBy();
}
