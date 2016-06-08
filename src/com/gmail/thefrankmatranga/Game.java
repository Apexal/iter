package com.gmail.thefrankmatranga;

import com.gmail.thefrankmatranga.entities.*;
import com.gmail.thefrankmatranga.rooms.*;

import java.util.Scanner;

public class Game {
    private Scanner userInput;
    private Player player;
    
    private DialogManager;
    
    private Room currentRoom;
    
    public Game() {
        userInput = new Scanner(System.in);
        System.out.println("What's your name?");
        player = new Player(userInput.nextLine());
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.getPlayer());
    }
}