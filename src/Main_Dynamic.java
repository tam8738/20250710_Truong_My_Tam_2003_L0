import java.util.Scanner;

public class Main_Dynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = readInt(sc);
            switch (choice) {
                case 1:
                    CRUD_Dynamic.addStudent();
                    break;
                case 2:
                    CRUD_Dynamic.deleteStudent();
                    break;
                case 3:
                    CRUD_Dynamic.updateStudent();
                    break;
                case 4:
                    CRUD_Dynamic.viewALL();
                    break;
                case 5:
                    CRUD_Dynamic.viewById();
                    break;
                case 6:
                    CRUD_Dynamic.viewByRank();
                    break;
                case 7:
                    CRUD_Dynamic.viewRankPercent();
                    break;
                case 8:
                    CRUD_Dynamic.viewGpaPercent();
                    break;
            }
        } while (choice != 0);
        CRUD_Dynamic.dynamicArray.saveToFile();    }

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
            System.out.print("Chọn chức năng: ");
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