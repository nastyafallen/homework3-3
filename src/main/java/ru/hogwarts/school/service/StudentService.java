package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private long id = 0;

    public Student createStudent(Student student){
        student.setId(++id);
        students.put(student.getId(), student);
        return student;
    }

    public Student getStudent(long id) {
        return students.get(id);
    }

    public Student updateStudent(long id, Student student) {
        if (!students.containsKey(id)) {
            return null;
        }
        students.put(id, student);
        return student;
    }

    public void deleteStudent(long id) {
        students.remove(id);
    }

    public List<Student> getStudentsByAge(int age) {
        List<Student> result = students.values().stream()
                .filter(i -> i.getAge() == age)
                .collect(Collectors.toList());
        return result;
    }


}
