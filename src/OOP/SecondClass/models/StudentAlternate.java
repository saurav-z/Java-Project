package OOP.SecondClass.models;

import java.util.List;

public class StudentAlternate {
    String name;
    int age;
    int grade;
    List<Marks> marksList;

    public StudentAlternate(String name, int age, int grade, List<Marks> marksList) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.marksList = marksList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Marks> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<Marks> marksList) {
        this.marksList = marksList;
    }
}
