package com.example.school.controller;

import com.example.school.controller.request.ClassCreationRequest;
import com.example.school.controller.request.TeacherClassResponseReturn;
import com.example.school.controller.request.TeacherCreationRequest;
import com.example.school.controller.request.TeacherResponseReturn;
import com.example.school.controller.response.ClassResponseReturn;
import com.example.school.model.Class;
import com.example.school.model.Teacher;
import com.example.school.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<TeacherResponseReturn> getTeachers() {
        List<TeacherResponseReturn> teacherResps = new ArrayList<>();
        List<Teacher> teachers = teacherService.findAll();
        for (Teacher teacher : teachers) {
            teacherResps.add(new TeacherResponseReturn(
                    teacher.getId(),
                    teacher.getName(),
                    teacher.getSubject(),
                    teacher.getAge()));
        }
        return teacherResps;
    }

    //por response
    @GetMapping("/teachers/{id}")
    public TeacherClassResponseReturn getTeacherById(@PathVariable(value = "id") Long id) {
        Teacher teacher = teacherService.findById(id);
        List<ClassResponseReturn> classResps = new ArrayList<>();
        TeacherClassResponseReturn teacherClassResp = new TeacherClassResponseReturn(teacher.getId()
                , teacher.getName(), teacher.getSubject(), teacher.getAge(), classResps);
        for (Class classe : teacher.getClasses()) {
            ClassResponseReturn classResp = new ClassResponseReturn(
                    classe.getId(),
                    classe.getName(),
                    classe.getCapacity());
            teacherClassResp.getClassResponses().add(classResp);
        }
        return teacherClassResp;
    }

    //Create a teacher
    @PostMapping(value = "/teachers", consumes = "application/json", produces = "application/json")
    public TeacherClassResponseReturn createTeacher(@RequestBody TeacherCreationRequest teacherReq) {
        Teacher newTeacher = Teacher
                .builder()
                .name(teacherReq.getName())
                .subject(teacherReq.getSubject())
                .age(teacherReq.getAge())
                .build();
        teacherService.save(newTeacher);
        TeacherClassResponseReturn teacherResp = new TeacherClassResponseReturn();
        teacherResp.setId(newTeacher.getId());
        teacherResp.setName(newTeacher.getName());
        teacherResp.setSubject(newTeacher.getSubject());
        teacherResp.setAge(newTeacher.getAge());
        return teacherResp;
    }

    //add classes to a teacher
    @PostMapping(value = "/teacher/{id}/results")
    public TeacherClassResponseReturn insertClassOnTeacher(@RequestBody List<ClassCreationRequest> classReqs, Long id) {
        List<Class> classes = new ArrayList<>();
        for (ClassCreationRequest classReq : classReqs) {
            classes.add(Class
                    .builder()
                    .name(classReq.getName())
                    .capacity(classReq.getCapacity())
                    .build());
        }
        Teacher teacher = teacherService.addClass(classes, id);
        List<ClassResponseReturn> classResps = new ArrayList<>();
        TeacherClassResponseReturn teacherClassResp = new TeacherClassResponseReturn(teacher.getId()
                , teacher.getName(), teacher.getSubject(), teacher.getAge(), classResps);
        for (Class classe : teacher.getClasses()) {
            ClassResponseReturn classResp = new ClassResponseReturn(
                    classe.getId(),
                    classe.getName(),
                    classe.getCapacity());
            teacherClassResp.getClassResponses().add(classResp);
        }
        return teacherClassResp;
    }

    //
    @PutMapping(value = "/teachers/{id}")
    public TeacherClassResponseReturn updateTeacher(@PathVariable(value = "id") Long id, @RequestBody TeacherCreationRequest teacherReq) {
        Teacher teacher = teacherService.update(teacherReq, id);
        TeacherClassResponseReturn teacherResp = new TeacherClassResponseReturn();
        teacherResp.setId(teacher.getId());
        teacherResp.setName(teacher.getName());
        teacherResp.setSubject(teacher.getSubject());
        teacherResp.setAge(teacher.getAge());
        return teacherResp;
    }

    @DeleteMapping(value = "/teachers/{id}")
    public void deleteTeacher(Long id) {
        teacherService.deleteById(id);
    }
}