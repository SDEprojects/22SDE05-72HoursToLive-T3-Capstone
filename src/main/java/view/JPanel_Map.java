package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_Map extends JPanel {
    public JPanel_Map() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds(0,325,1300,225);
        JLabel mapLabel = new JLabel("Map");
        mapLabel.setForeground(Color.white);
//        this.add(mapLabel);

        String testMap =
            "                                  Bed Chamber I\n" +
                    "=============== ================== ============\n" +
                    "      Bed Chamber II                Hallway                Bed Chamber III\n" +
                    "=============== ================== ============\n" +
                    "       Throne Room                 Great Hall                   Armory\n" +
                    "=============== ================== ============\n" +
                    "        * YOU *                    Dining Room                 Kitchen\n" +
                    "=============== ================== ============\n" +
                    "        Parapet                     Ballroom                    Pantry\n" +
                    "=============== ================== ============\n" +
                    "        Stable                   Castle Grounds               Time Portal\n" +
                    "=============== ================== ============\n";

        JTextArea mapTextArea = new JTextArea(testMap, 16, 39);
        mapTextArea.setEditable(false);
        mapTextArea.setForeground(Color.white);
        mapTextArea.setBackground(Color.black);
        mapTextArea.setLineWrap(true);
        mapTextArea.setWrapStyleWord(true);
        this.add(mapTextArea);
    }
}
