package com.gmail.thefrankmatranga.dialog;

//import org.json.simple.*;

public class DialogManager {
    private String currentLine;
    
    private final String dialogDirectory = "res/";
    
    public DialogManager() {
        System.out.println(getClass().getResource("/resources/dialog/narration.json").toString());
    }
    
    public String getLineByID(int id) {
        return "Placeholder line.";
    }
    
    
}