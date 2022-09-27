package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class JPanel_GameOutput extends JPanel{
    JTextArea gameTextArea = new JTextArea("", 35, 103);
    public JPanel_GameOutput() {
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
//        this.setBorder(BorderFactory.createEmptyBorder(0,0,20,-210));
        this.setBounds(0,0,1250,570);

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

    public void clearGameTextArea() {
        this.gameTextArea.setText("");
    }

    public void appendGameTextArea(String text) {
        this.gameTextArea.append(text);
    }



}
