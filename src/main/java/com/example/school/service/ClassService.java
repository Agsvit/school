package com.example.school.service;

import com.example.school.exception.ClassNotFound;
import com.example.school.model.Class;
import com.example.school.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public void deleteById(Long id){
         classRepository.deleteById(id);
    }

    public Class findById(Long id) {
        return classRepository.findById(id).orElseThrow(ClassNotFound::new);
    }

    public List<Class> findAll() {
            return classRepository.findAll();
    }

    public Class updateClass(Class newClass, Long id) {
        Class classe = this.findById(id);
        classe.setName(newClass.getName());
        classe.setCapacity(newClass.getCapacity());
        return classe;
    }

    public Class addClass(Class classe) {
        return classRepository.save(classe);
    }
}
