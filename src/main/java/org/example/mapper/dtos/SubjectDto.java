package org.example.mapper.dtos;

import org.example.domain.enums.Semester;
import org.example.domain.models.Grades;
import org.example.domain.models.Student;
import org.example.domain.models.Teacher;

import java.util.List;

public record SubjectDto (
        Long subjectId,
        String subjectName,
        Semester semester,
        Teacher teacher,
        Grades grades,
        List<Student> students){
}
