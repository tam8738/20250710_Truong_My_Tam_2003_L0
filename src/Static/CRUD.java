package Static;

import model.StaticArray;
import model.Student;
import model.Rank;
import java.util.*;
import java.time.LocalDate;

public class CRUD {
    public static void addStudent() {
        Scanner sc = new Scanner(System.in);
        LocalDate birthday = null;
        String name = null;
        int id = 0;
        String address = null;
        double height = 0;
        double weight = 0;
        String studentCode = null;
        String school = null;
        int year = 0;
        Double gpa = null;
        try {
            id = StaticArray.studentCount + 1;
            name = DataEntry.inputName(sc);
            birthday = DataEntry.inputBirthday(sc);
            address = DataEntry.inputAddress(sc);
            height = DataEntry.inputHeight(sc);
            weight = DataEntry.inputWeight(sc);
            studentCode = DataEntry.inputStudentCode(sc, null);
            school = DataEntry.inputSchool(sc);
            year = DataEntry.inputYear(sc);
            gpa = DataEntry.inputGpa(sc);
        } catch (Exception e) {
            System.out.println("Lỗi không mong muốn: " + e.getMessage());
        }
        Student s = new Student(name, birthday, address, height, weight, studentCode, school, year, gpa);
        StaticArray.students[StaticArray.studentCount] = s;
        StaticArray.studentCount++;
        System.out.println("thêm thành công sinh viên");
        System.out.println(s);
        System.out.println();
    }

    public static boolean updateStudent(int s) {
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
                    stu.setStudentCode(DataEntry.inputStudentCode(sc, stu.getStudentCode()));
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

    public static void deleteStudent(int x) {
        int index = SearchStudent.search(x);
        if(index != -1){
            for(int i = index; i < StaticArray.studentCount - 1; i++){
                StaticArray.students[i] = StaticArray.students[i+1];
            }
            StaticArray.students[StaticArray.studentCount - 1] = null;
            StaticArray.studentCount--;
            System.out.println("xóa thành công");
        }
        else{
            System.out.println("mã sinh viên không tồn tại");
        }
    }

    public static void viewAll() {
        if(StaticArray.studentCount == 0){
            System.out.println("không có sinh viên nào cả!!!");
        }
        for(int i = 0; i < StaticArray.studentCount; i++) {
            System.out.println(StaticArray.students[i]);
        }
    }

    public static void viewByCode(int id) {
        int idx = SearchStudent.search(id);
        if(idx != -1) {
            System.out.println(StaticArray.students[idx]);
        } else {
            System.out.println("id sinh viên không tồn tại");
        }
    }

    public static void viewByRank() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập học lực muốn xem (yếu, kém, trung bình, khá, giỏi, xuất sắc): ");
        String rankInput = sc.nextLine().trim().toLowerCase();
        Rank selectedRank = null;
        for (Rank r : Rank.values()) {
            if (r.getVietnamese().toLowerCase().equals(rankInput)) {
                selectedRank = r;
                break;
            }
        }
        if (selectedRank == null) {
            System.out.println("Học lực không hợp lệ!");
            return;
        }
        boolean found = false;
        for (int i = 0; i < StaticArray.studentCount; i++) {
            if (StaticArray.students[i].getRank() == selectedRank) {
                System.out.println(StaticArray.students[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có sinh viên nào thuộc học lực này.");
        }
    }

    public static void viewRankPercent() {
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
            System.out.println(e.getKey().getVietnamese() + ": " + percent + "%");
        }
    }

    public static void viewGpaPercent() {
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
        }
        for (Map.Entry<Double, Integer> entry : gpaCount.entrySet()) {
            double percent = entry.getValue() * 100.0 / StaticArray.studentCount;
            System.out.printf("GPA: %.1f - %.2f%% \n", entry.getKey(), percent);
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