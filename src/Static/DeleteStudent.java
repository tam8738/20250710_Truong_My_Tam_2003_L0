package Static;

import model.StaticArray;

public class DeleteStudent {
    public static void delete(String s){
        int index = SearchStudent.search(s);
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
}
