package com.demo.crud.controller;

import com.demo.crud.entity.Student;
import com.demo.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getStudents();
    }
    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable("id") Long id){
        return studentService.getStudents(id);
    }


    @PostMapping
    public void saveUpdate(@RequestBody Student student){
        studentService.saveOrUpdate(student);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){

        studentService.delete(id);
    }
}
