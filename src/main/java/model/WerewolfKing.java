package main.java.model;

import main.java.controller.GameController;

import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;

import static main.java.controller.GUIGameController.gameOutputPanel;

public class WerewolfKing extends Werewolf{

    // fields
    private Random random;

    //sets up for JSON parsing
    private static final ResourceBundle bundle = ResourceBundle.getBundle("main.resources.strings");

    // werewolfKing method sets up attributes for a werewolf king enemy
    public WerewolfKing(){
        super("The Wolf King", "Throne Room", 100, 12, new LinkedList<String>(), 10);
        random = new Random();
        this.getInventory().add("blood sample");
    }

    // method controls werewolf king attacks on player. contains randomizer for special attacks.
    @Override
    public void attack(Character enemy){
        if (GameController.wolfKing.getHealth() != 0) {
            super.attack(enemy);
            if (random.nextBoolean()){
                specialAttack(enemy);
            }
        }
    }

    // method controls attacks taken by werewolf king from player. includes random chance for attack deflection.
    @Override
    public void gotAttacked(Character enemy){
        int val = random.nextInt(5) + 1;

        if (getHealth() < 70 && val == 1){
            gameOutputPanel.appendGameTextArea(bundle.getString("werewolfKing_deflects1"));
            return;
        }
        super.gotAttacked(enemy);
    }

    // method outlines a special attack by werewolf king to player. destroys aka clears player inventory.
    public void specialAttack(Character enemy){
        if(enemy.getInventory().size() > 0) {
            gameOutputPanel.appendGameTextArea(bundle.getString("werewolfKing_destroys1"));
            enemy.getInventory().clear();
            sleep(1500);
        }
        }

    // sleep timer
    private static void sleep(int timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}