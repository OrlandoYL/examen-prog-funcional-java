package com.orlandoyarasca.config;

import com.orlandoyarasca.dto.CourseDTO;
import com.orlandoyarasca.dto.StudentDTO;
import com.orlandoyarasca.model.Course;
import com.orlandoyarasca.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }
    @Bean("studentMapper")
    public ModelMapper studentMapper() {
        ModelMapper mapper = new ModelMapper();
        //Handler Missmatches
        //Lectura GET
        mapper.createTypeMap(Student.class, StudentDTO.class)
                .addMapping(Student::getFirstName,(dest, v)->dest.setFirstNameStudent((String)v))
                .addMapping(Student::getLastName,(dest, v)->dest.setLastNameStudent((String)v))
                .addMapping(Student::getNroDocument,(dest, v)->dest.setNroDocumentStudent((String)v))
                .addMapping(Student::getAge,(dest, v)->dest.setAgeStudent((Integer) v));

        //Escritura POST
        mapper.createTypeMap(StudentDTO.class, Student.class)
                .addMapping(StudentDTO::getFirstNameStudent,(dest, v)->dest.setFirstName((String)v))
                .addMapping(StudentDTO::getLastNameStudent,(dest, v)->dest.setLastName((String)v))
                .addMapping(StudentDTO::getNroDocumentStudent,(dest, v)->dest.setNroDocument((String)v))
                .addMapping(StudentDTO::getAgeStudent,(dest, v)->dest.setAge((Integer) v));
        return mapper;
    }
    @Bean("courseMapper")
    public ModelMapper courseMapper() {
        ModelMapper mapper = new ModelMapper();
        //Handler Missmatches
        //Lectura GET
        mapper.createTypeMap(Course.class, CourseDTO.class)
                .addMapping(Course::getName,(dest, v)->dest.setNameOfCourse((String)v))
                .addMapping(Course::getAcronym,(dest, v)->dest.setAcronymOfCourse((String)v))
                .addMapping(Course::getStatus,(dest, v)->dest.setStatusOfCourse((Boolean) v));

        //Escritura POST
        mapper.createTypeMap(CourseDTO.class, Course.class)
                .addMapping(CourseDTO::getNameOfCourse,(dest, v)->dest.setName((String)v))
                .addMapping(CourseDTO::getAcronymOfCourse,(dest, v)->dest.setAcronym((String)v))
                .addMapping(CourseDTO::getStatusOfCourse,(dest, v)->dest.setStatus((Boolean) v));
        return mapper;
    }
}
