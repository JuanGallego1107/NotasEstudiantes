package org.example.mapper.mappers;

import org.example.domain.models.Student;
import org.example.domain.models.Teacher;
import org.example.mapper.dtos.StudentDto;
import org.example.mapper.dtos.TeacherDto;

import java.util.List;

public class TeacherMapper {
    public static TeacherDto mapFrom(Teacher source){
    return new TeacherDto(source.getId(),
            source.getName(),
            source.getEmail());
}
    public static Teacher mapFrom(TeacherDto source){
        return new Teacher(source.teacherId(),
                source.teacherName(),
                source.teacherEmail());
    }
    public static List<TeacherDto> mapFrom(List<Teacher> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }

}
