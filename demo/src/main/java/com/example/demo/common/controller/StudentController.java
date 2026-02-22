package com.example.demo.common.controller;

import com.example.demo.common.dto.StudentReq;
import com.example.demo.common.dto.StudentRes;
import com.example.demo.common.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    private final StudentService studentService; //ประกาศตัวแปร

    public StudentController(StudentService studentService){ //นำตัวแปรมาใส่
        this.studentService = studentService; //นำตัวแปรมา = ตัวแปร
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody  StudentReq studentReq){
        studentService.saveStudent(studentReq);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get-all")
    public ResponseEntity<List <StudentRes>> getall()
    {
        List<StudentRes>studentResList = studentService.findAll();
        return ResponseEntity.ok(studentResList);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<StudentRes> getById(@PathVariable Long id)
    {
        StudentRes studentRes = studentService.findById(id);
        return ResponseEntity.ok(studentRes);
    }
}


