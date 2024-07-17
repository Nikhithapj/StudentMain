package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Service.StudentService;
import com.example.demo.Service.TeacherService;
import com.example.demo.models.Student;
import com.example.demo.models.Subject;
import com.example.demo.models.Teacher;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class CController {
    private TeacherService teacherService;
    public StudentService studentService;

    public CController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @GetMapping("/")

    public String index() {
        System.out.println("jkh");
        return "index";
    }

    @GetMapping("/addTeachers")
    public String showAddTeacherForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "addTeacher";

    }

    @PostMapping("/saveTeacher")
    public String addTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "redirect:/";
    }

    @GetMapping("/getallTeachers")
    public String getAllTeachers(Model model) {
        List<Teacher> teachers = teacherService.showTeachers();
        model.addAttribute("teachers", teachers);
        return "getallTeachers";

    }

    @GetMapping("/addStudent")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addstudent";

    }

    @PostMapping("/saveStudent")
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/getallstudents")

    public String getallstudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        System.out.println(students);

        model.addAttribute("students", students);
        return "getallstudents";
    }

    @PostMapping("/getTeacherSubjects")
    public String getTeacherSubjects(@RequestParam("teacher_id")Long teacher_id,Model model) {
        System.out.println(teacher_id);
        List <Subject>subjects=teacherService.getSubjectByTeacherId(teacher_id);

        System.out.println(subjects);
        model.addAttribute("subject", subjects);


        model.addAttribute("teacher_id", teacher_id);


        return "index";
    }






}