package com.example.demo.common.service;

import com.example.demo.common.dto.StudentReq;
import com.example.demo.common.dto.StudentRes;
import com.example.demo.common.entity.Studententity;
import com.example.demo.common.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
//        StudentRepository studentRepository = new StudentRepository();
        this.studentRepository = studentRepository;
    }

    public void saveStudent(StudentReq studentReq) {
        Studententity studentEntity = new Studententity();

        studentEntity.setName(studentReq.getName());
        studentEntity.setAge(studentReq.getAge());
        studentEntity.setStudentNo(studentReq.getStudentNo());
        studentEntity.setHeight(studentReq.getHeight());
        studentEntity.setStudentNo(studentReq.getStudentNo());
        studentEntity.setPoint(studentReq.getPoint());
        studentEntity.setRoom(studentReq.getRoom());
        studentEntity.setYear(studentReq.getYear());

        studentRepository.save(studentEntity);

    }
    public List<StudentRes> findAll(){
        List<StudentRes> studentResList = new ArrayList<>();
        List<Studententity> studententities = (List<Studententity>) studentRepository.findAll();
        for (int i = 0; i < studententities.size(); i++){
            StudentRes studentRes = new StudentRes();
            studentRes.setName(studententities.get(i).getName());
            studentRes.setAge(studententities.get(i).getAge());
            studentRes.setStudentNo(studententities.get(i).getStudentNo());
            studentRes.setHeight(studententities.get(i).getHeight());
            studentRes.setPoint(studententities.get(i).getPoint());
            studentRes.setRoom(studententities.get(i).getRoom());
            studentRes.setYear(studententities.get(i).getYear());
            studentResList.add(studentRes);
        }
        return studentResList;
    }
    public  StudentRes findById(Long id) {
        Studententity studententity = studentRepository.findById(id).get();
        StudentRes studentRes = new StudentRes();

        studentRes.setName(studententity.getName());
        studentRes.setAge(studententity.getAge());
        studentRes.setStudentNo(studententity.getStudentNo());
        studentRes.setHeight(studententity.getHeight());
        studentRes.setPoint(studententity.getPoint());
        studentRes.setRoom(studententity.getRoom());
        studentRes.setYear(studententity.getYear());
        return studentRes;
    }
}

