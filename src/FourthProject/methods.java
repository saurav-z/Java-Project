package FourthProject;

public class methods {
    // This is a member variable
    private int myVariable;

    // Constructor
    public methods(int initialValue) {
        this.myVariable = initialValue;
    }

    // Method to set a new value for myVariable
    public void setMyVariable(int newValue) {
        this.myVariable = newValue;
    }

    // Method to get the current value of myVariable
    public int getMyVariable() {
        return myVariable;
    }

    // Another method that performs some operation
    public void doSomething() {
        System.out.println("Doing something...");
    }

    public static void main(String[] args) {
        // Create an instance of MyClass
        methods myObject = new methods(10);

        // Use the methods
        myObject.doSomething();
        System.out.println("Current value of myVariable: " + myObject.getMyVariable());

        // Set a new value for myVariable
        myObject.setMyVariable(20);
        System.out.println("Updated value of myVariable: " + myObject.getMyVariable());
    }
}
