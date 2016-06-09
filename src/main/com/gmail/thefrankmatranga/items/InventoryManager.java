package com.gmail.thefrankmatranga.items;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by frank on 6/8/16.
 */
public class InventoryManager {
    private JSONObject itemList;

    private ArrayList<JSONObject> inventory;

    public InventoryManager(String path){
        JSONParser parser = new JSONParser();

        try {
            itemList = (JSONObject) parser.parse(new FileReader(path + "items.json"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        inventory = new ArrayList<JSONObject>();

        System.out.print("Loaded " + itemList.size() + " items... ");
    }

    public JSONObject getItemByID(String id) {
        return null;
    }

    public void addItem(String itemID) {
        JSONObject item = getItemByID(itemID);
        if(item != null) { inventory.add(item); }
    }
}
