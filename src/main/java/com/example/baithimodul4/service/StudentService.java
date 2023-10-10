package com.example.baithimodul4.service;

import com.example.baithimodul4.model.Student;
import com.example.baithimodul4.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository ;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findOne(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);

    }

    @Override
    public void delete(Long id) {
     studentRepository.deleteById(id);

    }

    @Override
    public List<Student> searchStudent(String name) {
        return studentRepository.searchStudent(name);
    }
}
