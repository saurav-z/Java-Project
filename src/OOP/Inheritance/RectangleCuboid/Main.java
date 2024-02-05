package OOP.Inheritance.RectangleCuboid;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Rectangle perimeter: " + rectangle.perimeter());

        Cuboid cuboid = new Cuboid(5, 10, 3);
        System.out.println("Cuboid volume: " + cuboid.volume());
        System.out.println("Cuboid surface area: " + cuboid.surfaceArea());
    }
}
