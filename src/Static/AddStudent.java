package Static;
import model.Rank;
import model.Student;
import model.StaticArray;

import java.time.LocalDate;
import java.util.Scanner;

public class AddStudent {
    public static void add() {
        Scanner sc = new Scanner(System.in);

        LocalDate birthday = null;
        String name = null;
        int id = 0;
        String address = null;
        Double height = null;
        Double weight = null;
        String studentCode = null;
        String school = null;
        int year = 0;
        Double gpa = null;
        Rank rank = null;
        try {
            id = StaticArray.studentCount + 1;
            name = DataEntry.inputName(sc);
            birthday = DataEntry.inputBirthday(sc);
            address = DataEntry.inputAddress(sc);
            height = DataEntry.inputHeight(sc);
            weight = DataEntry.inputWeight(sc);
            studentCode = DataEntry.inputStudentCode(sc);
            school = DataEntry.inputSchool(sc);
            year = DataEntry.inputYear(sc);
            gpa = DataEntry.inputGpa(sc);

        } catch (Exception e) {
            System.out.println("Lỗi không mong muốn: " + e.getMessage());
        } // Không đóng sc để tránh lỗi nhập tiếp

        Student s = new Student(id, name, birthday, address, height, weight, studentCode, school, year, gpa);

        StaticArray.students[StaticArray.studentCount] = s;
        StaticArray.studentCount++;
        System.out.println("thêm thành công sinh viên");
        System.out.println(s);
        System.out.println();
    }

}
