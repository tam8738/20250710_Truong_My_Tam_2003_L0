package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    static int tmpId = 1;
   private int id;
   private String name;
   private LocalDate dateOfBirth;
   private String address;
   private double height;
   private double weight;
    public Person(String name, LocalDate dateOfBirth, String address, double height, double weight) {
        this.id = tmpId++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedBirthday = (dateOfBirth != null) ? dateOfBirth.format(formatter) : "Không có";
        return
                "id : " + id +
                ", tên : " + name +
                ", sinh nhật : " + formattedBirthday +
                ", địa chỉ : " + (address != null && !address.isEmpty() ? address : "Không có") +
                ", chiều cao : " + (height != 0.0 ? height + " cm" : "Không có")+
                ", cân nặng : " + (weight != 0.0 ? weight + " kg" : "Không có")
                ;
    }
}
