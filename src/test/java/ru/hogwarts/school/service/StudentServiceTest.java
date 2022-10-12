package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    StudentService out = new StudentService();

    @Test
    void createStudent() {
        Student student1 = new Student(0L, "test", 99);
        out.createStudent(student1);
        assertEquals(out.getStudent(1), student1);
    }

    @Test
    void getStudent() {
        Student student1 = new Student(0L, "test1", 1);
        Student student2 = new Student(4L, "test2", 34);
        Student student3 = new Student(9L, "test3", 7);
        out.createStudent(student1);
        out.createStudent(student2);
        out.createStudent(student3);
        assertEquals(out.getStudent(2), student2);
    }

    @Test
    void getStudentShouldReturnNull() {
        Student student1 = new Student(0L, "test1", 1);
        out.createStudent(student1);
        assertThat(out.getStudent(7)).isNull();
    }

    @Test
    void updateStudent() {
        Student student1 = new Student(22L, "test1", 1);
        out.createStudent(student1);
        assertThat(out.getStudent(1)).isEqualTo(student1);
        Student student2 = new Student(4L, "test2", 34);
        out.updateStudent(1, student2);
        assertThat(out.getStudent(1)).isEqualTo(student2);
    }

    @Test
    void deleteStudent() {
        Student student1 = new Student(0L, "test1", 1);
        Student student2 = new Student(4L, "test2", 34);
        Student student3 = new Student(9L, "test3", 7);
        out.createStudent(student1);
        out.createStudent(student2);
        out.createStudent(student3);
        out.deleteStudent(0);
        assertThat(out.getStudent(0)).isNull();
    }

    @Test
    void getStudentsByAge() {
        Student student1 = new Student(0L, "test1", 1);
        Student student2 = new Student(4L, "test2", 34);
        Student student3 = new Student(9L, "test3", 1);
        out.createStudent(student1);
        out.createStudent(student2);
        out.createStudent(student3);
        System.out.println(out.getStudentsByAge(1));
        assertThat(out.getStudentsByAge(1)).containsOnly(student1, student3);
    }
}