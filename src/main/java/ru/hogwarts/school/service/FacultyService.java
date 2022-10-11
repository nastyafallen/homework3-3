package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private Map<Long, Faculty> faculties = new HashMap<>();
    private Long id = 1L;

    public Faculty createFaculty(Faculty faculty){
        faculties.put(id, faculty);
        id++;
        return faculty;
    }

    public Faculty getFaculty(Long id) {
        return faculties.get(id);
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        faculties.put(id, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long id) {
        return faculties.remove(id);
    }

    public List<Faculty> getFacultiesByColor(String color) {
        return faculties.values().stream()
                .filter(i -> i.getColor().equals(color))
                .collect(Collectors.toList());
    }

}
