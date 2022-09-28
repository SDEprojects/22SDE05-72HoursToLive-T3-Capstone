package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_GameOutput extends JPanel{
    JTextArea gameTextArea = new JTextArea("", 32, 103);
    public JPanel_GameOutput() {
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds(0,0,1250,530);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,20,-505));


        gameTextArea.setEditable(false);
        gameTextArea.setForeground(Color.green);
        gameTextArea.setBackground(Color.black);
        gameTextArea.setSelectionColor(Color.green);
        gameTextArea.setLineWrap(true);
        gameTextArea.setWrapStyleWord(true);
        gameTextArea.setFont(new Font("", Font.PLAIN, 18));
        gameTextArea.setToolTipText("Enter your response in the panel below");
        gameTextArea.setText("WELCOME TO 72 HOURS");
        this.add(gameTextArea);
    }

    public void clearGameTextArea() {
        this.gameTextArea.setText("");
    }

    public void appendGameTextArea(String text) {
        this.gameTextArea.append(text);
    }



}
