package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity createStudent(@RequestBody Student student) {
        Student newStudent = studentService.createStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping("{id}")
    public ResponseEntity getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping
    public ResponseEntity updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student.getId(), student);
        return  ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        Student deletedStudent = studentService.deleteStudent(id);
        return ResponseEntity.ok(deletedStudent);
    }

    @GetMapping("{age}")
    public ResponseEntity getStudentsByAge(@PathVariable int age) {
        List<Student> students = studentService.getStudentsByAge(age);
        return ResponseEntity.ok(students);
    }

}
