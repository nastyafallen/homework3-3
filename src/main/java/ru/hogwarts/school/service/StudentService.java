package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private Map<Long, Student> students = new HashMap<>();
    private long id = 0L;

    public Student createStudent(Student student){
        id++;
        students.put(id, student);
        return student;
    }

    public Student getStudent(long id) {
        return students.get(id);
    }

    public Student updateStudent(long id, Student student) {
        students.put(id, student);
        return student;
    }

    public Student deleteStudent(long id) {
        return students.remove(id);
    }

    public List<Student> getStudentsByAge(int age) {
        return students.values().stream()
                .filter(i -> i.getAge() == age)
                .collect(Collectors.toList());
    }


}
