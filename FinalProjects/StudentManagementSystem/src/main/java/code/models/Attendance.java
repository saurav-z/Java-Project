package code.models;

public class Attendance {
    private int id;
    private int studentId;
    private String date;
    private boolean present;

    public Attendance(int id, int studentId, String date, boolean present) {
        this.id = id;
        this.studentId = studentId;
        this.date = date;
        this.present = present;
    }

    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", date='" + date + '\'' +
                ", present=" + present +
                '}';
    }
}
