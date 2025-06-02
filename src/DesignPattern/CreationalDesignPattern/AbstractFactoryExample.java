package DesignPattern.CreationalDesignPattern;

public class AbstractFactoryExample {
    // Abstract Products
    interface Shape {
        void draw();
    }

    interface Color {
        void fill();
    }

    // Concrete Shapes
    static class Circle implements Shape {
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    static class Square implements Shape {
        public void draw() {
            System.out.println("Drawing a Square");
        }
    }

    // Concrete Colors
    static class Red implements Color {
        public void fill() {
            System.out.println("Filling with Red color");
        }
    }

    static class Blue implements Color {
        public void fill() {
            System.out.println("Filling with Blue color");
        }
    }

    // Abstract Factory
    interface AbstractFactory {
        Shape createShape();
        Color createColor();
    }

    // Concrete Factory 1
    static class ShapeFactory implements AbstractFactory {
        public Shape createShape() {
            return new Circle();
        }
        public Color createColor() {
            return null;  // This factory doesn't create colors
        }
    }

    // Concrete Factory 2
    static class ColorFactory implements AbstractFactory {
        public Shape createShape() {
            return null; // This factory doesn't create shapes
        }
        public Color createColor() {
            return new Red();
        }
    }

    // Client
    public static void main(String[] args) {
        AbstractFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.createShape();
        shape.draw();

        AbstractFactory colorFactory = new ColorFactory();
        Color color = colorFactory.createColor();
        color.fill();
    }
}
