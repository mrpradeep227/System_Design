package DesignPattern.BehavioralDesignPattern;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Subscriber {
    void update(String videoTitle);
}

// Concrete Observers
class PersonSubscriber implements Subscriber {
    private String name;

    public PersonSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + " got notified: New video uploaded - " + videoTitle);
    }
}

// Subject interface
interface Channel {
    void subscribe(Subscriber sub);
    void unsubscribe(Subscriber sub);
    void notifySubscribers(String videoTitle);
}

// Concrete Subject
class YouTubeChannel implements Channel {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String channelName;

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void subscribe(Subscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void unsubscribe(Subscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        System.out.println("\n[" + channelName + "] Uploaded a new video: " + videoTitle);
        for (Subscriber sub : subscribers) {
            sub.update(videoTitle);
        }
    }

    public void uploadVideo(String title) {
        notifySubscribers(title);
    }
}

// Main class
public class ObserverExample {
    public static void main(String[] args) {
        YouTubeChannel techChannel = new YouTubeChannel("Techie Talks");

        Subscriber john = new PersonSubscriber("John");
        Subscriber emma = new PersonSubscriber("Emma");

        techChannel.subscribe(john);
        techChannel.subscribe(emma);

        techChannel.uploadVideo("Observer Pattern Explained");
        techChannel.uploadVideo("Java 21 Features Overview");

        techChannel.unsubscribe(john);
        techChannel.uploadVideo("Spring Boot Tutorial");
    }
}


//The Observer Pattern is a behavioral design pattern where an object,
// called the subject, maintains a list of its dependents, called observers,
// and notifies them automatically of any state changes.
//✅ When to Use
//When one object’s change needs to be automatically propagated to others.
//To decouple the subject from the observers.
//Used in event-driven systems, GUI frameworks, real-time data feeds, etc.