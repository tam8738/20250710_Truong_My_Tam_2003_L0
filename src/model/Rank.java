package model;

public enum Rank {
    Poor("kem",0.0,3.0),   // GPA < 3
    Weak("yeu",3.0,5.0),   // 3 <= GPA < 5
    Average("trung binh", 5.0, 6.5),  // 5 <= GPA < 6.5
    Good("kha",6.5,7.5),   // 6.5 <= GPA < 7.5
    VeryGood("gioi",7.5,9.0),   // 7.5 <= GPA < 9
    Excellent("xuat xac",9.0,10.1); // 9 <= GPA (tới 10, dùng 10.1 để bao phủ 10.0)

    private final String vietnamese;
    private final double minInclusive;
    private final double maxExclusive;

    Rank(String vietnamese, double minInclusive, double maxExclusive) {
        this.vietnamese = vietnamese;
        this.minInclusive = minInclusive;
        this.maxExclusive = maxExclusive;
    }

    public String getVietnamese() {
        return vietnamese;
    }

    public double getMinInclusive() {
        return minInclusive;
    }

    public double getMaxExclusive() {
        return maxExclusive;
    }

    
    public static Rank calculateRank(Double gpa) {
        if (gpa == null) return null;
        if (gpa.isNaN()) return null;                
        if (gpa < 0.0 || gpa > 10.0) return null;

        for (Rank r : Rank.values()) {
            if (gpa >= r.minInclusive && gpa < r.maxExclusive) {
                return r;
            }
        }
        return null; 
    }

}

