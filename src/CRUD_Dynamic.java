import model.DynamicArray;
import model.Rank;
import model.Student;
import java.time.LocalDate;
import java.util.*;

public class CRUD_Dynamic {
    public static DynamicArray dynamicArray = new DynamicArray();

    public static void addStudent() {
        Scanner sc = new Scanner(System.in);
        LocalDate birthday = null;
        String name = null;
        String address = null;
        double height = 0;
        double weight = 0;
        String studentCode = null;
        String school = null;
        int year = 0;
        Double gpa = null;
        try {
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
        dynamicArray.add(s);
        System.out.println("thêm thành công sinh viên");
        System.out.println(s);
        System.out.println();
    }

    public static int searchById(int id) {
        for (int i = 0; i < dynamicArray.size(); i++) {
            if(dynamicArray.get(i).getId() == id) return i;
        }
        return -1;
    }

    public static void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập id sinh viên cần xóa");
        int id = sc.nextInt();
        int index = searchById(id);
        if(index != -1) {
            dynamicArray.remove(index);
            System.out.println("Xóa thành công");
        }
        else {
            System.out.println("Id không tồn tại");
        }
    }

    public static void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id sinh viên cần sửa:");
        int id = sc.nextInt();
        sc.nextLine();
        int index = searchById(id);
        if (index != -1) {
            Student s = dynamicArray.get(index);
            System.out.println(s);
            s.setName(DataEntry.inputName(sc));
            s.setDateOfBirth(DataEntry.inputBirthday(sc));
            s.setAddress(DataEntry.inputAddress(sc));
            s.setHeight(DataEntry.inputHeight(sc));
            s.setWeight(DataEntry.inputWeight(sc));
            s.setStudentCode(DataEntry.inputStudentCode(sc, s.getStudentCode()));
            s.setSchool(DataEntry.inputSchool(sc));
            s.setYear(DataEntry.inputYear(sc));
            s.setGpa(DataEntry.inputGpa(sc));
            System.out.println("Sửa thông tin sinh viên thành công!");
            System.out.println(s);
        } else {
            System.out.println("Id không tồn tại");
        }
    }

    public static void viewALL() {
        if(dynamicArray.isEmpty()) {
            System.out.println("không có sinh viên nào");
        }
        else {
            for (int i = 0; i < dynamicArray.size(); i++) {
                System.out.println(dynamicArray.get(i));
            }
        }
    }

    public static void viewById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id sinh viên cần tìm: ");
        int id = sc.nextInt();
        int index = searchById(id);
        if(index == -1) {
            System.out.println("ID không tồn tại.");
        }
        else {
            System.out.println(dynamicArray.get(index));
        }
    }

    public static void viewByRank() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập học lực muốn xem (yeu, kem, trung binh, kha, gioi, xuat sac): ");
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
        for (int i = 0; i < dynamicArray.size(); i++) {
            if (dynamicArray.get(i).getRank() == selectedRank) {
                System.out.println(dynamicArray.get(i));
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
        for (int i = 0; i < dynamicArray.size(); i++) {
            Student s = dynamicArray.get(i);
            if (s != null && s.getRank() != null) {
                rankCount.put(s.getRank(), rankCount.get(s.getRank()) + 1);
            }
        }
        List<Map.Entry<Rank, Integer>> list = new ArrayList<>(rankCount.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for (Map.Entry<Rank, Integer> e : list) {
            double percent = !dynamicArray.isEmpty() ? (e.getValue() * 100.0 / dynamicArray.size()) : 0;
            System.out.println(e.getKey().getVietnamese() + ": " + percent + "%");
        }
    }

    public static void viewGpaPercent() {
        if (dynamicArray.isEmpty()) {
            System.out.println("Không có sinh viên nào!");
            return;
        }
        Map<Double, Integer> gpaCount = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < dynamicArray.size(); i++) {
            Student s = dynamicArray.get(i);
            if (s != null && s.getGpa() != null) {
                double roundedGpa = Math.round(s.getGpa() * 10.0) / 10.0;
                gpaCount.put(roundedGpa, gpaCount.getOrDefault(roundedGpa, 0) + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : gpaCount.entrySet()) {
            double percent = entry.getValue() * 100.0 / dynamicArray.size();
            System.out.printf("GPA: %.1f - %.2f%% \n", entry.getKey(), percent);
        }
    }
}
