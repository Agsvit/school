package com.example.school.controller;

import com.example.school.controller.request.ClassCreationRequest;
import com.example.school.controller.response.ClassResponseReturn;
import com.example.school.model.Class;
import com.example.school.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }
    //class- class

    @DeleteMapping(value = "/class/{id}")
    public void deleteDrinksById(@PathVariable(value = "id") Long id) {
        classService.deleteById(id);
    }

    @GetMapping(value = "class/{id}")
    public ClassResponseReturn getClassById(@PathVariable(value = "id") Long id) {
        Class classe = classService.findById(id);
        return new ClassResponseReturn(
                classe.getId(),
                classe.getName(),
                classe.getCapacity()
        );
    }

    @GetMapping(value = "/class")
    public List<ClassResponseReturn> getClasses() {
        List<Class> classes = classService.findAll();
        List<ClassResponseReturn> classResponseReturns = new ArrayList<>();
        for (Class classe : classes) {
            classResponseReturns.add(new ClassResponseReturn(
                    classe.getId(),
                    classe.getName(),
                    classe.getCapacity()
            ));

        }
        return classResponseReturns;
    }
    @PutMapping(value = "/class/{id}")
    public ClassResponseReturn updateClass(@RequestBody ClassCreationRequest classCreationRequest, @PathVariable(value = "id")Long id){
        Class classe = classService.updateClass(Class.builder()
                .name(classCreationRequest.getName())
                .capacity(classCreationRequest.getCapacity())
                .build(), id
        );
        return new ClassResponseReturn(
                classe.getId(),
                classe.getName(),
                classe.getCapacity()
        );
    }
    @PostMapping(value = "/class")
    public ClassResponseReturn addClass(@RequestBody ClassCreationRequest classCreationRequest){
        Class classe = classService.addClass(Class.builder()
                .name(classCreationRequest.getName())
                .capacity(classCreationRequest.getCapacity())
                .build()
        );
        return new ClassResponseReturn(
                classCreationRequest.getId(),
                classCreationRequest.getName(),
                classCreationRequest.getCapacity()
        );
    }
}