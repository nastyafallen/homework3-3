package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> getStudent(long id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(long id, Student student) {
        Optional<Student> optional = Optional.of(studentRepository.findById(id));
        optional.ifPresent(o -> {o.equals(student), studentRepository.save(o)});
        studentRepository.
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByAge(int age) {
        return studentRepository.getStudentsByAge(age);
    }


}
