package main.java.client;

//imports from other packages
import main.java.controller.GUIGameController;
import main.java.controller.GameSettings;
import main.java.view.Music;
import main.java.view.Story;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Client {

    /* This is the main class of the game. It is responsible for starting the game. */
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
//        GameSettings gameSettings = new GameSettings();
//        Music music = new Music();
//        music.playMusic();
//        gameSettings.readGameStory();
//        gameSettings.startGame();
//        gameSettings.endGame();

        //TAKE THIS OUT AND REMAKE JAR FILE FOR GUI CLIENT !!!!!!!!!!!!!!!!!!!!!!!!!!
        GUIGameController gui = new GUIGameController();

    }//This resets the game
    public static void repeatGame() throws IOException {
        GameSettings gameSettings = new GameSettings();
        Story story = new Story();
        story.selectDifficulty();
        gameSettings.startGame();
        gameSettings.endGame();
    }
}

