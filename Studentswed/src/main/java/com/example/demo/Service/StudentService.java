package com.example.demo.Service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.Repositoris.StudentRepository;
import com.example.demo.models.Student;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student addStudent(Student student){
        return  studentRepository.save (student);

    }
    public List<Student>getAllStudents(){
        return studentRepository.findAll();

    }


}