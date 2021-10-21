package com.example.school.service;

import com.example.school.controller.request.StudentCreationRequest;
import com.example.school.exception.ClassNotFound;
import com.example.school.exception.StudentNotFound;
import com.example.school.model.Class;
import com.example.school.model.Student;
import com.example.school.repository.ClassRepository;
import com.example.school.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    public StudentService(StudentRepository studentRepository, ClassRepository classRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
    }


    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        //exception
        return studentRepository.findById(id).orElseThrow();
    }

    public Student findByName(String name) {
        //exception
        return studentRepository.findByName(name).orElseThrow(StudentNotFound::new);
    }

    public Student save(Student newStudent, Long classId) {
        Class classe = classRepository.findById(classId).orElseThrow(ClassNotFound::new);
        newStudent.setClasse(classe);
        return studentRepository.save(newStudent);
    }

    public Student update(StudentCreationRequest studentReq, Long id) {
        Student student =this.findById(id);
        Class classe = classRepository.findById(studentReq.getClassId()).orElseThrow(ClassNotFound::new);
        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setClasse(classe);
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
