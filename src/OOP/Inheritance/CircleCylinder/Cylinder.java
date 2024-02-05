package OOP.Inheritance.CircleCylinder;

public class Cylinder extends Circle {
    double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double volume() {
        return area() * height;

    }

}
