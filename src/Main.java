import Static.*;
import model.StaticArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            showMenu();
            choice = readInt(sc);
            switch (choice) {
                case 1:
                    while (true) {
                        AddStudent.add();
                        System.out.println("Bạn có muốn tiếp tục thêm sinh viên không? (1: Tiếp tục, 0: Quay lại menu)");
                        int again = readInt(sc);
                        if (again != 1) break;
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("nhập mã sinh viên cần xóa: ");
                        String s = DataEntry.inputStudentCode2(sc);
                        DeleteStudent.delete(s);
                        System.out.println("Bạn có muốn tiếp tục xóa sinh viên không? (1: Tiếp tục, 0: Quay lại menu)");
                        int again = readInt(sc);
                        if (again != 1) break;
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("Nhập mã sinh viên cần sửa: ");
                        String s = DataEntry.inputStudentCode2(sc);
                        boolean again = UpdateStudent.update(s);
                        if (!again) break;
                    }
                    break;
                case 4:
                    while (true) {
                        System.out.println("Nhập mã sinh viên cần tìm: ");
                        String s = DataEntry.inputStudentCode2(sc);
                        View.viewStudentCode(s);
                        System.out.println("Bạn muốn tiếp tục tìm sinh viên không? (1: Tiếp tục, 0: quay lại menu)");
                        int again = readInt(sc);
                        if (again != 1) break;
                    }
                    break;
                case 5:
                    View.menu();
                    break;
            }
        }while(choice != 0);
        StaticArray.saveToFile();
        System.out.println("lưu file thành công");
    }
    private static void showMenu() {
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Xóa sinh viên");
        System.out.println("3. Sửa thông tin sinh viên");
        System.out.println("4. Tìm kiếm sinh viên");
        System.out.println("5. Xem danh sách sinh viên");
        System.out.println("0. Thoát");
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
