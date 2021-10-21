package com.example.school.service;

import com.example.school.controller.request.TeacherCreationRequest;
import com.example.school.model.Teacher;
import com.example.school.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Long id) {
        //exception
        return teacherRepository.findById(id).orElseThrow();
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
}
