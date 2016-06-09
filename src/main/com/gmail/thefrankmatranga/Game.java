package com.gmail.thefrankmatranga;

import com.gmail.thefrankmatranga.entities.*;
import com.gmail.thefrankmatranga.dialog.*;
import com.gmail.thefrankmatranga.items.InventoryManager;

import java.util.Scanner;

public class Game {
    private Scanner userInput;
    private Player player;
    
    private DialogManager dialogManager;
    private InventoryManager inventory;

    private boolean running = true;

    private final String resourcePath = "/home/frank/Documents/iter/src/main/resources/";

    public Game() {
        System.out.print("Initializing game... ");
        dialogManager = new DialogManager(resourcePath);
        inventory = new InventoryManager(resourcePath);
        System.out.println("Done.");

        System.out.println("What is your name?");
        userInput = new Scanner(System.in);
        String name = userInput.nextLine();

        System.out.println("What do you desire from Regis?");
        String desire = userInput.nextLine();
        player = new Player(name, desire);
    }

    public void loop() {
        while(running) {
            System.out.println("\n--------------");
            dialogManager.printCurrentDialog();
            System.out.print("> ");
            dialogManager.handleOption(userInput.nextInt());
        }
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        game.loop();

        System.out.println("Thanks for playing!");
    }
}