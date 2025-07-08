package Static;

import model.StaticArray;

public class View {
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
    //xem danh sách theo học lực
    //xem % học lực
    //%điểm trung bình
}
