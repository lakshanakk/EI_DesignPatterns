package singleton;

public class SingletonDemo {
	public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        singleton1.setValue(42);
        System.out.println(singleton1.getValue());  // Output: 42

        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2.getValue());  // Output: 42

        System.out.println(singleton1 == singleton2);  // Output: true, both variables point to the same instance
    }

}
