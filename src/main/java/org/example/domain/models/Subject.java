package org.example.domain.models;

import org.example.domain.enums.Semester;

import java.util.List;

public class Subject {
    private Long id;
    private String name;
    private Semester semester;
    private Teacher teachers;
    private List<Student> students;
    private Grades grades;

    public Subject(Long id, String name, Semester semester, Teacher teachers, List<Student> students, Grades grades) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.teachers = teachers;
        this.students = students;
        this.grades = grades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Teacher getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", semester=" + semester +
                ", teachers=" + teachers +
                ", students=" + students +
                ", grades=" + grades +
                '}';
    }
}
