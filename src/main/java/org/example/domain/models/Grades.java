package org.example.domain.models;

public class Grades {
    private Long id;
    private double grade1;
    private double grade2;
    private double grade3;

    public Grades(Long id, double grade1, double grade2, double grade3) {
        this.id = id;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getGrade1() {
        return grade1;
    }

    public void setGrade1(double grade1) {
        this.grade1 = grade1;
    }

    public double getGrade2() {
        return grade2;
    }

    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }

    public double getGrade3() {
        return grade3;
    }

    public void setGrade3(double grade3) {
        this.grade3 = grade3;
    }

    public double getAverageGrade() {
        return (grade1+grade2+grade3)/3;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", grade1=" + grade1 +
                ", grade2=" + grade2 +
                ", grade3=" + grade3 +
                '}';
    }
}
