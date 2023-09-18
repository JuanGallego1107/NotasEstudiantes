package org.example;

import org.example.conexion.ConexionBD;
import org.example.domain.models.Student;
import org.example.domain.models.Teacher;
import org.example.mapper.dtos.GradesDto;
import org.example.mapper.dtos.StudentDto;
import org.example.mapper.dtos.SubjectDto;
import org.example.mapper.dtos.TeacherDto;
import org.example.repository.Impl.GradesRepositoryImpl;
import org.example.repository.Impl.StudentRepositoryImpl;
import org.example.repository.Impl.SubjectRepositoryImpl;
import org.example.repository.Impl.TeacherRepositoryImpl;
import org.example.service.impl.GradesServiceImpl;
import org.example.service.impl.StudentServiceImpl;
import org.example.service.impl.SubjectServiceImpl;
import org.example.service.impl.TeacherServiceImpl;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try(Connection conn = ConexionBD.getInstance()){
            StudentServiceImpl studentService = new StudentServiceImpl();
            TeacherServiceImpl teacherService = new TeacherServiceImpl();
            SubjectServiceImpl subjectService = new SubjectServiceImpl();
            GradesServiceImpl gradesService = new GradesServiceImpl();

            System.out.println(studentService.studentList());
            System.out.println(studentService.byId(2L));
            studentService.update(new StudentDto(1L,"Daniela Morales","danMi@cue.edu.co","Enfermeria","IV"));
            //studentRepository.delete(1L);

            System.out.println(teacherService.teacherList());
            System.out.println(teacherService.byId(1L));
            teacherService.update(new TeacherDto(1L,"Carlos Arias","carAr13@cue.edu.co"));
            //teacherRepository.delete(2L);

            System.out.println(subjectService.subjectList());
            System.out.println(subjectService.byId(2L));
            subjectService.update(new SubjectDto(2L,"Ecuaciones diferenciales"));
            //subjectRepository.delete(1L);

            System.out.println(gradesService.gradesList());
            System.out.println(gradesService.byId(1L));
            gradesService.update(new GradesDto(1L,3.6,"3"));
            //gradesService.delete(1L);


        }catch (SQLException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3307/gradesbd";
        String user = "root";
        String password = "admin";
        try (Connection conn = DriverManager.getConnection(url, user,
                password);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        ) {
            while (resultSet.next()) {
                System.out.print(resultSet.getLong("id"));
                System.out.print("|");
                System.out.print(resultSet.getString("name"));
                System.out.print("|");
                System.out.print(resultSet.getString("degree"));
                System.out.print("|");
                System.out.print(resultSet.getString("email")+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (Connection conn = DriverManager.getConnection(url, user,
                password);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM grades");
        ) {
            while (resultSet.next()) {
                System.out.print(resultSet.getLong("id"));
                System.out.print("|");
                System.out.print(resultSet.getInt("student_id"));
                System.out.print("|");
                System.out.print(resultSet.getInt("subject_id"));
                System.out.print("|");
                System.out.print(resultSet.getDouble("grade"));
                System.out.print("|");
                System.out.print(resultSet.getString("corte")+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}