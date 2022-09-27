package main.java.controller;

import main.java.client.Client;
import main.java.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GUIGameController {

    static JFrame_App app = new JFrame_App();
    public static final JPanel_GameOutput gameOutputPanel = new JPanel_GameOutput();
    private static final JPanel_UserInput userInputPanel = new JPanel_UserInput();
    private static final JPanel_InformationBar informationBar = new JPanel_InformationBar();
    private static final JPanel_Map mapPanel = new JPanel_Map();
//    private static final JPanel_ButtonsPanel buttonsPanel = new JPanel_ButtonsPanel();

    static JPanel buttonsPanel = new JPanel();
    static JButton playBtn = new JButton();
    static JButton helpBtn = new JButton();
    static JButton musicBtn = new JButton();
    static JButton menuBtn = new JButton();
    static JButton easyBtn = new JButton();
    static JButton medBtn = new JButton();
    static JButton hardBtn = new JButton();
    static JButton impossibleBtn = new JButton();
    static JButton startBtn = new JButton();
    static JButton yesBtn = new JButton();
    static JButton noBtn = new JButton();

    public static int difficulty = 0;

    public static GameSettings gameSettings = new GameSettings();
    public static GameController gameController = new GameController();
    private static final ResourceBundle bundle = ResourceBundle.getBundle("main.resources.strings");

    public GUIGameController() {
        startWelcomeScreen();
    }

    private void startWelcomeScreen() {
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.setBackground(Color.darkGray);
        buttonsPanel.setBounds(0, 560, 1050, 50);
        buttonsPanel.setVisible(true);

        playBtn.setText("PLAY GAME");
        playBtn.setBounds(120, 400, 100, 50);
        playBtn.setBackground(Color.black);
        playBtn.setForeground(Color.green);
        playBtn.addActionListener(new handlePlayBtnClick());

        helpBtn.setText("HELP");
        helpBtn.setBounds(340, 400, 100, 50);
        helpBtn.setBackground(Color.black);
        helpBtn.setForeground(Color.green);
        helpBtn.addActionListener(new handleHelpBtnClick());

        musicBtn.setText("MUSIC");
        musicBtn.setBounds(560, 400, 100, 50);
        musicBtn.setBackground(Color.black);
        musicBtn.setForeground(Color.green);

        menuBtn.setText("MAIN MENU");
        menuBtn.setBounds(780, 400, 100, 50);
        menuBtn.setBackground(Color.black);
        menuBtn.setForeground(Color.green);
        menuBtn.addActionListener(new handleMenuBtnClick());

        app.add(gameOutputPanel);
        app.add(buttonsPanel);
        buttonsPanel.add(playBtn);
        buttonsPanel.add(helpBtn);
        buttonsPanel.add(musicBtn);
        buttonsPanel.add(menuBtn);
        app.pack();
    };

    private static void startDifficultyScreen() {
        setupDifficultyScreen();
    }

    private static void setupDifficultyScreen() {
        gameOutputPanel.clearGameTextArea();
        gameOutputPanel.appendGameTextArea("PLEASE SELECT A DIFFICULTY BELOW...");

        buttonsPanel.removeAll();
        buttonsPanel.revalidate();
        buttonsPanel.repaint();

        easyBtn.setText("EASY");
        easyBtn.setBounds(120, 400, 100, 50);
        easyBtn.setBackground(Color.black);
        easyBtn.setForeground(Color.green);
        easyBtn.addActionListener(new handleEasyBtnClick());

        medBtn.setText("MEDIUM");
        medBtn.setBounds(340, 400, 100, 50);
        medBtn.setBackground(Color.black);
        medBtn.setForeground(Color.green);
        medBtn.addActionListener(new handleMedBtnClick());

        hardBtn.setText("HARD");
        hardBtn.setBounds(560, 400, 100, 50);
        hardBtn.setBackground(Color.black);
        hardBtn.setForeground(Color.green);
        hardBtn.addActionListener(new handleHardBtnClick());

        impossibleBtn.setText("IMPOSSIBLE");
        impossibleBtn.setBounds(780, 400, 100, 50);
        impossibleBtn.setBackground(Color.black);
        impossibleBtn.setForeground(Color.green);
        impossibleBtn.addActionListener(new handleImpossBtnClick());

        buttonsPanel.add(easyBtn);
        buttonsPanel.add(medBtn);
        buttonsPanel.add(hardBtn);
        buttonsPanel.add(impossibleBtn);
        app.pack();
    }

    private static void startIntro() {
        setUpStoryLine();
    }

    private static void setUpStoryLine() {
        gameOutputPanel.clearGameTextArea();
        gameOutputPanel.appendGameTextArea(bundle.getString("storyline"));

        buttonsPanel.removeAll();
        buttonsPanel.revalidate();
        buttonsPanel.repaint();

        startBtn.setText("START GAME");
        startBtn.setBounds(120, 400, 100, 50);
        startBtn.setBackground(Color.black);
        startBtn.setForeground(Color.green);
        startBtn.addActionListener(new handleStartBtnClick());

        buttonsPanel.add(startBtn);
        app.pack();
    }

    private static void startGamePlay() throws IOException {
        setUpGameScreen();

        gameSettings.startGuiGame(gameOutputPanel);
        gameOutputPanel.appendGameTextArea(bundle.getString("input_scanner_ask") + "\n");
    }

    private static void setUpGameScreen() throws IOException {
        gameOutputPanel.clearGameTextArea();

        buttonsPanel.removeAll();
        buttonsPanel.revalidate();
        buttonsPanel.repaint();

        app.add(informationBar);
        app.add(mapPanel);
        app.add(userInputPanel);
        app.pack();
    }

    public static void handleEnterKey(String userInput) throws IOException {
        gameOutputPanel.clearGameTextArea();

        if (GameController.player.getHealth() <= 0) {
            gameOutputPanel.appendGameTextArea(bundle.getString("player_dead1") + "\n");
            endGuiGame();
        }
        else if (GameController.timer== 24){
            gameOutputPanel.appendGameTextArea(bundle.getString("time_out1") + "\n");
            gameOutputPanel.appendGameTextArea(bundle.getString("time_out2") + "\n");
            endGuiGame();
        }
        else if (GameController.player.getInventory().contains("Trophy")) {
            gameOutputPanel.appendGameTextArea(bundle.getString("trophy_response1") + "\n");
            gameOutputPanel.appendGameTextArea(bundle.getString("trophy_response2") + "\n");
            endGuiGame();
        }
        else {
            gameController.guiUserChoice(gameOutputPanel, userInput);
        }
    }

    static void endGuiGame() {
        gameOutputPanel.appendGameTextArea(bundle.getString("game_over1") + "\n");
        gameOutputPanel.appendGameTextArea(bundle.getString("game_over2"));

        buttonsPanel.removeAll();
        buttonsPanel.revalidate();
        buttonsPanel.repaint();

        yesBtn.setText("YES");
        yesBtn.setBounds(120, 400, 100, 50);
        yesBtn.setBackground(Color.black);
        yesBtn.setForeground(Color.green);
        yesBtn.addActionListener(new handleYesBtnClick());

        noBtn.setText("NO");
        noBtn.setBounds(120, 400, 100, 50);
        noBtn.setBackground(Color.black);
        noBtn.setForeground(Color.green);
        noBtn.addActionListener(new handleNoBtnClick());

        buttonsPanel.add(yesBtn);
        buttonsPanel.add(noBtn);
        app.pack();
    }

    // *************  ACTION LISTENER CLASSES  *****************

    private static class handleHelpBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gameOutputPanel.clearGameTextArea();
            gameOutputPanel.appendGameTextArea("\nGAME INFO\n\n");
            gameOutputPanel.appendGameTextArea(bundle.getString("help_intro"));
            gameOutputPanel.appendGameTextArea(bundle.getString("help_menu"));
        }
    }

    private static class handleMenuBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gameOutputPanel.clearGameTextArea();
            gameOutputPanel.appendGameTextArea("WELCOME TO 72 HOURS");
        }
    }

    private static class handlePlayBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            startDifficultyScreen();
        }
    }

    private static class handleEasyBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            difficulty = 0;
            gameOutputPanel.appendGameTextArea("YOU HAVE SELECTED EASY MODE " + difficulty);
            startIntro();
        }
    }

    private static class handleMedBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            difficulty = 4;
            gameOutputPanel.appendGameTextArea("YOU HAVE SELECTED MEDIUM MODE " + difficulty);
            startIntro();
        }
    }

    private static class handleHardBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            difficulty = 7;
            gameOutputPanel.appendGameTextArea("YOU HAVE SELECTED HARD MODE " + difficulty);
            startIntro();
        }
    }

    private static class handleImpossBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            difficulty = 11;
            gameOutputPanel.appendGameTextArea("YOU HAVE SELECTED IMPOSSIBLE MODE " + difficulty);
            startIntro();
        }
    }

    private static class handleStartBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                startGamePlay();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

    private static class handleYesBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                GameController.wolfKing.setHealth(100);
                startGamePlay();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

    private static class handleNoBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
