package main.java.controller;

import main.java.client.Client;
import main.java.model.Room;
import main.java.model.RoomMovement;
import main.java.model.Werewolf;
import main.java.view.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.*;

public class GameSettings {
    public static String roomName;

    Story gameStory = new Story();
    private static final ResourceBundle bundle = ResourceBundle.getBundle("main.resources.strings");

    public void readGameStory() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Story gameStoryConsole = new Story();
        gameStoryConsole.titleScreen();
        gameStoryConsole.selectDifficulty();
        gameStoryConsole.introText();
    }

    public void readGameStory(JPanel_GameOutput gameOutputPanel, JPanel_UserInput userInputPanel) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        gameStory.titleScreen(gameOutputPanel, userInputPanel);
        //insert action listener for ENTER. then send to override.
//        gameStory.selectDifficulty(gameOutputPanel, userInputPanel);
//        gameStory.introText(gameOutputPanel, userInputPanel);
    }

    public void setupSelectDifficulty(JPanel_GameOutput gameOutputPanel, JPanel_UserInput userInputPanel) {
        gameStory.selectDifficulty(gameOutputPanel, userInputPanel);
    }

    public void startGame() throws IOException {
        List<String> emptyInventory = new ArrayList<>();
        GameController.wolfKingPrompt = true;
        GameController.player.setHealth(100);
        GameController.player.setAttackPower(10);
        GameController.player.setArmorRating(10);
        GameController.timer = 0;
        GameController.player.setInventory(emptyInventory);

        RoomMovement movement = new RoomMovement();
        movement.firstRoom();
        GameController gameController = new GameController();
        while (true) {
            if (GameController.player.getHealth() <= 0) {
                System.out.println(TextColor.RED+bundle.getString("player_dead1")+TextColor.RESET);
                sleep(1000);
                break;
            }
            else if (GameController.timer== 24){
                System.out.println(TextColor.RED+bundle.getString("time_out1"));
                sleep(1000);
                System.out.println(TextColor.RED+bundle.getString("time_out2")+TextColor.RESET);
                break;
            }
            else if (GameController.player.getInventory().contains("Trophy")) {
                sleep(500);
                System.out.println(TextColor.GREEN+bundle.getString("trophy_response1"));
                sleep(1500);
                System.out.println(TextColor.GREEN+bundle.getString("trophy_response2")+TextColor.RESET);
                sleep(1500);
                break;
            }
            else {
                gameController.userChoice();
            }
        }
    }

    public void startGuiGame(JPanel_GameOutput gameOutputPanel) throws IOException {
        List<String> emptyInventory = new ArrayList<>();
        GameController.wolfKingPrompt = true;
        GameController.player.setHealth(100);
        GameController.player.setAttackPower(10);
        GameController.player.setArmorRating(10);
        GameController.timer = 0;
        GameController.player.setInventory(emptyInventory);

        RoomMovement movement = new RoomMovement();
        movement.guiFirstRoom(gameOutputPanel);
        View.guiMenu();
    }

    public void endGame() {
        System.out.println(TextColor.WHITE+bundle.getString("game_over1"));
        sleep(1000);
        System.out.println(TextColor.WHITE+bundle.getString("game_over2") +TextColor.RESET);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                try {
                    for (int i = 0; i < 70; ++i) System.out.println();
                    Client.repeatGame();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (input.equalsIgnoreCase("no")) {
                System.out.println(TextColor.WHITE+"\nGoodbye!");
                System.exit(0);
                break;
            }
            else {
                System.out.println(TextColor.RED+bundle.getString("replay")+TextColor.RESET);
            }
        }
    }

    public void sleep(int timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
