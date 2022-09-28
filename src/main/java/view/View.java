package main.java.view;

import main.java.controller.GUIGameController;
import main.java.controller.GameController;
import main.java.model.Room;
import main.java.model.RoomMovement;
import main.java.model.Soldier;

import javax.swing.*;

import static main.java.controller.GUIGameController.gameOutputPanel;


//ALL Scanners and SOUTs need to be replaced with a "Printer" class

public class View {

    public static void menu() {
        String cyan = TextColor.CYAN;
        if (GameController.timer % 7 == 0 && GameController.timer > 0 && GameController.moonTrigger) {
            textStream(TextColor.RED + "AHHHHHHHH-WOOOOOOOOO!!\n\n", 140);
            System.out.println(Art.wolfHowl + TextColor.RESET);
            System.out.print(TextColor.WHITE + "\nOh no! You look into the sky and see that tonight");
            textStream(TextColor.WHITE + "...is a....\n\n", 290);
            System.out.println(TextColor.RED + Art.fullMoon);
            sleep(500);
            System.out.println(TextColor.YELLOW + "The werewolves are more powerful tonight! Be careful!\n" + TextColor.RESET);
            sleep(750);
            GameController.moonTrigger = false;
        }
        Room room = RoomMovement.roomSwitcher;

        sleep(1000);
        String menu = "===========================";
        Soldier player = GameController.player;
        System.out.printf(TextColor.GREEN + "%s %12s %12s %12s %12s %12s", menu, menu, menu, menu, menu, menu);
        System.out.printf(TextColor.GREEN + "%nPlayer Info%-16s Health:%-20s Armor Rating:%-14s Attack Power:%-14s Hours Remaining:%-11s Inventory:%-13s ", ":", player.getHealth(),
                player.getArmorRating(), player.getAttackPower(), 72 - (GameController.timer * 3) + ".00", player.getInventory().toString().replace("[", "").replace("]", ""));
        System.out.printf(TextColor.GREEN + "%nRoom Info%-18s Current:%-20sNorth:%-21s East:%-22s South:%-21s West:%-16s%n", ":", room.getName(), room.getConnectedRooms().get("north"),
                room.getConnectedRooms().get("east"), room.getConnectedRooms().get("south"), room.getConnectedRooms().get("west"));

//        System.out.printf("%nROOM ITEMS%-13s %-16s%n", ":", room.getItems().toString().replace("[","").replace("]",""));
        System.out.printf("%s %12s %12s %12s %12s %12s\n", menu, menu, menu, menu, menu, menu + TextColor.RESET);
        sleep(500);

    }

    public static void guiMenu() {
        if (GameController.timer % 7 == 0 && GameController.timer > 0 && GameController.moonTrigger) {
            gameOutputPanel.appendGameTextArea("AHHHHHHHH-WOOOOOOOOO!!\n\n");
            //gameOutputPanel.appendGameTextArea(Art.wolfHowl);
            gameOutputPanel.appendGameTextArea("\nOh no! You look into the sky and see that tonight");
            gameOutputPanel.appendGameTextArea("...is a....\n\n");
            gameOutputPanel.appendGameTextArea("FULL MOON!\n\n");
            //gameOutputPanel.appendGameTextArea(Art.fullMoon);
            gameOutputPanel.appendGameTextArea("The werewolves are more powerful tonight! Be careful!\n");
            GameController.moonTrigger = false;
        }

        JPanel_InformationBar.modeText.setText(GUIGameController.modeString);
        JPanel_InformationBar.hoursRemainingText.setText(String.valueOf(72 - (GameController.timer * 3)));
        JPanel_InformationBar.healthText.setText(String.valueOf(GameController.player.getHealth()));
        JPanel_InformationBar.armorText.setText(String.valueOf(GameController.player.getArmorRating()));
        JPanel_InformationBar.attackText.setText(String.valueOf(GameController.player.getAttackPower()));
        JPanel_InformationBar.inventoryText.setText(String.valueOf(GameController.player.getInventory()));
        JPanel_InformationBar.currentRoomText.setText(RoomMovement.getCurrentRoom());

//        System.out.printf(TextColor.GREEN + "%s %12s %12s %12s %12s %12s", menu, menu, menu, menu, menu, menu);
//        System.out.printf(TextColor.GREEN + "%nPlayer Info%-16s Health:%-20s Armor Rating:%-14s Attack Power:%-14s Hours Remaining:%-11s Inventory:%-13s ", ":", player.getHealth(),
//                player.getArmorRating(), player.getAttackPower(), 72 - (GameController.timer * 3) + ".00", player.getInventory().toString().replace("[", "").replace("]", ""));
//        System.out.printf(TextColor.GREEN + "%nRoom Info%-18s Current:%-20sNorth:%-21s East:%-22s South:%-21s West:%-16s%n", ":", room.getName(), room.getConnectedRooms().get("north"),
//                room.getConnectedRooms().get("east"), room.getConnectedRooms().get("south"), room.getConnectedRooms().get("west"));
//
////        System.out.printf("%nROOM ITEMS%-13s %-16s%n", ":", room.getItems().toString().replace("[","").replace("]",""));
//        System.out.printf("%s %12s %12s %12s %12s %12s\n", menu, menu, menu, menu, menu, menu + TextColor.RESET);
//        sleep(500);

    }

    private static void sleep(int timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String textStream(String text, int speed) {
        for (int i = 0; i < text.length(); i++) {
            System.out.printf("%c", text.charAt(i));
            sleep(speed);
        }
        return text;
    }

}
