package code.run;
import code.data.AttendanceDAO;
import code.data.GradeDAO;
import code.data.StudentDAO;
import code.models.Attendance;
import code.models.Grade;
import code.models.Student;
import code.utils.ConnectDB;

import java.util.List;
import java.util.Scanner;

public class CommandLine {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDAO studentDAO = new StudentDAO();
    private static final GradeDAO gradeDAO = new GradeDAO();
    private static final AttendanceDAO attendanceDAO = new AttendanceDAO();

    public static void main(String[] args) {
        ConnectDB.createTables();
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Grades");
            System.out.println("3. Manage Attendance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageStudents();
                    break;
                case 2:
                    manageGrades();
                    break;
                case 3:
                    manageAttendance();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageStudents() {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. View All Students");
            System.out.println("2. Add Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Back");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<Student> students = studentDAO.getAllStudents();
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;
                case 2:
                    System.out.println("Enter student name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter student email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter student phone:");
                    String phone = scanner.nextLine();
                    studentDAO.addStudent(new Student(0, name, email, phone));
                    System.out.println("Student added successfully.");
                    break;
                case 3:
                    System.out.println("Enter student id to update:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new name:");
                    name = scanner.nextLine();
                    System.out.println("Enter new email:");
                    email = scanner.nextLine();
                    System.out.println("Enter new phone:");
                    phone = scanner.nextLine();
                    studentDAO.updateStudent(new Student(id, name, email, phone));
                    System.out.println("Student updated successfully.");
                    break;
                case 4:
                    System.out.println("Enter student id to delete:");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    studentDAO.deleteStudent(id);
                    System.out.println("Student deleted successfully.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageGrades() {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. View All Grades");
            System.out.println("2. Add Grade");
            System.out.println("3. Update Grade");
            System.out.println("4. Delete Grade");
            System.out.println("5. Back");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<Grade> grades = gradeDAO.getAllGrades();
                    for (Grade grade : grades) {
                        System.out.println(grade);
                    }
                    break;
                case 2:
                    System.out.println("Enter student id:");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter subject:");
                    String subject = scanner.nextLine();
                    System.out.println("Enter score:");
                    double score = scanner.nextDouble();
                    gradeDAO.addGrade(new Grade(0, studentId, subject, score));
                    System.out.println("Grade added successfully.");
                    break;
                case 3:
                    System.out.println("Enter grade id to update:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new student id:");
                    studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new subject:");
                    subject = scanner.nextLine();
                    System.out.println("Enter new score:");
                    score = scanner.nextDouble();
                    gradeDAO.updateGrade(new Grade(id, studentId, subject, score));
                    System.out.println("Grade updated successfully.");
                    break;
                case 4:
                    System.out.println("Enter grade id to delete:");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    gradeDAO.deleteGrade(id);
                    System.out.println("Grade deleted successfully.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageAttendance() {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. View All Attendance Records");
            System.out.println("2. Add Attendance Record");
            System.out.println("3. Update Attendance Record");
            System.out.println("4. Delete Attendance Record");
            System.out.println("5. Back");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<Attendance> attendances = attendanceDAO.getAllAttendances();
                    for (Attendance attendance : attendances) {
                        System.out.println(attendance);
                    }
                    break;
                case 2:
                    System.out.println("Enter student id:");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter date (YYYY-MM-DD):");
                    String date = scanner.nextLine();
                    System.out.println("Is student present? (true/false):");
                    boolean present = scanner.nextBoolean();
                    attendanceDAO.addAttendance(new Attendance(0, studentId, date, present));
                    System.out.println("Attendance record added successfully.");
                    break;
                case 3:
                    System.out.println("Enter attendance record id to update:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new student id:");
                    studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new date (YYYY-MM-DD):");
                    date = scanner.nextLine();
                    System.out.println("Is student present? (true/false):");
                    present = scanner.nextBoolean();
                    attendanceDAO.updateAttendance(new Attendance(id, studentId, date, present));
                    System.out.println("Attendance record updated successfully.");
                    break;
                case 4:
                    System.out.println("Enter attendance record id to delete:");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    attendanceDAO.deleteAttendance(id);
                    System.out.println("Attendance record deleted successfully.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
