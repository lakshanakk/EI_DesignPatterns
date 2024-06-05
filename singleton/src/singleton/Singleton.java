package singleton;

public class Singleton {
	private static Singleton instance;

    // Private constructor to restrict instantiation of the class from other classes.
    private Singleton() {
        // Initialize variables or resources if necessary
    }

    // Public static method that returns the instance of the class, this is the global access point.
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Example method to demonstrate functionality
    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
