package Static;

import model.Rank;
import model.StaticArray;
import model.Student;

import java.util.*;

public class View {
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1: Xem toàn bộ danh sách sinh viên");
            System.out.println("2: Xem % học lực sinh viên");
            System.out.println("3: Xem % điểm số sinh viên ");
            System.out.println("4: xem danh sách sinh viên theo học lực");
            System.out.println("5: thoát");
            choice = readInt(sc);
            switch (choice) {
                case 1:
                    viewAll();
                    break;
                case 2:
                    viewStudentRank();
                    break;
                case 3:
                    percentGPA();
                    break;
                case 4:
                    searchRank();
                    break;
                case 5:
                    break;
            }
        }
        while (choice != 5);
    }
    public static void viewAll() {
        if(StaticArray.studentCount == 0){
            System.out.println("không có sinh viên nào cả!!! hẹ hẹ");
        }
        for(int i = 0; i < StaticArray.studentCount; i++) {
            System.out.println(StaticArray.students[i]);
        }
    }
    public static void viewStudentCode(String s) {
        if(SearchStudent.search(s) != -1) {
            System.out.println(StaticArray.students[SearchStudent.search(s)]);
        }
        else {
            System.out.println("mã sinh viên không tồn tại");
        }
    }
    //xem % học lực
    public static void viewStudentRank() {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Rank r : Rank.values()) rankCount.put(r, 0);
        for (int i = 0; i < StaticArray.studentCount; i++) {
            Student s = StaticArray.students[i];
            if (s != null && s.getRank() != null) {
                rankCount.put(s.getRank(), rankCount.get(s.getRank()) + 1);
            }
        }
        List<Map.Entry<Rank, Integer>> list = new ArrayList<>(rankCount.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        for (Map.Entry<Rank, Integer> e : list) {
            double percent = StaticArray.studentCount > 0 ? (e.getValue() * 100.0 / StaticArray.studentCount) : 0;
            switch (e.getKey()) {
                case Poor:
                    System.out.println("Kém: " + percent + "%");
                    break;
                case Good:
                    System.out.println("Khá: " + percent + "%");
                    break;
                case Weak:
                    System.out.println("Yếu: " + percent + "%");
                    break;
                case Average:
                    System.out.println("Trung bình: " + percent + "%");
                    break;
                case VeryGood:
                    System.out.println("Giỏi: " + percent + "%");
                    break;
                case Excellent:
                    System.out.println("Xuất sắc: " + percent + "%");
                    break;
            }
        }
    }

    //%điểm trung bình
    public static void percentGPA() {
        if (StaticArray.studentCount == 0) {
            System.out.println("Không có sinh viên nào!");
            return;
        }
        Map<Double, Integer> gpaCount = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < StaticArray.studentCount; i++) {
            Student s = StaticArray.students[i];
            if (s != null && s.getGpa() != null) {
                double roundedGpa = Math.round(s.getGpa() * 10.0) / 10.0;
                gpaCount.put(roundedGpa, gpaCount.getOrDefault(roundedGpa, 0) + 1);
            }
            //getOrDefault: trả về value gắn với key rounderGpa nếu key đã tồn tại, nếu chưa có trả về 0.
        }
        for (Map.Entry<Double, Integer> entry : gpaCount.entrySet()) {
            double percent = entry.getValue() * 100.0 / StaticArray.studentCount;
            System.out.printf("GPA: %.1f - %.2f%% \n", entry.getKey(), percent);
        }
    }
    //xem sinh viên theo học lực nhập từ bàn phím.
    public static void searchRank(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập học lực muốn xem (yếu, kém, trug bình, khá, giỏi, xuất sắc): ");
        String rankInput = sc.nextLine().trim().toLowerCase();
        switch (rankInput) {
            case "kém":
                for (int i = 0; i < StaticArray.studentCount; i++) {
                    if(StaticArray.students[i].getRank().equals(Rank.Poor)){
                        System.out.println(StaticArray.students[i]);
                    }                }
                break;
            case "yếu":
                for (int i = 0; i < StaticArray.studentCount; i++) {
                    if(StaticArray.students[i].getRank().equals(Rank.Weak)){
                        System.out.println(StaticArray.students[i]);
                    }                }
                break;
            case "trung bình":
                for (int i = 0; i < StaticArray.studentCount; i++) {
                    if(StaticArray.students[i].getRank().equals(Rank.Average)){
                        System.out.println(StaticArray.students[i]);
                    }                }
            case "khá":
                for (int i = 0; i < StaticArray.studentCount; i++) {
                    if(StaticArray.students[i].getRank().equals(Rank.Good)){
                        System.out.println(StaticArray.students[i]);
                    }                }
                break;
            case "giỏi":
                for (int i = 0; i < StaticArray.studentCount; i++) {
                    if(StaticArray.students[i].getRank().equals(Rank.VeryGood)){
                        System.out.println(StaticArray.students[i]);
                    }
                }
                break;
            case "xuất sắc":
                for (int i = 0; i < StaticArray.studentCount; i++) {
                    if(StaticArray.students[i].getRank().equals(Rank.Excellent)){
                        System.out.println(StaticArray.students[i]);
                    }                }
                break;
        }
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
