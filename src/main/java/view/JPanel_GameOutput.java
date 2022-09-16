package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class JPanel_GameOutput extends JPanel{
    private final JPanel_UserInput userInputPanel = new JPanel_UserInput();

    public JPanel_GameOutput() {
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds(0,0,1000,500);
        JLabel gameOutput = new JLabel("Game Output");
        gameOutput.setHorizontalAlignment(JLabel.CENTER);
        this.add(gameOutput);

        String testGameText =
            "You wake up in a daze...\n" +
            "You look around to collect your bearings...Nothing seems quite real.\n" +
            "\nYou suddenly remember your mission, you were sent back in time to collect the blood of the " +
            "Werewolf King and return home!\n\nYou are in the Garden.\nThe Garden is a large open area" +
            " with bright flowers and a fountain. It is a place to relax and enjoy the sun.";

        JTextArea gameTextArea = new JTextArea(testGameText, 19, 82);
        gameTextArea.setEditable(false);
        gameTextArea.setForeground(Color.green);
        gameTextArea.setBackground(Color.black);
        gameTextArea.setSelectionColor(Color.green);
        gameTextArea.setLineWrap(true);
        gameTextArea.setWrapStyleWord(true);
        gameTextArea.setToolTipText("Enter your response in the panel below");
        this.add(gameTextArea);

        this.add(userInputPanel, BorderLayout.CENTER);

    }
}
