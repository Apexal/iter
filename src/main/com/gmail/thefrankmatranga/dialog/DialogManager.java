package com.gmail.thefrankmatranga.dialog;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

public class DialogManager {
    private JSONObject narration;
    private String currentID = "start_message";

    public DialogManager(String path) {
        JSONParser parser = new JSONParser();

        try {
            narration = (JSONObject) parser.parse(new FileReader(path + "dialog/narration.json"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        System.out.print("Loaded " + narration.size() + " dialog trees... ");
    }

    public JSONObject getDialogByID(String id) {
        return (JSONObject)narration.get(id);
    }

    public void printCurrentDialog() {
        JSONObject current = getDialogByID(currentID);
        String message = (String)current.get("message");
        JSONArray options = (JSONArray)current.get("options");

        System.out.println(message);
        Iterator<JSONObject> iterator = options.iterator();
        while (iterator.hasNext()) {
            JSONObject option = (JSONObject)iterator.next();
            int choiceNumber = options.indexOf(option) + 1;
            String choiceMessage = (String)option.get("message");

            System.out.println(choiceNumber + ") " + choiceMessage);
        }
    }

    public void handleOption(int choice) {
        JSONObject current = getDialogByID(currentID);
        JSONArray options = (JSONArray)current.get("options");

        JSONObject chosen = null;

        int index = (choice-1);
        if(index >= 0 && index < options.size()) {
            chosen = (JSONObject)options.get(index);
        }else{
            System.out.println("Not a choice!");
            return;
        }

        String[] action = ((String)chosen.get("action")).split(" ");
        switch (action[0]) {
            case "end_game":
                System.out.println("You chose to end the adventure early. The End.");
                System.exit(0);
                break;
            case "dialog":
                if(action.length > 1){
                    if(getDialogByID(action[1]) != null){
                        currentID = action[1];
                    }
                }
                break;
            default:
                System.out.println("Big error with dialogue! What is " + action[0] + "?");
        }
    }
}