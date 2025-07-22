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
                        CRUD_Static.addStudent();
                        System.out.println("Bạn có muốn tiếp tục thêm sinh viên không? (1: Tiếp tục, 0: Quay lại menu)");
                        int again = readInt(sc);
                        if (again != 1) break;
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("nhập id sinh viên cần xóa: ");
                        int id = readInt(sc);
                        CRUD_Static.deleteStudent(id);
                        System.out.println("Bạn có muốn tiếp tục xóa sinh viên không? (1: Tiếp tục, 0: Quay lại menu)");
                        int again = readInt(sc);
                        if (again != 1) break;
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("Nhập id sinh viên cần sửa: ");
                        int id = readInt(sc);
                        boolean again = CRUD_Static.updateStudent(id);
                        if (!again) break;
                    }
                    break;
                case 4:
                    CRUD_Static.viewAll();
                    break;
                case 5:
                    System.out.println("Nhập id sinh viên cần tìm: ");
                    int id = readInt(sc);
                    CRUD_Static.viewByCode(id);
                    break;
                case 6:
                    CRUD_Static.viewByRank();
                    break;
                case 7:
                    CRUD_Static.viewRankPercent();
                    break;
                case 8:
                    CRUD_Static.viewGpaPercent();
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
        System.out.println("4. Xem danh sách sinh viên");
        System.out.println("5. Tìm kiếm sinh viên theo id");
        System.out.println("6. Xem danh sách sinh viên theo học lực");
        System.out.println("7. Xem % học lực sinh viên");
        System.out.println("8. Xem % điểm số sinh viên");
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
