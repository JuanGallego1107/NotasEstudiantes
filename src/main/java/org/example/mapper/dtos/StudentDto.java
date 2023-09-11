package org.example.mapper.dtos;

public record StudentDto(
        Long studentId,
        String studentName,
        String degree,
        String studentEmail) {
}
