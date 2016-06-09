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

    public InventoryManager(String path) {
        JSONParser parser = new JSONParser();

        // Try to load JSON file with all items in it
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

    /**
     * Finds the item with the passed ID and if it exists returns it.
     *
     * @param itemID A String containing the id of the item to be returned.
     * @return The JSONObject of the requested item.
     */
    public JSONObject getItemByID(String itemID) {
        return null;
    }

    /**
     * Finds the item with the passed ID and if it exists adds it to the inventory.
     *
     * @param itemID A String containing the id of the item to be added.
     */
    public void addItem(String itemID) {
        JSONObject item = getItemByID(itemID);
        if (item != null) {
            inventory.add(item);
        }
    }
}
