package com.example.baithimodul4.controller;

import com.example.baithimodul4.model.Student;
import com.example.baithimodul4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService ;

    @GetMapping
    public ResponseEntity<List<Student>> findAll (){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public  ResponseEntity<Student> findOne (@PathVariable Long id){
        Student student =studentService.findOne(id);
        if(student != null){
            return  new ResponseEntity<>(student,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public  ResponseEntity<Void> save(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @DeleteMapping("{id}")
    public  ResponseEntity<Void> delete (@PathVariable Long id){
        Student student = studentService.findOne(id);
        if(student !=null){
            studentService.delete(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Student>> searchName (@PathVariable ("name") String name){
        return  new ResponseEntity<>(studentService.searchStudent(name),HttpStatus.OK);

    }
}

