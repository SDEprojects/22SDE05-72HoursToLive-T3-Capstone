package main.java.controller;

import main.java.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ResourceBundle;

public class GUIGameController {

    static JFrame_App app = new JFrame_App();
    public static final JPanel_GameOutput gameOutputPanel = new JPanel_GameOutput();
    private static final JPanel_UserInput userInputPanel = new JPanel_UserInput();
    private static final JPanel_InformationBar informationBar = new JPanel_InformationBar();
    private static final JPanel_Map mapPanel = new JPanel_Map();

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

    static JButton goNorth = new JButton();
    static JButton goEast = new JButton();
    static JButton goSouth = new JButton();
    static JButton goWest = new JButton();
    static JButton attack = new JButton();

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
        buttonsPanel.setBounds(0, 530, 1250, 40);
        buttonsPanel.setVisible(true);

        playBtn.setText("PLAY GAME");
        playBtn.setBounds(120, 400, 100, 40);
        playBtn.setBackground(Color.black);
        playBtn.setForeground(new Color(30, 81, 40));
        playBtn.addActionListener(new handlePlayBtnClick());

        helpBtn.setText("HELP");
        helpBtn.setBounds(340, 400, 100, 40);
        helpBtn.setBackground(Color.black);
        helpBtn.setForeground(new Color(30, 81, 40));
        helpBtn.addActionListener(new handleHelpBtnClick());

        musicBtn.setText("MUSIC");
        musicBtn.setBounds(560, 400, 100, 40);
        musicBtn.setBackground(Color.black);
        musicBtn.setForeground(new Color(30, 81, 40));

        menuBtn.setText("MAIN MENU");
        menuBtn.setBounds(780, 400, 100, 40);
        menuBtn.setBackground(Color.black);
        menuBtn.setForeground(new Color(30, 81, 40));
        menuBtn.addActionListener(new handleMenuBtnClick());


        app.add(gameOutputPanel);
        app.add(buttonsPanel);
        buttonsPanel.add(playBtn);
        buttonsPanel.add(helpBtn);
        buttonsPanel.add(musicBtn);
        buttonsPanel.add(menuBtn);
        app.pack();
    }

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
        easyBtn.setBounds(120, 400, 100, 40);
        easyBtn.setBackground(Color.black);
        easyBtn.setForeground(new Color(30, 81, 40));
        easyBtn.addActionListener(new handleEasyBtnClick());

        medBtn.setText("MEDIUM");
        medBtn.setBounds(340, 400, 100, 40);
        medBtn.setBackground(Color.black);
        medBtn.setForeground(new Color(30, 81, 40));
        medBtn.addActionListener(new handleMedBtnClick());

        hardBtn.setText("HARD");
        hardBtn.setBounds(560, 400, 100, 40);
        hardBtn.setBackground(Color.black);
        hardBtn.setForeground(new Color(30, 81, 40));
        hardBtn.addActionListener(new handleHardBtnClick());

        impossibleBtn.setText("IMPOSSIBLE");
        impossibleBtn.setBounds(780, 400, 100, 40);
        impossibleBtn.setBackground(Color.black);
        impossibleBtn.setForeground(new Color(30, 81, 40));
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
        startBtn.setBounds(120, 400, 100, 40);
        startBtn.setBackground(Color.black);
        startBtn.setForeground(new Color(30, 81, 40));
        startBtn.addActionListener(new handleStartBtnClick());

        buttonsPanel.add(startBtn);
        app.pack();
    }

    private static void startGamePlay() throws IOException {
        setUpGameScreen();

        gameSettings.startGuiGame(gameOutputPanel);
        gameOutputPanel.appendGameTextArea(bundle.getString("input_scanner_ask") + "\n");
    }

    private static void setUpGameScreen() {
        gameOutputPanel.clearGameTextArea();

        goNorth.setText("Go North");
        goNorth.setBounds(120, 400, 100, 40);
        goNorth.setBackground(Color.black);
        goNorth.setForeground(new Color(30, 81, 40));
//        goNorth.addActionListener(new handleEasyBtnClick());

        goEast.setText("Go East");
        goEast.setBounds(340, 400, 100, 40);
        goEast.setBackground(Color.black);
        goEast.setForeground(new Color(30, 81, 40));
//        goEast.addActionListener(new handleMedBtnClick());

        goSouth.setText("Go South");
        goSouth.setBounds(560, 400, 100, 40);
        goSouth.setBackground(Color.black);
        goSouth.setForeground(new Color(30, 81, 40));
//        goSouth.addActionListener(new handleHardBtnClick());

        goWest.setText("Go West");
        goWest.setBounds(780, 400, 100, 40);
        goWest.setBackground(Color.black);
        goWest.setForeground(new Color(30, 81, 40));
//        goWest.addActionListener(new handleImpossBtnClick());

        attack.setText("Attack");
        attack.setBounds(780, 400, 100, 40);
        attack.setBackground(Color.black);
        attack.setForeground(Color.blue);
//        goWest.addActionListener(new handleImpossBtnClick());

        buttonsPanel.removeAll();
        buttonsPanel.revalidate();
        buttonsPanel.repaint();
        buttonsPanel.add(goNorth);
        buttonsPanel.add(goEast);
        buttonsPanel.add(goSouth);
        buttonsPanel.add(goWest);
        buttonsPanel.add(attack);

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
        yesBtn.setBounds(120, 400, 100, 40);
        yesBtn.setBackground(Color.black);
        yesBtn.setForeground(Color.green);
        yesBtn.addActionListener(new handleYesBtnClick());

        noBtn.setText("NO");
        noBtn.setBounds(120, 400, 100, 40);
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
            gameOutputPanel.appendGameTextArea("GAME INFO\n");
            gameOutputPanel.appendGameTextArea(bundle.getString("help_intro") + "\n");
            gameOutputPanel.appendGameTextArea(bundle.getString("help_menu_GUI"));
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

    private static class handleGoNorthBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


        }

    }

    private static class handleGoEastBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private static class handleGoSouthBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


        }

    }

    private static class handleGoWestBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


        }

    }

    private static class handlAttackBtnClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


        }

    }



}
