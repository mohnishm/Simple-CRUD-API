package com.puratis.project.resource;

import com.puratis.project.daos.StudentRepository;
import com.puratis.project.models.Student;
import com.puratis.project.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentResource {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student retrieveStudent(@PathVariable String id) {
        Optional<Student> student = studentRepository.findById(id);

        if (!student.isPresent())
            throw new StudentNotFoundException("id-" + id);

        return student.get();
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentRepository.deleteById(id);
    }

    @PostMapping("/students")
    public String createStudent(@Valid @RequestBody Student student) {
        studentRepository.save(student);
        return "Added book with id : " + student.getId();
    }

    @PutMapping("/students/{id}")
    public String updateStudent(@Valid @RequestBody Student student, @PathVariable String id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (!studentOptional.isPresent())
            return "Student with id : " + student.getId() + " not found.";

        student.setId(id);

        studentRepository.save(student);

        return "Student record with id : " + student.getId() + " updated.";
    }
}
