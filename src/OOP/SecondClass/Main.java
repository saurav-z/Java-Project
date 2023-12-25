package OOP.SecondClass;

import OOP.SecondClass.models.Marks;
import OOP.SecondClass.models.StudentAlternate;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Marks mark1 = new Marks("English", 23, 89);
        List<Marks> marksList = new ArrayList<>();
        marksList.add(mark1);
        StudentAlternate sc = new StudentAlternate("Hacke", 18, 12, marksList);
        System.out.println(sc.getAge());

        for (Marks mc : sc.getMarksList()) {
            System.out.println(mc.getSubject());
            System.out.println(mc.getPracticalMarks());
            System.out.println(mc.getTheoryMarks());
        }
    }
}
