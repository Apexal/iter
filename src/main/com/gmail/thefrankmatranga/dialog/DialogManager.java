package com.gmail.thefrankmatranga.dialog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

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
        return (JSONObject) narration.get(id);
    }


    /**
     * @return The JSONObject of the current dialog line.
     */
    public JSONObject getCurrent() {
        return getDialogByID(currentID);
    }

    /**
     * Sets the current dialogue line by line id.
     *
     * @param id The new line's id.
     */
    public void setCurrent(String id) {
        currentID = id;
    }

    /**
     * Checks whether a dialogue line with the passed id exists.
     *
     * @param id
     * @return Whether the line exists or not.
     */
    public boolean checkExists(String id) {
        return getDialogByID(id) != null;
    }
}