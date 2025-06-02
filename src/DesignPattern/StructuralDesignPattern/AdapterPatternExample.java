package DesignPattern.StructuralDesignPattern;

// Target interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee - existing class with a different interface
class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();

    @Override
    public void play(String audioType, String fileName) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            advancedPlayer.playVlc(fileName);
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advancedPlayer.playMp4(fileName);
        } else {
            System.out.println("Format not supported: " + audioType);
        }
    }
}

// Concrete class using adapter
class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("Playing MP3 file: " + fileName);
        } else {
            mediaAdapter = new MediaAdapter();
            mediaAdapter.play(audioType, fileName);
        }
    }
}

// Main class
public class AdapterPatternExample {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("mp3", "song1.mp3");
        player.play("mp4", "video1.mp4");
        player.play("vlc", "movie1.vlc");
        player.play("avi", "clip1.avi");
    }
}
//The Adapter Pattern is a structural design pattern that allows incompatible interfaces to work together.
// It converts the interface of a class into another interface the client expects.

// ✅ When to Use
//When you want to reuse existing classes but their interface does not match what your code expects.
//When integrating with third-party libraries or legacy code.
//To ensure interface compatibility without modifying the existing source code.
