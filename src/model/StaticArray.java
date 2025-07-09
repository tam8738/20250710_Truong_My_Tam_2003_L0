package model;
import java.io.IOException;
import java.io.PrintWriter;

public class StaticArray {
    // Mảng tĩnh lưu trữ sinh viên
    public static Student[] students = new Student[100];
    public static int studentCount = 0;
    public static void saveToFile() {
        if (studentCount == 0) {
            System.out.println("Không có sinh viên để lưu!");
            return;
        }
        try{
            PrintWriter writer = new PrintWriter("students.txt", "UTF-8");
            System.out.println("Số lượng sinh viên: " + studentCount);
            for (int i = 0; i < studentCount; i++) {
                System.out.println(students[i]);
                writer.println(students[i]);
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
