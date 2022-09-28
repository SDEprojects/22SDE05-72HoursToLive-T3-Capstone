package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_Map extends JPanel {
    public JPanel_Map() {
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds(0,750,1250,225);

        String map =
            "                                         Bed Chamber I\n" +
                    "=============================================\n" +
                    "      Bed Chamber II                Hallway                Bed Chamber III\n" +
                    "=============================================\n" +
                    "       Throne Room                 Great Hall                   Armory\n" +
                    "=============================================\n" +
                    "        Garden                    Dining Room                   Kitchen\n" +
                    "=============================================\n" +
                    "        Parapet                     Ballroom                        Pantry\n" +
                    "=============================================\n" +
                    "        Stable                   Castle Grounds               Time Portal\n" +
                    "=============================================\n";

        JTextArea mapTextArea = new JTextArea(map, 16, 39);
        mapTextArea.setEditable(false);
        mapTextArea.setForeground(Color.white);
        mapTextArea.setBackground(Color.black);
        mapTextArea.setLineWrap(true);
        mapTextArea.setWrapStyleWord(true);
        this.add(mapTextArea);
    }
}
