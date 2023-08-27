public class Gravity {
        public static void main(String[] args) {
            double massOfEarth = 5.972 * Math.pow(10, 24);
            double gravitationalConstant = 6.67430 * Math.pow(10, -11);

            double gravity = (gravitationalConstant * massOfEarth) / Math.pow(6.371 * Math.pow(10, 6), 2);

            System.out.println("The gravity of Earth: " + gravity + " m/s²");
        }
}
