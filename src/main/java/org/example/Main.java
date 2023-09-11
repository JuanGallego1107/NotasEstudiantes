package org.example;

import org.example.conexion.ConexionBD;
import org.example.domain.models.Student;
import org.example.mapper.dtos.StudentDto;
import org.example.repository.Impl.StudentRepositoryImpl;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try(Connection conn = ConexionBD.getInstance()){
            StudentRepositoryImpl repository = new StudentRepositoryImpl();

            //System.out.println(repository.studentList());
            System.out.println(repository.byId(5L));
            //repository.delete(2L);
            repository.update(new StudentDto(1L, "Ana Zuluaga", "anazul683@cue.edu.co", "Derecho"));

        }catch (SQLException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/grades";
        String user = "root";
        String password = "";
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
    }
}