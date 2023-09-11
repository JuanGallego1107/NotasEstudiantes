package org.example.repository.Impl;

import org.example.conexion.ConexionBD;
import org.example.domain.models.Student;
import org.example.mapper.dtos.StudentDto;
import org.example.repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
    }
    private StudentDto createStudent(ResultSet rs) throws SQLException {
        StudentDto student = new StudentDto(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("degree"),
                rs.getString("email"));
        return student;
    }
    @Override
    public List<StudentDto> studentList() {
        List<StudentDto> studentList = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from students")) {
            while (resultSet.next()) {
                StudentDto student = createStudent(resultSet);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public StudentDto byId(Long id) {
        StudentDto student = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM students WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = createStudent(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void update(StudentDto student) {
        String sql;
        if (student.studentId() != null && student.studentId()>0) {
            sql = "UPDATE students SET name=?, degree=?, email=? WHERE id=?";
        } else {
            sql = "INSERT INTO students (name, degree, email) VALUES(?,?,?,?)";
        }
        try(PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, student.studentName());
            stmt.setString(2, student.degree());

            if (student.studentId() != null && student.studentId() > 0) {
                stmt.setString(3, student.studentEmail());
                stmt.setLong(4, student.studentId());
            } else{
                stmt.setString(3, student.studentEmail());
            }
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM students WHERE id =?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
