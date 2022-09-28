package main.java.view;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import static main.java.controller.GUIGameController.gameOutputPanel;


//ALL Scanners and SOUTs need to be replaced with a "Printer" class

//Music that can loop throughout the game
public class Music {
    public static boolean musicOn = true;
    //add volume options

    public Music() throws UnsupportedAudioFileException, IOException {
    }

    public static void playMusic() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();


        InputStream music = classLoader.getResourceAsStream("main/resources/sound.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(music));

        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (musicOn) {
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                    if (!musicOn) {
                        clip.stop();
                    }
                }
            }
        });
        thread.start();
    }

    //Player can select if the music plays or not
    public static void playerSelectMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Music music = new Music();
        if (Music.musicOn) {
            Music.musicOn = false;
            System.out.println(TextColor.WHITE + "\nMusic turned off.\n");
        } else {
            Music.musicOn = true;
            System.out.println(TextColor.WHITE + "\nMusic turned on.\n");
            music.playMusic();
        }
    }

    public static void guiPlayerSelectMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Music music = new Music();
        if (Music.musicOn) {
            Music.musicOn = false;
            gameOutputPanel.appendGameTextArea("\nMusic turned off.\n");
        } else {
            Music.musicOn = true;
            gameOutputPanel.appendGameTextArea("\nMusic turned on.\n");
            music.playMusic();
        }
    }
}
