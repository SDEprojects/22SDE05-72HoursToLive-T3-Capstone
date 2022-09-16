package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;

public class JPanel_InformationBar extends JPanel{
    public JPanel_InformationBar() {
        this.setBackground(new Color(31,107,0));
        this.setBounds(0,500,1000,25);

        this.add(new JLabel("Mode"));
        JTextArea modeText = new JTextArea("Easy");
        modeText.setBackground(new Color(31,107,0));
        modeText.setForeground(Color.RED);
        modeText.setEditable(false);
        this.add(modeText);

        this.add(new JLabel("Hours Remaining"));
        JTextArea hoursRemainingText = new JTextArea("72");
        hoursRemainingText.setBackground(new Color(31,107,0));
        hoursRemainingText.setForeground(Color.red);
        hoursRemainingText.setEditable(false);
        this.add(hoursRemainingText);

        this.add(new JLabel("Health"));
        JTextArea healthText = new JTextArea("100");
        healthText.setBackground(new Color(31,107,0));
        healthText.setForeground(Color.CYAN);
        healthText.setEditable(false);
        this.add(healthText);

        this.add(new JLabel("Armor"));
        JTextArea armorText = new JTextArea("10");
        armorText.setBackground(new Color(31,107,0));
        armorText.setForeground(Color.BLUE);
        armorText.setEditable(false);
        this.add(armorText);

        this.add(new JLabel("Atk"));
        JTextArea attackText = new JTextArea("10");
        attackText.setBackground(new Color(31,107,0));
        attackText.setForeground(Color.YELLOW);
        attackText.setEditable(false);
        this.add(attackText);

        this.add(new JLabel("Inventory"));
        JTextArea inventoryText = new JTextArea("Shield, Sword, Helmet");
        inventoryText.setBackground(new Color(31,107,0));
        inventoryText.setForeground(Color.BLUE);
        inventoryText.setEditable(false);
        this.add(inventoryText);

        this.add(new JLabel("Current Room"));
        JTextArea currentRoomText = new JTextArea("Throne Room");
        currentRoomText.setBackground(new Color(31,107,0));
        currentRoomText.setForeground(Color.orange);
        currentRoomText.setEditable(false);
        this.add(currentRoomText);
    }
}
