package model;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StaticArray {
    // Mảng tĩnh lưu trữ sinh viên
    public static Student[] students = new Student[100];
    public static int studentCount = 0;
    
    public static void saveToFile() {
        if (studentCount == 0) {
            System.out.println("Không có sinh viên để lưu!");
            return;
        }
        
        // Chuyển đổi mảng sinh viên thành List<String> để sử dụng FileUtils
        List<String> studentList = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            studentList.add(students[i].toString());
        }
        
        // Sử dụng try-with-resources để tự động đóng file
        try (PrintWriter writer = new PrintWriter("students.txt", "UTF-8")) {
            System.out.println("Số lượng sinh viên: " + studentCount);
            for (int i = 0; i < studentCount; i++) {
                System.out.println(students[i]);
                writer.println(students[i]);
            }
            System.out.println("Lưu file thành công!");
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
