package model;

import java.time.LocalDate;

public class Student extends Person {
   private String studentCode;
   private String school;
   private int year;
   private Double gpa;
   private Rank rank;

    public Student(int id, String name, LocalDate dateOfBirth, String address, Double height, Double weight, String studentCode, String school, int year, Double gpa) {
        super(id, name, dateOfBirth, address, height, weight);
        this.studentCode = studentCode;
        this.school = school;
        this.year = year;
        this.gpa = gpa;
        this.rank = Rank.calculateRank(gpa);
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
        this.rank = Rank.calculateRank(gpa);
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() + "\n" +
                "MSV : " + studentCode +
                ", trường : " + school +
                ", năm nhập học : " + year +
                ", gpa : " + (gpa != null && gpa != 0.0 ? gpa : "Không có") + ", học lực: " + rank.toVietnamese() +
                '}';
    }
}
