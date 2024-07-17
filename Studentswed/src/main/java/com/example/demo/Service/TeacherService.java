
package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repositoris.TeacherRepository;
import com.example.demo.models.Subject;
import com.example.demo.models.Teacher;
@Transactional
@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public List<Teacher> showTeachers(){
        return teacherRepository.findAll();
    }
    @Transactional

    public List<Subject> getSubjectByTeacherId(Long teacherid) {

        Teacher teacher=teacherRepository.findById(teacherid).orElse(null);
        // TODO Auto-generated method stub
        List<Subject>subjects=new ArrayList<>();
        if(null!=teacher){
            subjects=teacher.getSubjects();
        }
        return subjects;
    }
}

