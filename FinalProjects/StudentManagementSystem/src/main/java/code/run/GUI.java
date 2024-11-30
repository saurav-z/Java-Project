package code.run;
import code.data.AttendanceDAO;
import code.data.GradeDAO;
import code.data.StudentDAO;
import code.models.Attendance;
import code.models.Grade;
import code.models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.List;

public class GUI extends JFrame {
    private final StudentDAO studentDAO = new StudentDAO();
    private final GradeDAO gradeDAO = new GradeDAO();
    private final AttendanceDAO attendanceDAO = new AttendanceDAO();

    private JTable dataTable;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public GUI() {
        setTitle("Student Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set frame to full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);


        dataTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(dataTable);

        // Create the sidebar
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());

// Create a panel for developed by info
        JPanel infoPanel = new JPanel(new BorderLayout());

// Add developed by info
        JLabel developedByLabel = new JLabel("Developed by Saurav Phuyal");
        developedByLabel.setForeground(Color.RED); // Set text color to red
        Font boldFont = developedByLabel.getFont().deriveFont(Font.BOLD, 16f); // Set font to bold
        developedByLabel.setFont(boldFont);
        developedByLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
        infoPanel.add(developedByLabel, BorderLayout.CENTER);

// Add the panel with developed by info to the sidebar
        sidePanel.add(infoPanel, BorderLayout.NORTH);

// Add image to the sidebar and resize it
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/profile.png"));
        int newWidth = 250; // Desired width
        int originalWidth = originalIcon.getIconWidth();
        int originalHeight = originalIcon.getIconHeight();
        int newHeight = (int) Math.round((double) originalHeight / originalWidth * newWidth); // Calculate proportional height
        Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        sidePanel.add(imageLabel, BorderLayout.CENTER);

// Create clickable links
        JPanel linkPanel = new JPanel(new GridLayout(4, 1));
        JButton websiteButton = createLinkButton("Visit Website", "https://ekg.com.np");
        JButton youtubeButton = createLinkButton("Subscribe to my channel", "https://youtube.com/@trachitz");
        JButton githubButton = createLinkButton("GitHub", "https://github.com/saurav-z");
        JButton SQLiteButton = createLinkButton("SQLite Tutorial", "https://www.youtube.com/watch?v=jM4KnPiedK0");
        linkPanel.add(websiteButton);
        linkPanel.add(youtubeButton);
        linkPanel.add(githubButton);
        linkPanel.add(SQLiteButton);

// Add the panel with clickable links to the sidebar
        sidePanel.add(linkPanel, BorderLayout.SOUTH);



        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, sidePanel);
        splitPane.setDividerLocation(1000); // Set the initial width of the main content area

        mainPanel.add(splitPane, "output");


        add(mainPanel);

        createMenu();

        setVisible(true);
        showAllStudents();

    }



    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu studentMenu = new JMenu("Students");
        JMenuItem viewStudentsItem = new JMenuItem("View All Students");
        viewStudentsItem.addActionListener(e -> showAllStudents());
        studentMenu.add(viewStudentsItem);

        JMenuItem addStudentItem = new JMenuItem("Add Student");
        addStudentItem.addActionListener(e -> addStudent());
        studentMenu.add(addStudentItem);

        JMenuItem updateStudentItem = new JMenuItem("Update Student");
        updateStudentItem.addActionListener(e -> updateStudent());
        studentMenu.add(updateStudentItem);

        JMenuItem deleteStudentItem = new JMenuItem("Delete Student");
        deleteStudentItem.addActionListener(e -> deleteStudent());
        studentMenu.add(deleteStudentItem);

        menuBar.add(studentMenu);

        JMenu gradeMenu = new JMenu("Grades");
        JMenuItem viewGradesItem = new JMenuItem("View All Grades");
        viewGradesItem.addActionListener(e -> showAllGrades());
        gradeMenu.add(viewGradesItem);

        JMenuItem addGradeItem = new JMenuItem("Add Grade");
        addGradeItem.addActionListener(e -> addGrade());
        gradeMenu.add(addGradeItem);

        JMenuItem updateGradeItem = new JMenuItem("Update Grade");
        updateGradeItem.addActionListener(e -> updateGrade());
        gradeMenu.add(updateGradeItem);

        JMenuItem deleteGradeItem = new JMenuItem("Delete Grade");
        deleteGradeItem.addActionListener(e -> deleteGrade());
        gradeMenu.add(deleteGradeItem);

        menuBar.add(gradeMenu);

        JMenu attendanceMenu = new JMenu("Attendance");
        JMenuItem viewAttendanceItem = new JMenuItem("View All Attendance Records");
        viewAttendanceItem.addActionListener(e -> showAllAttendance());
        attendanceMenu.add(viewAttendanceItem);

        JMenuItem addAttendanceItem = new JMenuItem("Add Attendance Record");
        addAttendanceItem.addActionListener(e -> addAttendance());
        attendanceMenu.add(addAttendanceItem);

        JMenuItem updateAttendanceItem = new JMenuItem("Update Attendance Record");
        updateAttendanceItem.addActionListener(e -> updateAttendance());
        attendanceMenu.add(updateAttendanceItem);

        JMenuItem deleteAttendanceItem = new JMenuItem("Delete Attendance Record");
        deleteAttendanceItem.addActionListener(e -> deleteAttendance());
        attendanceMenu.add(deleteAttendanceItem);

        menuBar.add(attendanceMenu);

        setJMenuBar(menuBar);
    }


    private JButton createLinkButton(String label, String url) {
        JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        return button;
    }
    private void showAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        displayDataInTable("Students", students);
    }

    private void addStudent() {
        String name = JOptionPane.showInputDialog(this, "Enter student name:");
        String email = JOptionPane.showInputDialog(this, "Enter student email:");
        String phone = JOptionPane.showInputDialog(this, "Enter student phone:");
        studentDAO.addStudent(new Student(0, name, email, phone));
        JOptionPane.showMessageDialog(this, "Student added successfully.");
        showAllStudents();
    }

    private void updateStudent() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter student id to update:"));
        String name = JOptionPane.showInputDialog(this, "Enter new name:");
        String email = JOptionPane.showInputDialog(this, "Enter new email:");
        String phone = JOptionPane.showInputDialog(this, "Enter new phone:");
        studentDAO.updateStudent(new Student(id, name, email, phone));
        JOptionPane.showMessageDialog(this, "Student updated successfully.");
        showAllStudents();
    }

    private void deleteStudent() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter student id to delete:"));
        studentDAO.deleteStudent(id);
        JOptionPane.showMessageDialog(this, "Student deleted successfully.");
        showAllStudents();
    }

    private void showAllGrades() {
        List<Grade> grades = gradeDAO.getAllGrades();
        displayDataInTable("Grades", grades);
    }

    private void addGrade() {
        int studentId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter student id:"));
        String subject = JOptionPane.showInputDialog(this, "Enter subject:");
        double score = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter score:"));
        gradeDAO.addGrade(new Grade(0, studentId, subject, score));
        JOptionPane.showMessageDialog(this, "Grade added successfully.");
        showAllGrades();
    }

    private void updateGrade() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter grade id to update:"));
        int studentId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter new student id:"));
        String subject = JOptionPane.showInputDialog(this, "Enter new subject:");
        double score = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter new score:"));
        gradeDAO.updateGrade(new Grade(id, studentId, subject, score));
        JOptionPane.showMessageDialog(this, "Grade updated successfully.");
        showAllGrades();
    }

    private void deleteGrade() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter grade id to delete:"));
        gradeDAO.deleteGrade(id);
        JOptionPane.showMessageDialog(this, "Grade deleted successfully.");
        showAllGrades();
    }

    private void showAllAttendance() {
        List<Attendance> attendances = attendanceDAO.getAllAttendances();
        displayDataInTable("Attendance Records", attendances);
    }

    private void addAttendance() {
        int studentId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter student id:"));
        String date = JOptionPane.showInputDialog(this, "Enter date (YYYY-MM-DD):");
        boolean present = Boolean.parseBoolean(JOptionPane.showInputDialog(this, "Is student present? (true/false):"));
        attendanceDAO.addAttendance(new Attendance(0, studentId, date, present));
        JOptionPane.showMessageDialog(this, "Attendance record added successfully.");
        showAllAttendance();
    }

    private void updateAttendance() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter attendance record id to update:"));
        int studentId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter new student id:"));
        String date = JOptionPane.showInputDialog(this, "Enter new date (YYYY-MM-DD):");
        boolean present = Boolean.parseBoolean(JOptionPane.showInputDialog(this, "Is student present? (true/false):"));
        attendanceDAO.updateAttendance(new Attendance(id, studentId, date, present));
        JOptionPane.showMessageDialog(this, "Attendance record updated successfully.");
        showAllAttendance();
    }

    private void deleteAttendance() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter attendance record id to delete:"));
        attendanceDAO.deleteAttendance(id);
        JOptionPane.showMessageDialog(this, "Attendance record deleted successfully.");
        showAllAttendance();
    }

    private void displayDataInTable(String title, List<?> data) {
        String[] columnNames = getColumnNames(data.get(0));
        Object[][] rowData = new Object[data.size()][columnNames.length];

        for (int i = 0; i < data.size(); i++) {
            Object obj = data.get(i);
            if (obj instanceof Student) {
                Student student = (Student) obj;
                rowData[i][0] = student.getId();
                rowData[i][1] = student.getName();
                rowData[i][2] = student.getEmail();
                rowData[i][3] = student.getPhone();
            } else if (obj instanceof Grade) {
                Grade grade = (Grade) obj;
                rowData[i][0] = grade.getId();
                rowData[i][1] = grade.getStudentId();
                rowData[i][2] = grade.getSubject();
                rowData[i][3] = grade.getScore();
            } else if (obj instanceof Attendance) {
                Attendance attendance = (Attendance) obj;
                rowData[i][0] = attendance.getId();
                rowData[i][1] = attendance.getStudentId();
                rowData[i][2] = attendance.getDate();
                rowData[i][3] = attendance.isPresent();
            }
        }

        DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
        dataTable.setModel(model);

        cardLayout.show(mainPanel, "output");
        setTitle("Student Management System - " + title);
    }

    private String[] getColumnNames(Object obj) {
        if (obj instanceof Student) {
            return new String[]{"ID", "Name", "Email", "Phone"};
        } else if (obj instanceof Grade) {
            return new String[]{"ID", "Student ID", "Subject", "Score"};
        } else if (obj instanceof Attendance) {
            return new String[]{"ID", "Student ID", "Date", "Present"};
        }
        return new String[]{};
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}





