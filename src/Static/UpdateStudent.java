package Static;

import model.StaticArray;
import model.Student;

import java.util.Scanner;

public class UpdateStudent {
    public static boolean update(String s) {
        Scanner sc = new Scanner(System.in);
        int i = SearchStudent.search(s);
        if (i == -1) {
            System.out.println("mã sinh viên không tồn tại");
            return false;
        }
        Student stu = StaticArray.students[i];
        while (true) {
            System.out.println(stu);
            menu();
            int choice = readInt(sc);
            switch (choice) {
                case 1:
                    stu.setName(DataEntry.inputName(sc));
                    System.out.println("sửa tên thành công");
                    break;
                case 2:
                    stu.setDateOfBirth(DataEntry.inputBirthday(sc));
                    System.out.println(("sửa ngày sinh thành công"));
                    break;
                case 3:
                    stu.setAddress(DataEntry.inputAddress(sc));
                    System.out.println("Sửa địa chỉ thành công");
                    break;
                case 4:
                    stu.setHeight(DataEntry.inputHeight(sc));
                    System.out.println("sửa chiều cao thành công");
                    break;
                case 5:
                    stu.setWeight(DataEntry.inputWeight(sc));
                    System.out.println("Sửa cân nặng thành công");
                    break;
                case 6:
                    stu.setStudentCode(DataEntry.inputStudentCode(sc));
                    System.out.println("sửa mã sinh viên thành công");
                    break;
                case 7:
                    stu.setSchool(DataEntry.inputSchool(sc));
                    System.out.println("sửa tên trường thành công");
                    break;
                case 8:
                    stu.setYear(DataEntry.inputYear(sc));
                    System.out.println("sửa năm nhập học thành công");
                    break;
                case 9:
                    stu.setGpa(DataEntry.inputGpa(sc));
                    System.out.println("sửa gpa thành công");
                    break;
            }
            System.out.println("Bạn muốn làm gì tiếp theo?");
            System.out.println("1: Tiếp tục sửa sinh viên này");
            System.out.println("2: Sửa thông tin cho sinh viên khác");
            System.out.println("0: Quay lại menu chức năng");
            int again = readInt(sc);
            if (again == 1) {
                continue;
            } else if (again == 2) {
                return true;
            } else {
                return false;
            }
        }
    }
    private static void menu() {
        System.out.println("Bạn muốn sửa ?");
        System.out.println("1: sửa tên");
        System.out.println("2: sửa ngày sinh");
        System.out.println("3: sửa địa chỉ");
        System.out.println("4: sửa chiều cao");
        System.out.println("5: sửa cân nặng");
        System.out.println("6: sửa mã sinh viên");
        System.out.println("7: sửa tên trường học");
        System.out.println("8: sửa năm nhập học");
        System.out.println("9: sửa gpa");
    }
    private static int readInt(Scanner sc) {
        while (true) {
            System.out.println("chọn chức năng");
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                sc.nextLine();
                return number;
            }
            System.out.println("Vui lòng nhập số nguyên!");
            sc.nextLine();
        }
    }
}
