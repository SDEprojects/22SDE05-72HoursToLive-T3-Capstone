package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_Inventory extends JPanel{
    public JPanel_Inventory() {
        this.setBackground(Color.white);
        this.setBounds(0,500,1000,50);

        this.add(new JLabel("Mode"));
        JTextArea modeText = new JTextArea("Easy");
        this.add(modeText);

        this.add(new JLabel("Health"));
        JTextArea healthText = new JTextArea("100");
        this.add(healthText);

        this.add(new JLabel("Armor"));
        JTextArea armorText = new JTextArea("10");
        this.add(armorText);

        this.add(new JLabel("Atk"));
        JTextArea attackText = new JTextArea("10");
        this.add(attackText);

        this.add(new JLabel("Hours Remaining"));
        JTextArea hoursRemainingText = new JTextArea("72");
        this.add(hoursRemainingText);

        this.add(new JLabel("Inventory"));
        JTextArea inventoryText = new JTextArea("Shield, Sword, Helmet");
        this.add(inventoryText);

        this.add(new JLabel("Current Room"));
        JTextArea currentRoomText = new JTextArea("Throne Room");
        this.add(currentRoomText);
    }
}
