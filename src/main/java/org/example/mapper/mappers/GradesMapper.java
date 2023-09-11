package org.example.mapper.mappers;

import org.example.domain.models.Grades;
import org.example.mapper.dtos.GradesDto;

import java.util.List;

public class GradesMapper {
    public static GradesDto mapFrom(Grades source) {
        return new GradesDto(source.getId(),
                source.getGrade1(),
                source.getGrade2(),
                source.getGrade3());
    }

    public static Grades mapFrom(GradesDto source){
        return new Grades(source.gradesId(),
                source.grade1(),
                source.grade2(),
                source.grade3());
    }

    public static List<GradesDto> mapFrom(List<Grades> sources){
        return sources.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
