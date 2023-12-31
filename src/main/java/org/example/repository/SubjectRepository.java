package org.example.repository;

import org.example.mapper.dtos.StudentDto;
import org.example.mapper.dtos.SubjectDto;

import java.util.List;

public interface SubjectRepository {
    List<SubjectDto> subjectList();
    SubjectDto byId(Long id);
    void update(SubjectDto subject);

    void delete(Long id);
}
