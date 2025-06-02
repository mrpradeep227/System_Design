package DesignPattern.CreationalDesignPattern;

public class BuilderPatternExample {

    // Product class
    static class Computer {
        // Required parameters
        private final String CPU;
        private final int RAM;

        // Optional parameters
        private final boolean hasGraphicsCard;
        private final boolean hasSSD;

        // Private constructor
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.hasGraphicsCard = builder.hasGraphicsCard;
            this.hasSSD = builder.hasSSD;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM +
                    "GB, GraphicsCard=" + hasGraphicsCard +
                    ", SSD=" + hasSSD + "]";
        }

        // Builder class
        static class Builder {
            private final String CPU;
            private final int RAM;

            private boolean hasGraphicsCard;
            private boolean hasSSD;

            public Builder(String CPU, int RAM) {
                this.CPU = CPU;
                this.RAM = RAM;
            }

            public Builder withGraphicsCard(boolean value) {
                this.hasGraphicsCard = value;
                return this;
            }

            public Builder withSSD(boolean value) {
                this.hasSSD = value;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        // Building a custom computer
        Computer myComputer = new Computer.Builder("Intel i7", 16)
                .withGraphicsCard(true)
                .withSSD(true)
                .build();

        System.out.println(myComputer);

        // Building a basic computer
        Computer basicComputer = new Computer.Builder("AMD Ryzen 3", 8)
                .build();

        System.out.println(basicComputer);
    }
}


//The Builder Pattern is a creational design pattern that is used to construct
// complex objects step by step, allowing you to create different representations of the same object.

//✅ When to Use It
//When the object creation is complex (many fields or optional parameters).
//When you want to avoid telescoping constructors (constructors with many parameters).
//When you want to construct objects in a readable and maintainable way.

//🎯 Advantages
//Handles complex object creation clearly.
//Makes code more readable.
//Supports immutability (you can make Computer immutable).