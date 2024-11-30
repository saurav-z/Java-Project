package code.run;

import code.data.AttendanceDAO;
import code.data.GradeDAO;
import code.data.StudentDAO;
import code.models.Attendance;
import code.models.Grade;
import code.models.Student;

import java.util.ArrayList;
import java.util.List;

public class FillDummyData {
    private static final String[] FIRST_NAMES = {"John", "Emma", "Michael", "Sophia", "William", "Olivia", "James", "Isabella", "Benjamin", "Mia"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Williams", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Martinez"};

    public static void main(String[] args) {
        cleanDatabase();
        fillDatabase();
    }

    private static void cleanDatabase() {
        StudentDAO studentDAO = new StudentDAO();
        GradeDAO gradeDAO = new GradeDAO();
        AttendanceDAO attendanceDAO = new AttendanceDAO();

        // Delete all existing data
        studentDAO.deleteAllStudents();
        gradeDAO.deleteAllGrades();
        attendanceDAO.deleteAllAttendances();
    }

    private static void fillDatabase() {
        StudentDAO studentDAO = new StudentDAO();
        GradeDAO gradeDAO = new GradeDAO();
        AttendanceDAO attendanceDAO = new AttendanceDAO();

        // Fill tables with dummy data
        List<Student> students = generateDummyStudents(10);

        // Add students and get their IDs
        for (Student student : students) {
            studentDAO.addStudent(student);
        }

        // Retrieve the added students to get their IDs
        List<Student> addedStudents = studentDAO.getAllStudents();

        // Fill grades table with dummy data linked to student IDs
        List<Grade> grades = generateDummyGrades(addedStudents);

        for (Grade grade : grades) {
            gradeDAO.addGrade(grade);
        }

        // Fill attendance table with dummy data linked to student IDs
        List<Attendance> attendances = generateDummyAttendances(addedStudents);

        for (Attendance attendance : attendances) {
            attendanceDAO.addAttendance(attendance);
        }

        System.out.println("Database cleaned and filled with dummy data.");
    }

    private static List<Student> generateDummyStudents(int count) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String firstName = FIRST_NAMES[i % FIRST_NAMES.length];
            String lastName = LAST_NAMES[i % LAST_NAMES.length];
            String fullName = firstName + " " + lastName;
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@ekg.com.np";
            students.add(new Student(0, fullName, email, "1234567890"));
        }
        return students;
    }

    private static List<Grade> generateDummyGrades(List<Student> students) {
        List<Grade> grades = new ArrayList<>();
        String[] subjects = {"Maths", "Science", "Computer", "English", "History", "Geography", "Physics", "Chemistry", "Biology", "Art"};
        for (Student student : students) {
            for (String subject : subjects) {
                grades.add(new Grade(0, student.getId(), subject, 90 + student.getId()));
            }
        }
        return grades;
    }

    private static List<Attendance> generateDummyAttendances(List<Student> students) {
        List<Attendance> attendances = new ArrayList<>();
        for (Student student : students) {
            attendances.add(new Attendance(0, student.getId(), "2024-03-" + student.getId(), student.getId() % 2 == 0));
        }
        return attendances;
    }
}
