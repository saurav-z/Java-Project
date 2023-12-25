package OOP.FirstClass.models;

public class Student {
    String Name, Gender, Section;
    int Age,Grade=12;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }


    public int getGrade() {
        return Grade;
    }

    public void setGrade(int aGrade) {
        Grade = aGrade;
    }
}
