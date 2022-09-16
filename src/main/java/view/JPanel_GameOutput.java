package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class JPanel_GameOutput extends JPanel{
    JTextArea gameTextArea = new JTextArea("", 35, 101);
    public JPanel_GameOutput() {
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds(3,0,1247,570);

        gameTextArea.setEditable(false);
        gameTextArea.setForeground(Color.green);
        gameTextArea.setBackground(Color.black);
        gameTextArea.setSelectionColor(Color.green);
        gameTextArea.setLineWrap(true);
        gameTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(gameTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane);
        gameTextArea.setToolTipText("Enter your response in the panel below");
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
