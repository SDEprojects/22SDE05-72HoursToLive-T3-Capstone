package main.java.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.controller.GameController;
import main.java.view.JPanel_GameOutput;
import main.java.view.TextColor;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class RoomMovement {

    // fields
    public static String currentRoom;
    public static Room roomSwitcher;

    public static HashMap<String, List<Werewolf>> monsterMap = new HashMap<>();

    // defining lists and setting up for JSON parsing
    //    Room room = new Room();
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<HashMap<String, Room>> typeRef  = new TypeReference<HashMap<String, Room>>() {};
    TypeReference<HashMap<String, HashSet<String>>> typeRef2 = new TypeReference<HashMap<String, HashSet<String>>>() {};

    private static HashMap<String, HashSet<String>> itemMap;
    static HashMap<String, Room> allRooms;

    // parsing JSON files for use
    private static final ResourceBundle bundle = ResourceBundle.getBundle("main.resources.strings");

    {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream resources = classLoader.getResourceAsStream("main/resources/rooms.json");
            allRooms = new ObjectMapper().readValue(resources, typeRef);
            //allRooms = new ObjectMapper().readValue(new File("src/main/resources/rooms.json"), typeRef);
            InputStream items = classLoader.getResourceAsStream("main/resources/items.json");
            itemMap = new ObjectMapper().readValue(items, typeRef2);

            populateRoomWithItems(2);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // adds random items to each room from JSON list of items
    private static void populateRoomWithItems(int numItems){
        ArrayList<String> keyList = new ArrayList<>(itemMap.keySet());
        Random random = new Random();
        keyList.remove("Trophy");
        keyList.remove("blood sample");
        for (String key : allRooms.keySet()){
            HashSet<String> itemSet = new HashSet<>();
            while (itemSet.size() < numItems){
                int pos = random.nextInt(keyList.size());
                itemSet.add(keyList.get(pos));
            }
            allRooms.get(key).getItems().addAll(itemSet);
        }
    }


    /**
     * This method generates a random room that will be used as the FIRST room
     * the user starts in.
     */
    public void firstRoom(){
        do {
            currentRoom = allRooms.keySet().toArray()[(int) (Math.random() * allRooms.size())] + "";
        } while (currentRoom.equalsIgnoreCase("Throne Room"));
        Room room = allRooms.get(currentRoom);
        roomSwitcher = room;
        textStream(TextColor.BLUE + bundle.getString("firstRoom_text1"),110);
        sleep(1000);
        System.out.println(TextColor.BLUE + bundle.getString("firstRoom_text2"));
        sleep(2000);
        System.out.println(TextColor.BLUE + bundle.getString("firstRoom_text3"));
        sleep(2350);
        System.out.println(TextColor.BLUE + bundle.getString("firstRoom_text4") + TextColor.WHITE + room.getName()+ "." );
        sleep(750);
        System.out.println(TextColor.BLUE + room.getDescription() + TextColor.RESET + "\n");
        sleep(550);
    }

    public void guiFirstRoom(JPanel_GameOutput gameOutputPanel){
        do {
            currentRoom = allRooms.keySet().toArray()[(int) (Math.random() * allRooms.size())] + "";
        } while (currentRoom.equalsIgnoreCase("Throne Room"));

        Room room = allRooms.get(currentRoom);
        roomSwitcher = room;
        gameOutputPanel.appendGameTextArea(bundle.getString("firstRoom_text1"));
        gameOutputPanel.appendGameTextArea(bundle.getString("firstRoom_text2"));
        gameOutputPanel.appendGameTextArea(bundle.getString("firstRoom_text3"));
        gameOutputPanel.appendGameTextArea(bundle.getString("firstRoom_text4") + room.getName()+ ".\n" );
        gameOutputPanel.appendGameTextArea("\n" + room.getDescription() + "\n");

        monsterMap = makeMonsterMap(currentRoom);
    }

    // method allows player to transition rooms
    public static void switchRooms(String location) throws IOException {
        currentRoom = roomSwitcher.getConnectedRooms().get(location);
        Room room = allRooms.get(currentRoom);
        roomSwitcher = room;
    }

    // getter - returns all rooms
    public static HashMap<String, Room> getAllRooms(){
        return allRooms;
    }

    // timer to pause game flow for text reading, etc.
    public static void sleep(int timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // method allows for the slow printing of text across the terminal.
    private String textStream(String text, int speed) {
        for (int i = 0; i < text.length(); i++) {
            System.out.printf("%c", text.charAt(i));
            sleep(speed);
        }
        return text;
    }

    public static String getCurrentRoom() {
        return currentRoom;
    }

    public static HashMap<String, List<Werewolf>> makeMonsterMap(String room) {
        Random random = new Random();
        HashMap<String, Room> allMap = RoomMovement.getAllRooms();
        HashMap<String, List<Werewolf>> monsterMap = new HashMap<>();
        for (String key : allMap.keySet()) {
            monsterMap.put(key, new LinkedList<>());
            if (key.equals("Throne Room")) {
                monsterMap.get(key).add(GameController.wolfKing);
            } else if (random.nextBoolean() && !key.equals(room)) {
                monsterMap.get(key).add(new Werewolf());
            }
        }
        return monsterMap;
    }
}
