package main.java.view;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

//ALL Scanners and SOUTs need to be replaced with a "Printer" class
public class Story {
    Scanner scanner = new Scanner(System.in);
    public static int difficulty = 0;
    private static boolean isRunning = true;

    private static final ResourceBundle bundle = ResourceBundle.getBundle("main.resources.strings");


    public static String infoBanner =
            " ██████╗  █████╗ ███╗   ███╗███████╗    ██╗███╗   ██╗███████╗ ██████╗ \n" +
                    "██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██║████╗  ██║██╔════╝██╔═══██╗\n" +
                    "██║  ███╗███████║██╔████╔██║█████╗      ██║██╔██╗ ██║█████╗  ██║   ██║\n" +
                    "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║██║╚██╗██║██╔══╝  ██║   ██║\n" +
                    "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ██║██║ ╚████║██║     ╚██████╔╝\n" +
                    " ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝    ╚═╝╚═╝  ╚═══╝╚═╝      ╚═════╝ \n" +
                    "                                                                      \n";

    public static String infoMenu = "======================================================================\n";

    public void titleScreen() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        for (int i = 0; i < 70; ++i) System.out.println();

        String menu = "===========================================================================================================================================\n";
        String titleBanner =

                "\n███████╗███████╗██╗   ██╗███████╗███╗   ██╗████████╗██╗   ██╗    ████████╗██╗    ██╗ ██████╗     ██╗  ██╗ ██████╗ ██╗   ██╗██████╗ ███████╗\n" +
                        "██╔════╝██╔════╝██║   ██║██╔════╝████╗  ██║╚══██╔══╝╚██╗ ██╔╝    ╚══██╔══╝██║    ██║██╔═══██╗    ██║  ██║██╔═══██╗██║   ██║██╔══██╗██╔════╝\n" +
                        "███████╗█████╗  ██║   ██║█████╗  ██╔██╗ ██║   ██║    ╚████╔╝        ██║   ██║ █╗ ██║██║   ██║    ███████║██║   ██║██║   ██║██████╔╝███████╗\n" +
                        "╚════██║██╔══╝  ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║     ╚██╔╝         ██║   ██║███╗██║██║   ██║    ██╔══██║██║   ██║██║   ██║██╔══██╗╚════██║\n" +
                        "███████║███████╗ ╚████╔╝ ███████╗██║ ╚████║   ██║      ██║          ██║   ╚███╔███╔╝╚██████╔╝    ██║  ██║╚██████╔╝╚██████╔╝██║  ██║███████║\n" +
                        "╚══════╝╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝      ╚═╝          ╚═╝    ╚══╝╚══╝  ╚═════╝     ╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚══════╝\n" +
                        "                                                                                                                                           \n";


        System.out.println(TextColor.RED+menu + titleBanner + menu);
        sleep(1000);
        System.out.println( TextColor.WHITE+bundle.getString("title_screen") +TextColor.RESET);
        while (true) {
            String intro = scanner.next();
            for (int i = 0; i < 70; ++i) System.out.println();
            if (intro.equalsIgnoreCase("play")) {
                System.out.println(TextColor.WHITE + bundle.getString("start_game"));
                sleep(1000);
                break;
            } else if (intro.equalsIgnoreCase("help")) {
                System.out.println(TextColor.RED + infoMenu + "\n" + infoBanner + infoMenu);
                System.out.println(TextColor.WHITE +bundle.getString("help_intro"));
                System.out.println(TextColor.WHITE +bundle.getString("help_menu"));
                System.out.println(TextColor.YELLOW+bundle.getString("press_enter2")+TextColor.RESET);
                String readString = scanner.nextLine();
                if (scanner.hasNextLine()) {
                    for (int i = 0; i < 70; ++i) System.out.println();
                    titleScreen();
                    break;
                }
            } else if (intro.equalsIgnoreCase("music")) {
                Music.playerSelectMusic();
                sleep(700);
                titleScreen();
                break;
            } else if (intro.equalsIgnoreCase("quit")) {
                System.out.println(TextColor.WHITE+bundle.getString("quit_menu1"));
                sleep(1000);
                System.exit(0);
            } else {
                System.out.println(TextColor.RED+bundle.getString("invalid_input3"));
                sleep(1600);
                titleScreen();
                break;
            }

        }
    }

    public void titleScreen(JPanel_GameOutput gameOutputPanel, JPanel_UserInput userInputPanel) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        gameOutputPanel.clearGameTextArea();

        String titleBanner =

                "\n███████╗███████╗██╗   ██╗███████╗███╗   ██╗████████╗██╗   ██╗    ████████╗██╗    ██╗ ██████╗     ██╗  ██╗ ██████╗ ██╗   ██╗██████╗ ███████╗\n" +
                        "██╔════╝██╔════╝██║   ██║██╔════╝████╗  ██║╚══██╔══╝╚██╗ ██╔╝    ╚══██╔══╝██║    ██║██╔═══██╗    ██║  ██║██╔═══██╗██║   ██║██╔══██╗██╔════╝\n" +
                        "███████╗█████╗  ██║   ██║█████╗  ██╔██╗ ██║   ██║    ╚████╔╝        ██║   ██║ █╗ ██║██║   ██║    ███████║██║   ██║██║   ██║██████╔╝███████╗\n" +
                        "╚════██║██╔══╝  ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║     ╚██╔╝         ██║   ██║███╗██║██║   ██║    ██╔══██║██║   ██║██║   ██║██╔══██╗╚════██║\n" +
                        "███████║███████╗ ╚████╔╝ ███████╗██║ ╚████║   ██║      ██║          ██║   ╚███╔███╔╝╚██████╔╝    ██║  ██║╚██████╔╝╚██████╔╝██║  ██║███████║\n" +
                        "╚══════╝╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝      ╚═╝          ╚═╝    ╚══╝╚══╝  ╚═════╝     ╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚══════╝\n" +
                        "                                                                                                                                           \n";


        gameOutputPanel.appendGameTextArea(titleBanner);
        sleep(1000);
        gameOutputPanel.appendGameTextArea(TextColor.WHITE+bundle.getString("title_screen") +TextColor.RESET);

        JPanel_UserInput.getUserInputTextField().addActionListener(e -> {
            gameOutputPanel.clearGameTextArea();
            String intro = JPanel_UserInput.getUserInputTextField().getText();
            JPanel_UserInput.getUserInputTextField().setText("");

            try {
                if (intro.equalsIgnoreCase("play")) {
                    gameOutputPanel.appendGameTextArea(TextColor.WHITE + bundle.getString("start_game"));
                    sleep(1000);

                } else if (intro.equalsIgnoreCase("help")) {
                    gameOutputPanel.clearGameTextArea();
                    gameOutputPanel.appendGameTextArea(TextColor.RED + infoMenu + "\n" + infoBanner + infoMenu);
                    gameOutputPanel.appendGameTextArea(TextColor.WHITE +bundle.getString("help_intro"));
                    gameOutputPanel.appendGameTextArea(TextColor.WHITE +bundle.getString("help_menu"));
                    gameOutputPanel.appendGameTextArea(TextColor.YELLOW+bundle.getString("press_enter2")+TextColor.RESET);
                } else if (intro.equalsIgnoreCase("music")) {
                    Music.playerSelectMusic();
                    sleep(700);
                    titleScreen();
                } else if (intro.equalsIgnoreCase("quit")) {
                    gameOutputPanel.appendGameTextArea(TextColor.WHITE+bundle.getString("quit_menu1"));
                    sleep(1000);
                    System.exit(0);
                } else if (intro.equalsIgnoreCase("")) {
                    gameOutputPanel.clearGameTextArea();
                    gameOutputPanel.appendGameTextArea(titleBanner);
                    sleep(1000);
                    gameOutputPanel.appendGameTextArea(TextColor.WHITE+bundle.getString("title_screen") +TextColor.RESET);
                } else {
                    gameOutputPanel.appendGameTextArea(TextColor.RED+bundle.getString("invalid_input3"));
                    sleep(1600);
                }
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void selectDifficulty() {
        while (true) {
            for (int i = 0; i < 70; ++i) System.out.println();
//            System.out.println(bundle.getString("select_level"));
            System.out.println(TextColor.WHITE + "Select a difficulty: " + TextColor.GREEN + "Easy, "
                    + TextColor.RESET + TextColor.BLUE + "Medium, " + TextColor.RESET + TextColor.YELLOW + "Hard, " + TextColor.RED + "Impossible."+TextColor.RESET);

            for (int i = 0; i < 3; ++i) System.out.println();
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("easy")) {
                System.out.println(TextColor.GREEN + bundle.getString("level_easy"));
                difficulty = 0;
                sleep(1000);
            } else if (choice.equalsIgnoreCase("medium")) {
                System.out.println(TextColor.BLUE + bundle.getString("level_medium"));
                sleep(1000);
                difficulty = 4;
            } else if (choice.equalsIgnoreCase("hard")) {
                System.out.println(TextColor.YELLOW +bundle.getString("level_hard"));
                sleep(1000);
                difficulty = 7;
            } else if (choice.equalsIgnoreCase("impossible")) {
                System.out.println(TextColor.RED + bundle.getString("level_impossible"));
                sleep(1000);
                difficulty = 11;
            } else {
                System.out.println(TextColor.RED+bundle.getString("invalid_input4"));
                sleep(1500);
                continue;
            }
            for (int i = 0; i < 70; ++i) System.out.println();
            break;
        }

    }

    public void selectDifficulty(JPanel_GameOutput gameOutputPanel, JPanel_UserInput userInputPanel) {
        gameOutputPanel.clearGameTextArea();
        gameOutputPanel.appendGameTextArea(TextColor.WHITE + "Select a difficulty: " + TextColor.GREEN + "Easy, "
                + TextColor.RESET + TextColor.BLUE + "Medium, " + TextColor.RESET + TextColor.YELLOW + "Hard, " + TextColor.RED + "Impossible." + TextColor.RESET);

        JPanel_UserInput.getUserInputTextField().addActionListener(e -> {
            gameOutputPanel.clearGameTextArea();
            String intro = JPanel_UserInput.getUserInputTextField().getText();
            JPanel_UserInput.getUserInputTextField().setText("");

            if (intro.equalsIgnoreCase("easy")) {
                gameOutputPanel.appendGameTextArea(TextColor.GREEN + bundle.getString("level_easy"));
                difficulty = 0;
                sleep(1000);
            } else if (intro.equalsIgnoreCase("medium")) {
                gameOutputPanel.appendGameTextArea(TextColor.BLUE + bundle.getString("level_medium"));
                sleep(1000);
                difficulty = 4;
            } else if (intro.equalsIgnoreCase("hard")) {
                gameOutputPanel.appendGameTextArea(TextColor.YELLOW + bundle.getString("level_hard"));
                sleep(1000);
                difficulty = 7;
            } else if (intro.equalsIgnoreCase("impossible")) {
                gameOutputPanel.appendGameTextArea(TextColor.RED + bundle.getString("level_impossible"));
                sleep(1000);
                difficulty = 11;
            } else {
                gameOutputPanel.appendGameTextArea(TextColor.RED + bundle.getString("invalid_input4"));
                sleep(1500);
            }
        });
    }

    //Same as "Map" I don't remember seeing this during game play
    public void introText() {

        String storyBanner =
                "███████╗████████╗ ██████╗ ██████╗ ██╗   ██╗██╗     ██╗███╗   ██╗███████╗\n" +
                "██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝██║     ██║████╗  ██║██╔════╝\n" +
                "███████╗   ██║   ██║   ██║██████╔╝ ╚████╔╝ ██║     ██║██╔██╗ ██║█████╗  \n" +
                "╚════██║   ██║   ██║   ██║██╔══██╗  ╚██╔╝  ██║     ██║██║╚██╗██║██╔══╝  \n" +
                "███████║   ██║   ╚██████╔╝██║  ██║   ██║   ███████╗██║██║ ╚████║███████╗\n" +
                "╚══════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝╚═╝  ╚═══╝╚══════╝\n" +
                "                                                                        \n";

        while (true) {
            for (int i = 0; i < 70; ++i) System.out.println();

            String menu = "========================================================================\n";
            System.out.println(TextColor.RED +"\n" + menu + "\n" + storyBanner + menu);
            System.out.println(TextColor.WHITE+bundle.getString("intro_text1") +TextColor.RESET);
            for (int i = 0; i < 5; ++i) System.out.println();
            String intro = scanner.next();
            if (intro.equalsIgnoreCase("skip")) {

                System.out.println(TextColor.WHITE+bundle.getString("skip_intro"));
                sleep(1425);
                System.out.println(TextColor.WHITE+bundle.getString("start_game"));
                sleep(1425);
                for (int i = 0; i < 70; ++i) System.out.println();
                break;
            } else if (intro.equalsIgnoreCase("read")) {
                for (int i = 0; i < 70; ++i) System.out.println();
                System.out.println(TextColor.YELLOW+bundle.getString("press_enter"));
                sleep(1000);
                runThread();
                while (true) {
                    String readString = scanner.nextLine();
                    if (scanner.hasNextLine()) {
                        isRunning = false;
                        break;
                    }
                }
                sleep(100);
                System.out.println(TextColor.WHITE+bundle.getString("start_game"));
                sleep(425);
                for (int i = 0; i < 70; ++i) System.out.println();
                break;
            } else {
                System.out.println(TextColor.RED+bundle.getString("invalid_input2"));
                sleep(1500);
            }
        }
    }

    public void introText(JPanel_GameOutput gameOutputPanel, JPanel_UserInput userInputPanel) {
        gameOutputPanel.clearGameTextArea();

        String storyBanner =
                "███████╗████████╗ ██████╗ ██████╗ ██╗   ██╗██╗     ██╗███╗   ██╗███████╗\n" +
                        "██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝██║     ██║████╗  ██║██╔════╝\n" +
                        "███████╗   ██║   ██║   ██║██████╔╝ ╚████╔╝ ██║     ██║██╔██╗ ██║█████╗  \n" +
                        "╚════██║   ██║   ██║   ██║██╔══██╗  ╚██╔╝  ██║     ██║██║╚██╗██║██╔══╝  \n" +
                        "███████║   ██║   ╚██████╔╝██║  ██║   ██║   ███████╗██║██║ ╚████║███████╗\n" +
                        "╚══════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝╚═╝  ╚═══╝╚══════╝\n" +
                        "                                                                        \n";

        String menu = "========================================================================\n";
        gameOutputPanel.appendGameTextArea(TextColor.RED + "\n" + menu + "\n" + storyBanner + menu);
        gameOutputPanel.appendGameTextArea(TextColor.WHITE + bundle.getString("intro_text1") + TextColor.RESET);

        JPanel_UserInput.getUserInputTextField().addActionListener(e -> {
            gameOutputPanel.clearGameTextArea();
            String intro = JPanel_UserInput.getUserInputTextField().getText();
            JPanel_UserInput.getUserInputTextField().setText("");
            if (intro.equalsIgnoreCase("skip")) {
                gameOutputPanel.appendGameTextArea(TextColor.WHITE + bundle.getString("skip_intro"));
                sleep(1425);
                gameOutputPanel.appendGameTextArea(TextColor.WHITE + bundle.getString("start_game"));
                sleep(1425);
            } else if (intro.equalsIgnoreCase("read")) {
                gameOutputPanel.appendGameTextArea(TextColor.YELLOW + bundle.getString("press_enter"));
                sleep(1000);
                gameOutputPanel.appendGameTextArea(TextColor.WHITE + bundle.getString("storyline"));
                sleep(100);
                gameOutputPanel.appendGameTextArea(TextColor.WHITE + bundle.getString("start_game"));
                sleep(425);
            } else {
                gameOutputPanel.appendGameTextArea(TextColor.RED + bundle.getString("invalid_input2"));
                sleep(1500);
            }
        });
    }

    public void runThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    storyline(TextColor.WHITE+bundle.getString("storyline"), 120);

                    if (isRunning) {
                        sleep(700);
                        System.out.println(TextColor.YELLOW+bundle.getString("press_enter1"));
                    }
                    break;
                }
            }
        });
        thread.start();
    }

    private String textStream(String text, int speed) {
        for (int i = 0; i < text.length(); i++) {
            System.out.printf("%c", text.charAt(i));
            sleep(speed);
        }
        return text;
    }

    private void storyline(String text, int speed) {
        for (int i = 0; i < text.length(); i++) {
            System.out.printf("%c", text.charAt(i));
            if (!isRunning) {
                try {
                    Thread.currentThread().interrupt();
                    break;
                } catch (Exception ignored) {
                    break;
                }
            }
            sleep(speed);
        }
    }

    private void sleep(int timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException ignored) {
        }
    }
}

