package Static;

import model.StaticArray;

public class SearchStudent {
    public static int search(String s){
        for(int i = 0; i< StaticArray.students.length; i++){
            if(StaticArray.students[i]!= null && StaticArray.students[i].getStudentCode().equals(s)){
                return i;
            }
        }
        return -1;
    }
}
