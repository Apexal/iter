package com.gmail.thefrankmatranga;

import com.gmail.thefrankmatranga.dialog.DialogManager;
import com.gmail.thefrankmatranga.entities.Player;
import com.gmail.thefrankmatranga.items.InventoryManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Game {
    // Folder containing JSON files
    private final String resourcePath = "/home/frank/Documents/iter/src/main/resources/";

    private Scanner userInput;
    private Player player;
    private DialogManager dialogManager;
    private InventoryManager inventory;
    private boolean running = true;

    public Game() {
        // Start the necessary components
        System.out.print("Initializing game... ");
        dialogManager = new DialogManager(resourcePath);
        inventory = new InventoryManager(resourcePath);
        System.out.println("Done.");

        // Get info on user that will decide game
        System.out.println("What is your name?");
        userInput = new Scanner(System.in);
        String name = userInput.nextLine();

        System.out.println("What do you desire from Regis?");
        String desire = userInput.nextLine();
        player = new Player(name, desire);
    }

    public static void main(String[] args) {
        // Used to determine playtime
        long startTime = System.currentTimeMillis();

        Game game = new Game();
        game.loop();

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        System.out.println("Thanks for playing! Playtime: " + elapsedTime / 1000.0 + " seconds");
    }

    /**
     * Prints out the current line of dialog and the numbered response options.
     *
     * @return Nothing
     */
    public void printCurrentDialog() {
        JSONObject current = dialogManager.getCurrent();
        String message = (String) current.get("message");
        JSONArray options = (JSONArray) current.get("options");

        // Prints out the dialogue line to start
        System.out.println(message);
        Iterator<JSONObject> iterator = options.iterator();
        while (iterator.hasNext()) {
            JSONObject option = iterator.next();

            // Adds 1 since index 0 is option 1
            int choiceNumber = options.indexOf(option) + 1;
            String choiceMessage = (String) option.get("message");

            System.out.println(choiceNumber + ") " + choiceMessage);
        }
    }

    public void handleOption(int choice) {
        JSONObject current = dialogManager.getCurrent();
        JSONArray options = (JSONArray) current.get("options");

        JSONObject chosen = null;

        int index = (choice - 1);
        // Make sure requested option exists
        if (index >= 0 && index < options.size()) {
            chosen = (JSONObject) options.get(index);
        } else {
            System.out.println("Not a choice!");
            return;
        }

        if (chosen.get("action") == null) {
            System.out.println("Action doesn't exist!");
            return;
        }

        // Splitting at ; allows for multiple actions to be carried out for one response choice
        String[] actions = ((String) chosen.get("action")).split(";");
        for (int i = 0; i < actions.length; i++) {
            String[] parts = actions[i].split(" ");

            String action = parts[0];
            String[] args = null;
            if (parts.length > 1) {
                // Get a subarray from parts to get the list of arguments
                args = Arrays.copyOfRange(parts, 1, parts.length);
            }
            System.out.println(args[0]);
            doAction(action, args);
        }
    }

    /**
     * Based on the passed action and arguments completes the correct steps, such as setting dialogue, adding item, etc.
     *
     * @param action The action type.
     * @param args   (Optional) The list of arguments to complete the action with.
     */
    public void doAction(String action, String[] args) {
        switch (action) {
            case "end_game":
                // End the game early
                System.out.println("You chose to end the adventure early. The End.");
                running = false;
                break;
            case "dialog":
                // Change current dialogue line
                if (args.length > 0 && dialogManager.checkExists(args[0])) {
                    dialogManager.setCurrent(args[0]);
                } else {
                    System.out.println("Dialogue error!");
                }
                break;
            default:
                System.out.println("Unknown action '" + action + "'?");
        }
    }

    public void loop() {
        while (running) {
            System.out.println("\n--------------");
            printCurrentDialog();
            System.out.print(">");
            handleOption(userInput.nextInt());
            waitForTime(1000);
        }
    }

    public void waitForTime(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}