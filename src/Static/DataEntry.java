package Static;

import model.Constant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DataEntry {
    //nhập tên
    public static String inputName(Scanner sc){
        while (true) {
            System.out.print("Nhập tên: ");
            try {
                String name = sc.nextLine();
                if (name == null || name.trim().isEmpty())
                    throw new IllegalArgumentException("Không được bỏ trống tên.");
                if (name.length() >= Constant.NAME_LENGTH) throw new IllegalArgumentException("Tên phải dưới 100 ký tự");
                return name;
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
    //sinh nhật
    public static LocalDate inputBirthday(Scanner sc) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Nhập ngày sinh (dd/mm/yyyy): ");
            try {
                String dateStr = sc.nextLine();
                if (dateStr == null || dateStr.trim().isEmpty())
                    throw new IllegalArgumentException("không được bỏ trống ngày sinh.");
                LocalDate birthday = LocalDate.parse(dateStr, formatter);
                if (birthday.getYear() < Constant.MIN_START_YEAR) throw new IllegalArgumentException("Năm sinh phải từ 1900 trở đi");
                return birthday;
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày sai! Vui lòng nhập lại (vd: 18/07/2003");
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
    //điạ chỉ
    public static String inputAddress(Scanner sc) {
        while (true) {
            System.out.print("Nhập địa chỉ (không bắt buộc): ");
            try {
                String address = sc.nextLine();
                if (address.length() >= Constant.ADRESS_LENGTH) throw new IllegalArgumentException("địa chỉ không quá 300 ký tự.");
                return address;
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
    //chiều cao
    public static Double inputHeight(Scanner sc) {
        while (true) {
            System.out.print("(không bắt buộc) Nhâp chiều cao cm: ");
            try {
                String height_1 = sc.nextLine().replace(",", ".");
                if (height_1.trim().isEmpty()) {
                    return 0.0;
                }
                double height = Double.parseDouble(height_1);
                if (height < Constant.MIN_HEIGHT || height > Constant.MAX_HEIGHT) {
                    throw new IllegalArgumentException("Chiều cao phải từ 50.0 đến 300.0 cm!");
                }
                return height;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Dữ liệu chiều cao không hợp lệ.");
            } catch (Exception e) {
                System.out.println("lỗi: " + e.getMessage());
            }
        }
    }
    //cân nặng
    public static Double inputWeight(Scanner sc) {
        while (true) {
            System.out.print("(không bắt buộc) Nhập cân nặng (kg, 5.0 - 1000.0, vd: 65.0): ");
            try {
                String weightInput = sc.nextLine().replace(",", ".");
                if(weightInput.trim().isEmpty()) return 0.0;
                double weight = Double.parseDouble(weightInput);
                if (weight < Constant.MIN_WEIGHT || weight > Constant.MAX_WEIGHT) {
                    throw new IllegalArgumentException("Cân nặng phải từ 5.0 đến 1000.0 kg!");
                }
                return weight;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Dữ liệu cân nặng không hợp lệ! Vui lòng nhập lại.");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
    //MSV
    private static Set<String> studentCodes = new HashSet<>();
    public static String inputStudentCode(Scanner sc) {
        while (true) {
            System.out.print("Nhập mã SV (10 ký tự, không trùng): ");
            try {
                String studentCode = sc.nextLine();
                if(studentCode == null ) throw new IllegalArgumentException("không được trống msv.");
                if ( studentCode.length() != Constant.STUDENT_CODE_LENGTH) {
                    throw new IllegalArgumentException("Mã sinh viên phải có đúng 10 ký tự!");
                }
                if (!studentCodes.add(studentCode)) {
                    throw new IllegalArgumentException("Mã sinh viên đã tồn tại!");
                }
                return studentCode;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
    public static String inputStudentCode2(Scanner sc) {
        while (true) {
            System.out.print("Nhập mã SV: ");
            try {
                String studentCode = sc.nextLine();
                if(studentCode == null ) throw new IllegalArgumentException("không được trống msv.");
                if ( studentCode.length() != Constant.STUDENT_CODE_LENGTH) {
                    throw new IllegalArgumentException("Mã sinh viên phải có đúng 10 ký tự!");
                }
                return studentCode;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
    //trường
    public static String inputSchool(Scanner sc) {
        while (true) {
            System.out.print("Nhập trường (< 200 ký tự, không rỗng): ");
            try {
                String school = sc.nextLine();
                if (school == null || school.trim().isEmpty()) {
                    throw new IllegalArgumentException("Tên trường không được rỗng!");
                }
                if (school.length() >= Constant.SCHOOL_LENGTH) {
                    throw new IllegalArgumentException("Tên trường phải dưới 200 ký tự!");
                }
                return school;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
    //năm nhập học
    public static int inputYear(Scanner sc) {
        while (true) {
            System.out.print("Nhập năm nhập học (4 chữ số, từ 1900): ");
            try {
                String yearInput = sc.nextLine();
                int year = Integer.parseInt(yearInput);
                if (year < Constant.MIN_START_YEAR || year > Constant.MAX_START_YEAR) {
                    throw new IllegalArgumentException("Năm nhập học phải là số 4 chữ số từ 1900!");
                }
                return year;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Năm nhập học không hợp lệ! Vui lòng nhập lại.");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
    //gpa
    public static Double inputGpa(Scanner sc) {
        while (true) {
            System.out.print("Nhập GPA (0.0 - 10.0, vd: 8.5): ");
            try {
                String gpaInput = sc.nextLine().replace(",", ".");
                if(gpaInput.trim().isEmpty()) return 0.0;
                double gpa = Double.parseDouble(gpaInput);
                if (gpa < Constant.MIN_GPA || gpa > Constant.MAX_GPA) {
                    throw new IllegalArgumentException("GPA phải từ 0.0 đến 10.0!");
                }
                return gpa;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: GPA không hợp lệ! Vui lòng nhập lại.");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }

}
