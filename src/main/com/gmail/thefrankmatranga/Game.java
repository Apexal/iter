package com.gmail.thefrankmatranga;

import com.gmail.thefrankmatranga.entities.*;
import com.gmail.thefrankmatranga.dialog.*;

import java.util.Scanner;

public class Game {
    private Scanner userInput;
    private Player player;
    
    private DialogManager dialogManager;

    private boolean running = true;

    public Game() {
        userInput = new Scanner(System.in);
        System.out.print("Initializing game... ");
        dialogManager = new DialogManager();
        System.out.println("Done.");

        System.out.println("What is your name?");
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