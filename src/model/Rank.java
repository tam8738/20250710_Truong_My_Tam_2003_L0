package model;

public enum Rank {
    Poor, Weak, Average, Good, VeryGood, Excellent;
    public static Rank calculateRank(Double gpa) {
        if (gpa == null) return null;
        if (gpa < 3) return Rank.Poor;
        else if (gpa < 5) return Rank.Weak;
        else if (gpa < 6.5) return Rank.Average;
        else if (gpa < 7.5) return Rank.Good;
        else if (gpa < 9) return Rank.VeryGood;
        else return Rank.Excellent;
    }

    public String toVietnamese() {
        switch (this) {
            case Poor: return "Kém";
            case Weak: return "Yếu";
            case Average: return "Trung bình";
            case Good: return "Khá";
            case VeryGood: return "Giỏi";
            case Excellent: return "Xuất sắc";
        }
        return "";
    }
}
