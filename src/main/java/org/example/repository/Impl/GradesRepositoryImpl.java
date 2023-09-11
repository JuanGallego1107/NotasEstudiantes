package org.example.repository.Impl;

import org.example.conexion.ConexionBD;
import org.example.domain.models.Grades;
import org.example.domain.models.Student;
import org.example.domain.models.Subject;
import org.example.mapper.dtos.GradesDto;
import org.example.mapper.dtos.StudentDto;
import org.example.mapper.mappers.GradesMapper;
import org.example.mapper.mappers.StudentMapper;
import org.example.repository.GradesRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradesRepositoryImpl implements GradesRepository {


    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
    }
    private Grades createGrades(ResultSet rs) throws SQLException {
        Grades grades = new Grades();
        grades.setId(rs.getLong("id"));

        Student student = new Student();
        student.setId(rs.getLong("student_id"));
        student.setName(rs.getString("student"));
        grades.setStudent(student);

        Subject subject = new Subject();
        subject.setId(rs.getLong("subject_id"));
        subject.setName(rs.getString("subject"));
        grades.setSubject(subject);

        grades.setGrade(rs.getDouble("grade"));
        grades.setCorte(rs.getString("corte"));

        return grades;
    }
    @Override
    public List<GradesDto> gradesList() {
        List<Grades> gradestList = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from grades")) {
            while (resultSet.next()) {
                Grades grades = createGrades(resultSet);
                gradestList.add(grades);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GradesMapper.mapFrom(gradestList);
    }

    @Override
    public GradesDto byId(Long id) {
            Grades grades = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM grades WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                grades = createGrades(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GradesMapper.mapFrom(grades);
    }

    @Override
    public void update(GradesDto grades) {

    }

    @Override
    public void delete(Long id) {

    }
}
