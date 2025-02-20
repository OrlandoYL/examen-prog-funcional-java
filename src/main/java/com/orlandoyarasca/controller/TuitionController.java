package com.orlandoyarasca.controller;

import com.orlandoyarasca.dto.CourseStudentRecord;
import com.orlandoyarasca.dto.TuitionDTO;
import com.orlandoyarasca.model.Course;
import com.orlandoyarasca.model.Student;
import com.orlandoyarasca.model.Tuition;
import com.orlandoyarasca.model.TuitionDetail;
import com.orlandoyarasca.service.ITuitionService;
import com.orlandoyarasca.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tuitions")
public class TuitionController {
    private final ITuitionService tuitionServiceImpl;
    private final MapperUtil mapperUtil;
    @GetMapping
    public ResponseEntity<List<TuitionDTO>> findAll() throws Exception{
        List<TuitionDTO> list = mapperUtil.mapList(tuitionServiceImpl.findAll(), TuitionDTO.class,"");
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TuitionDTO> findById(@PathVariable("id") Integer id) throws Exception{
        Tuition tuition = tuitionServiceImpl.findById(id);
        return ResponseEntity.ok(mapperUtil.map(tuition, TuitionDTO.class, ""));
    }
    @PostMapping()
    public ResponseEntity<TuitionDTO> save(@Valid @RequestBody() TuitionDTO dtoTuition) throws Exception{
        Tuition tuitionSave = tuitionServiceImpl.save(mapperUtil.map(dtoTuition, Tuition.class, ""));
        return new ResponseEntity<>(mapperUtil.map(tuitionSave,TuitionDTO.class,""),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TuitionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody() TuitionDTO dtoTuition) throws Exception{
        Tuition tuitionUpdate = tuitionServiceImpl.update(id,mapperUtil.map(dtoTuition, Tuition.class, ""));
        return ResponseEntity.ok(mapperUtil.map(tuitionUpdate,TuitionDTO.class, ""));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        tuitionServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/groupbycourseofstudents")
    public ResponseEntity<List<CourseStudentRecord>> groupbycourseofstudents() throws Exception{
        var tuitionUpdate = tuitionServiceImpl.findByStudentGroupBy();
        return ResponseEntity.ok(tuitionUpdate);
    }

}
