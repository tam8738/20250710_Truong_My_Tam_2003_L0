package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DynamicArray {
    private ArrayList<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    public Student get(int index) {
        return students.get(index);
    }

    public void remove(int index) {
        students.remove(index);
    }

    public int size() {
        return students.size();
    }

    public void clear() {
        students.clear();
    }

    public ArrayList<Student> getAll() {
        return students;
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }

    public void saveToFile() {
        if (isEmpty()) {
            System.out.println("Không có sinh viên để lưu!");
            return;
        }
        try{
            PrintWriter writer = new PrintWriter("students_2.txt", "UTF-8");
            System.out.println("Số lượng sinh viên: " + size());
            for (int i = 0; i < size(); i++) {
                System.out.println(get(i));
                writer.println(get(i));
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
