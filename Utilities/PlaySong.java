package Utilities;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.io.File;

public class PlaySong {
    private static AudioClip mediaPlayer;
    private static boolean running = false;

    public static void playSong(String song) {
        stopPlayingSong();

        new JFXPanel();
        Media hit = new Media(new File(song).toURI().toString());
        mediaPlayer = new AudioClip(hit.getSource());
        mediaPlayer.play();
        running = true;
    }

    public static void stopPlayingSong() {
        if(running) {
            mediaPlayer.stop();
            running = false;
        }
    }

    public static void resumeSong() {
        if(!running) {
            mediaPlayer.play();
            running = true;
        }
    }

    public static void repeatSong() throws InterruptedException {
        stopPlayingSong();
        resumeSong();
    }

    public static void pauseSong() throws InterruptedException {
        mediaPlayer.wait();
    }
}
