import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // Instance Variable
    private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private int[] values = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private Deck deck;
    private ArrayList<Player> players;

    // Constructor
    public Game()
    {
        deck = new Deck(this.ranks, this.suits, this.values);
        deck.shuffle();
        players = new ArrayList<Player>();
        Scanner s1 = new Scanner(System.in);
        System.out.println("What is the name of player 1?");
        players.add(new Player(s1.nextLine()));
        System.out.println("What is the name of player 2?");
        players.add(new Player(s1.nextLine()));
        System.out.println("What is the name of player 3?");
        players.add(new Player(s1.nextLine()));
        System.out.println("What is the name of player 4?");
        players.add(new Player(s1.nextLine()));
    }

    private static void printInstructions()
    {
        System.out.println("WThe player holding the 2 of clubs after the pass makes the opening lead. If the 2 has been \n" +
                "removed for the three handed game, then the 3 of clubs is led. Each player must follow suit if possible. \n" +
                "If a player is void of the suit led, a card of any other suit may be discarded. However, if a player \n" +
                "has no clubs when the first trick is led, a heart or the queen of spades cannot be discarded. The \n" +
                "highest card of the suit led wins a trick and the winner of that trick leads next. There is no trump \n" +
                "suit. The winner of the trick collects it and places it face down. Hearts may not be led until a heart \n" +
                "or the queen of spades has been discarded. The queen does not have to be discarded at the first \n" +
                "opportunity and can be led at any time. To win you want to have the least amount of points ta the end \n " +
                "of the round. Each heart is worth 1 point and teh Queen of Spades is worth 13. If you get all 26 \n" +
                "points in the round you get 0 points and everyone else gets 26.");
    }

    public static void main(String[] args)
    {
        Game game = new Game();
        game.printInstructions();
    }
}
