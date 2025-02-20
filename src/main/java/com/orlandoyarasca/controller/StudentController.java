package com.orlandoyarasca.controller;

import com.orlandoyarasca.dto.GenericResponse;
import com.orlandoyarasca.dto.StudentDTO;
import com.orlandoyarasca.model.Student;
import com.orlandoyarasca.service.IStudentService;
import com.orlandoyarasca.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final IStudentService studentServiceImpl;
    private final MapperUtil mapperUtil;
    @GetMapping
    public ResponseEntity<GenericResponse<StudentDTO>> findAll() throws Exception{
        List<StudentDTO> list = mapperUtil.mapList(studentServiceImpl.findAll(), StudentDTO.class,"studentMapper");
        return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDTO>> findById(@PathVariable("id") Integer id) throws Exception{
        Student student = studentServiceImpl.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "success",List.of(mapperUtil.map(student, StudentDTO.class, "studentMapper"))));
    }
    @PostMapping()
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody() StudentDTO dtoStudent) throws Exception{
        Student studentSave = studentServiceImpl.save(mapperUtil.map(dtoStudent, Student.class, "studentMapper"));
        return new ResponseEntity<>(mapperUtil.map(studentSave,StudentDTO.class,"studentMapper"),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody() StudentDTO dtoStudent) throws Exception{
        Student studentUpdate = studentServiceImpl.update(id,mapperUtil.map(dtoStudent, Student.class, "studentMapper"));
        return ResponseEntity.ok(mapperUtil.map(studentUpdate,StudentDTO.class, "studentMapper"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        studentServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/order/desc")
    public ResponseEntity<GenericResponse<StudentDTO>> findAllOrderAgeDesc() throws Exception{
        List<StudentDTO> list = mapperUtil.mapList(studentServiceImpl.findAllOrderAgeDesc(), StudentDTO.class,"studentMapper");
        return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
    }

    @GetMapping("/pagination")
    public ResponseEntity<GenericResponse<Page<StudentDTO>>> findPage(Pageable pageable) {
        Page<StudentDTO> page = studentServiceImpl.findPage(pageable).map(e -> mapperUtil.map(e, StudentDTO.class, "studentMapper"));

        return ResponseEntity.ok(new GenericResponse<>(200, "success", List.of(page)));

    }


}
