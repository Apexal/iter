import entities.*;
import java.util.Scanner;

public class Game {
    
    private Scanner userInput;
    private Player player;
    
    
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