package DesignPattern.BehavioralDesignPattern;

// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}

// Context class
class PaymentProcessor {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        if (strategy == null) {
            System.out.println("No payment strategy selected.");
        } else {
            strategy.pay(amount);
        }
    }
}

// Main class
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.setPaymentStrategy(new CreditCardPayment());
        processor.processPayment(1200.50);

        processor.setPaymentStrategy(new UpiPayment());
        processor.processPayment(750.00);

        processor.setPaymentStrategy(new PayPalPayment());
        processor.processPayment(450.75);
    }
}
//The Strategy Pattern is a behavioral design pattern
// that allows you to define a family of algorithms, put each of them in a separate class,
// and make their objects interchangeable.

//✅ When to Use
//When you have multiple ways of performing a task (algorithm or behavior).
//When you want to switch behavior at runtime without using conditionals (if-else or switch).
//To follow the Open/Closed Principle — open for extension, closed for modification.