package main.java.view;

import main.java.controller.GameController;
import main.java.controller.GameSettings;
import main.java.model.RoomMovement;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;

public class JPanel_InformationBar extends JPanel{

    public static JTextArea modeText = new JTextArea("Easy");
    public static JTextArea hoursRemainingText = new JTextArea(String.valueOf(72 - (GameController.timer * 3)));
    public static JTextArea healthText = new JTextArea(String.valueOf(GameController.player.getHealth()));
    public static JTextArea armorText = new JTextArea(String.valueOf(GameController.player.getArmorRating()));
    public static JTextArea attackText = new JTextArea(String.valueOf(GameController.player.getAttackPower()));
    public static JTextArea inventoryText = new JTextArea(String.valueOf(GameController.player.getInventory()));
    public static JTextArea currentRoomText = new JTextArea(RoomMovement.getCurrentRoom());

    public JPanel_InformationBar() {
        this.setBackground(Color.lightGray);
        this.setBounds(0,725,1250,25);

        this.add(new JLabel("Mode"));
        modeText.setBackground(Color.lightGray);
        modeText.setForeground(new Color(31,107,0));
        modeText.setEditable(false);
        this.add(modeText);

        this.add(new JLabel("Hours Remaining"));
        hoursRemainingText.setBackground(Color.lightGray);
        hoursRemainingText.setForeground(Color.red);
        hoursRemainingText.setEditable(false);
        this.add(hoursRemainingText);

        this.add(new JLabel("Health"));
        healthText.setBackground(Color.lightGray);
        healthText.setForeground(new Color(31,107,0));
        healthText.setEditable(false);
        this.add(healthText);

        this.add(new JLabel("Armor"));
        armorText.setBackground(Color.lightGray);
        armorText.setForeground(Color.BLUE);
        armorText.setEditable(false);
        this.add(armorText);

        this.add(new JLabel("Atk"));
        attackText.setBackground(Color.lightGray);
        attackText.setForeground(Color.red);
        attackText.setEditable(false);
        this.add(attackText);

        this.add(new JLabel("Inventory"));
        inventoryText.setBackground(Color.lightGray);
        inventoryText.setForeground(Color.BLUE);
        inventoryText.setEditable(false);
        this.add(inventoryText);

        this.add(new JLabel("Current Room"));
        currentRoomText.setBackground(Color.lightGray);
        currentRoomText.setForeground(new Color(31,107,0));
        currentRoomText.setEditable(false);
        this.add(currentRoomText);
    }
}
