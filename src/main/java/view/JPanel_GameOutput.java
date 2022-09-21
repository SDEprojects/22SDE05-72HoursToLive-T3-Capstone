package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class JPanel_GameOutput extends JPanel{
    JTextArea gameTextArea = new JTextArea("", 15, 100);
    public JPanel_GameOutput() {
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds(20,20,1000,270);
        //this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        gameTextArea.setEditable(false);
        gameTextArea.setForeground(Color.green);
        gameTextArea.setBackground(Color.black);
        gameTextArea.setSelectionColor(Color.green);
        gameTextArea.setLineWrap(true);
        gameTextArea.setWrapStyleWord(true);
        gameTextArea.setToolTipText("Enter your response in the panel below");
        gameTextArea.setText("WELCOME TO 72 HOURS");
        this.add(gameTextArea);
    }

    public String getGameTextArea() {
        return gameTextArea.getText();
    }

    public void clearGameTextArea() {
        this.gameTextArea.setText("");
    }

    public void appendGameTextArea(String text) {
        this.gameTextArea.append(text);
    }



}
