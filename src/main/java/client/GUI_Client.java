package main.java.client;

import main.java.controller.GameSettings;
import main.java.view.JFrame_App;
import main.java.view.Story;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GUI_Client {
    /* This is the main class of the game. It is responsible for starting the game. */
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        JFrame_App app = new JFrame_App();
        GameSettings gameSettings = new GameSettings();
//        Music music = new Music();
//        music.playMusic();
        gameSettings.readGameStory(app.getGameOutputPanel(), app.getUserInputPanel());
//        gameSettings.startGame();
//        gameSettings.endGame();

    }
    public static void repeatGame() throws IOException {
        GameSettings gameSettings = new GameSettings();
        Story story = new Story();
        story.selectDifficulty();
        gameSettings.startGame();
        gameSettings.endGame();
    }
}
