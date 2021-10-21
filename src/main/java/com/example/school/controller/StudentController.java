package com.example.school.controller;

import com.example.school.controller.request.StudentCreationRequest;
import com.example.school.controller.request.StudentResponseReturn;
import com.example.school.model.Student;
import com.example.school.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentResponseReturn> getStudents() {
        List<StudentResponseReturn> studentResps = new ArrayList<>();
        List<Student> students = studentService.findAll();
        for (Student student : students) {
            studentResps.add(new StudentResponseReturn(
                    student.getId(),
                    student.getName(),
                    student.getAge(),
                    student.getClasse().getId(),
                    student.getClasse().getName()));
        }
        return studentResps;
    }

    @GetMapping("/students/{id}")
    public StudentResponseReturn getStudentById(@PathVariable(value = "id") Long id) {
        Student student = studentService.findById(id);
        return new StudentResponseReturn(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getClasse().getId(),
                student.getClasse().getName());
    }

    @GetMapping("/students/{name}")
    public StudentResponseReturn getStudentByName(@PathVariable String name) {
        Student student = studentService.findByName(name);
        return new StudentResponseReturn(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getClasse().getId(),
                student.getClasse().getName());
    }

    @PostMapping(value = "/students", consumes = "application/json", produces = "application/json")
    public StudentResponseReturn createStudent(@RequestBody StudentCreationRequest studentReq) {
        Student newStudent = Student
                .builder()
                .name(studentReq.getName())
                .age(studentReq.getAge())
                .build();
        studentService.save(newStudent, studentReq.getClassId());
        StudentResponseReturn studentResp = new StudentResponseReturn();
        studentResp.setId(newStudent.getId());
        studentResp.setName(newStudent.getName());
        studentResp.setAge(newStudent.getAge());
        studentResp.setClassId(newStudent.getClasse().getId());
        studentResp.setClassName(newStudent.getClasse().getName());
        return studentResp;
    }

    @PutMapping(value = "/students/{id}")
    public StudentResponseReturn updateStudent(@PathVariable(value = "id") Long id, @RequestBody StudentCreationRequest studentReq) {
        Student student = studentService.update(studentReq, id);
        StudentResponseReturn studentResp = new StudentResponseReturn();
        studentResp.setId(student.getId());
        studentResp.setName(student.getName());
        studentResp.setAge(student.getAge());
        studentResp.setClassId(student.getClasse().getId());
        studentResp.setClassName(student.getClasse().getName());
        return studentResp;
    }

    @DeleteMapping(value = "/students/{id}")
    public void deleteStudent(Long id) {
        studentService.deleteById(id);
    }
}
