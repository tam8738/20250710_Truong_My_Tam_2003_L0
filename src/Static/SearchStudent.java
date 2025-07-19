package Static;

import model.StaticArray;

public class SearchStudent {
    public static int search(int id) {
        for (int i = 0; i < StaticArray.studentCount; i++) {
            if (StaticArray.students[i] != null && StaticArray.students[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
} 