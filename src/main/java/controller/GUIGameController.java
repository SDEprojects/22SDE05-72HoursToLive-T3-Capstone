package main.java.controller;

import main.java.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class GUIGameController {

    static JFrame_App app = new JFrame_App();
    private static final JPanel_GameOutput gameOutputPanel = new JPanel_GameOutput();
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

    public static int difficulty = 0;
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

    private static void startGamePlay() {
        setUpGameScreen();
    }

    private static void setUpGameScreen() {
        gameOutputPanel.clearGameTextArea();
        gameOutputPanel.appendGameTextArea("YOU'RE STARTING THE GAME");

        app.add(informationBar);
        app.add(mapPanel);
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
            startGamePlay();

        }
    }

}
