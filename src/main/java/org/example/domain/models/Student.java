package org.example.domain.models;

public class Student {
    private Long id;
    private String name;
    private String email;
    private String degree;

    public Student(Long id, String name, String email, String degree) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.degree = degree;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}
