package code.models;

public class Grade {
    private int id;
    private int studentId;
    private String subject;
    private double score;

    public Grade(int id, int studentId, String subject, double score) {
        this.id = id;
        this.studentId = studentId;
        this.subject = subject;
        this.score = score;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                '}';
    }
}
