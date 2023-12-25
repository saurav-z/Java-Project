package OOP.SecondClass.models;

public class Marks {
    String subject;
    int practicalMarks;
    int theoryMarks;

    public Marks(String subject, int practicalMarks, int theoryMarks) {
        this.subject = subject;
        this.practicalMarks = practicalMarks;
        this.theoryMarks = theoryMarks;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPracticalMarks() {
        return practicalMarks;
    }

    public void setPracticalMarks(int practicalMarks) {
        this.practicalMarks = practicalMarks;
    }

    public int getTheoryMarks() {
        return theoryMarks;
    }

    public void setTheoryMarks(int theoryMarks) {
        this.theoryMarks = theoryMarks;
    }
}
