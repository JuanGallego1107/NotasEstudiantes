package org.example.mapper.dtos;

import org.example.domain.models.Student;
import org.example.domain.models.Subject;

public record GradesDto(
        Long gradesId,
        Student student,
        Subject subject,
        double grade,
        String corte) {
}
