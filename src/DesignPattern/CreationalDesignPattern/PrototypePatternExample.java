package DesignPattern.CreationalDesignPattern;

public class PrototypePatternExample {

    // Prototype interface
    interface Prototype extends Cloneable {
        Prototype clone();
    }

    // Concrete class
    static class Document implements Prototype {
        private String title;
        private String content;

        public Document(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public Prototype clone() {
            try {
                return (Document) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("Cloning not supported", e);
            }
        }

        @Override
        public String toString() {
            return "Document [title=" + title + ", content=" + content + "]";
        }
    }

    // Main method
    public static void main(String[] args) {
        // Original document
        Document original = new Document("Project Plan", "Initial draft content");

        // Clone it
        Document copy = (Document) original.clone();
        copy.setContent("Updated content in copied document");

        System.out.println("Original: " + original);
        System.out.println("Copy    : " + copy);
    }
}


//The Prototype Pattern is a creational design pattern used when creating
// a new object is costly, and instead of building it from scratch, you clone an existing object.

//✅ When to Use
//When object creation is expensive (in terms of time or resources).
//When you want to avoid the overhead of initializing objects repeatedly.
//When you want to create objects that are similar but slightly modified.

//🎯 Benefits
//1.Reduces the cost of creating objects.
//2.Simplifies object creation logic.
//3.Good for scenarios like:
    //GUI elements (buttons, windows)
    //Game characters or items
    //Templates (in Word processors, resumes, etc.)