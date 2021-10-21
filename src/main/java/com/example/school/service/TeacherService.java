package com.example.school.service;

import com.example.school.controller.request.TeacherCreationRequest;
import com.example.school.exception.TeacherNotFound;
import com.example.school.model.Class;
import com.example.school.model.Teacher;
import com.example.school.repository.ClassRepository;
import com.example.school.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ClassRepository classRepository;

    public TeacherService(TeacherRepository teacherRepository, ClassRepository classRepository) {
        this.teacherRepository = teacherRepository;
        this.classRepository = classRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Long id) {
        //exception
        return teacherRepository.findById(id).orElseThrow(TeacherNotFound::new);
    }

    public Teacher save(Teacher newTeacher) {
        return teacherRepository.save(newTeacher);
    }

    public Teacher update(TeacherCreationRequest teacherReq, Long id) {
        Teacher teacher = this.findById(id);
        teacher.setName(teacherReq.getName());
        teacher.setSubject(teacherReq.getSubject());
        teacher.setAge(teacherReq.getAge());
        return teacherRepository.save(teacher);
    }

    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    public Teacher addClass(List<Class> classes, Long id) {
        Teacher teacher = this.findById(id);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);
        teacher.setClasses(classes);
        for (Class classe : classes) {
            classe.setTeachers(teachers);
            classRepository.save(classe);
        }
        return teacher;
    }
}
