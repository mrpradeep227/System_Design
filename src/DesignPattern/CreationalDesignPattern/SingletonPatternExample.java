package DesignPattern.CreationalDesignPattern;

public class SingletonPatternExample {
    private static final SingletonPatternExample instance = new SingletonPatternExample();

    private SingletonPatternExample() {
        System.out.println("Logger Initialized");
    }

    public static SingletonPatternExample getInstance() {
        return instance;
    }

    public void log(String msg) {
        System.out.println("Message: " + msg);

    }

    public static void main(String[] args) {

        SingletonPatternExample logger1 = SingletonPatternExample.getInstance();

        logger1.log("User Click");

        SingletonPatternExample logger2 = SingletonPatternExample.getInstance();

        logger2.log("Dashboard link visited");

        System.out.println(logger1 == logger2);
    }
}
