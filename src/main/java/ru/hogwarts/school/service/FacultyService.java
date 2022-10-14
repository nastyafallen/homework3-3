package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long id = 0;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++id);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty getFaculty(long id) {
        return faculties.get(id);
    }

    public Faculty updateFaculty(long id, Faculty faculty) {
        if (!faculties.containsKey(id)) {
            return null;
        }
        faculties.put(id, faculty);
        return faculty;
    }

    public void deleteFaculty(long id) {
        faculties.remove(id);
    }

    public List<Faculty> getFacultiesByColor(String color) {
        List<Faculty> result = faculties.values().stream()
                .filter(i -> i.getColor().equals(color))
                .collect(Collectors.toList());
        return result;
    }

}
