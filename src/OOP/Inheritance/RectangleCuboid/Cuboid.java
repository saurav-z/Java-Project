package OOP.Inheritance.RectangleCuboid;

public class Cuboid extends Rectangle {
    double height;

    public Cuboid(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

    public double volume() {
        return area() * height;
    }

    public double surfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }
}
