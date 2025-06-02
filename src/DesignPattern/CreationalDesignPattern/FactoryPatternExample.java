package DesignPattern.CreationalDesignPattern;

public class FactoryPatternExample {

    // Interface
    interface Notification {
        void notifyUser();
    }

    // Concrete classes
    static class EmailNotification implements Notification {
        public void notifyUser() {
            System.out.println("Sending Email Notification");
        }
    }

    static class SMSNotification implements Notification {
        public void notifyUser() {
            System.out.println("Sending SMS Notification");
        }
    }

    static class PushNotification implements Notification {
        public void notifyUser() {
            System.out.println("Sending Push Notification");
        }
    }

    // Factory class
    static class NotificationFactory {
        public Notification createNotification(String type) {
            if (type == null) return null;

            switch (type.toUpperCase()) {
                case "EMAIL":
                    return new EmailNotification();
                case "SMS":
                    return new SMSNotification();
                case "PUSH":
                    return new PushNotification();
                default:
                    throw new IllegalArgumentException("Unknown type: " + type);
            }
        }
    }

    // Main method (client)
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification notification = factory.createNotification("SMS");
        notification.notifyUser(); // Output: Sending SMS Notification
    }
}
//The Factory Design Pattern is a creational design pattern that provides an interface for
// creating objects in a superclass but allows subclasses to alter the type of objects that will be created.

//✅ When to Use
//When the creation logic is complex.
//When you have multiple subclasses of a common parent/interface.
//When you want to decouple the code from specific classes.
//The exact type of the object to create isn't known until runtime.
//You want to delegate the responsibility of instantiating a class to a separate component.


// Why Use This Pattern?
// 1. Encapsulation of object creation
// 2. Easier to manage new notification types
// 3. Reduces tight coupling between object creation and usage