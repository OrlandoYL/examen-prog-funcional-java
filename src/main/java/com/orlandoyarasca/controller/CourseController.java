package com.orlandoyarasca.controller;

import com.orlandoyarasca.dto.CourseDTO;
import com.orlandoyarasca.dto.GenericResponse;
import com.orlandoyarasca.model.Course;
import com.orlandoyarasca.service.ICourseService;
import com.orlandoyarasca.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final ICourseService courseServiceImpl;
    private final MapperUtil mapperUtil;
    @GetMapping
    public ResponseEntity<GenericResponse<CourseDTO>> findAll() throws Exception{
        List<CourseDTO> list = mapperUtil.mapList(courseServiceImpl.findAll(), CourseDTO.class,"courseMapper");
        return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CourseDTO>> findById(@PathVariable("id") Integer id) throws Exception{
        Course course = courseServiceImpl.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", List.of(mapperUtil.map(course, CourseDTO.class, "courseMapper"))));
    }
    @PostMapping()
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody() CourseDTO dtoCourse) throws Exception{
        Course courseSave = courseServiceImpl.save(mapperUtil.map(dtoCourse, Course.class, "courseMapper"));
        return new ResponseEntity<>(mapperUtil.map(courseSave,CourseDTO.class,"courseMapper"),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody() CourseDTO dtoCourse) throws Exception{
        Course courseUpdate = courseServiceImpl.update(id,mapperUtil.map(dtoCourse, Course.class, "courseMapper"));
        return ResponseEntity.ok(mapperUtil.map(courseUpdate,CourseDTO.class, "courseMapper"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        courseServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

}
