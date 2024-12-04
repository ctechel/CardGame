import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // Instance Variable
    private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private int[] values = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private Deck deck;
    private ArrayList<Player> players;
    private int round = 1;
    private int counter = 0;
    private int max;
    private int idx;
    private String suit;
    private Card cardWin;

    // Constructor
    public Game()
    {
        deck = new Deck(this.ranks, this.suits, this.values);
        deck.shuffle();
        players = new ArrayList<Player>();
        Scanner s1 = new Scanner(System.in);
        System.out.println("What is the name of player 1?");
        players.add(new Player(s1.nextLine()));
        String player1 = players.get(0).getName();
        System.out.println("What is the name of player 2?");
        players.add(new Player(s1.nextLine()));
        String player2 = players.get(1).getName();
        System.out.println("What is the name of player 3?");
        players.add(new Player(s1.nextLine()));
        String player3 = players.get(2).getName();
        System.out.println("What is the name of player 4?");
        players.add(new Player(s1.nextLine()));
        String player4 = players.get(3).getName();
        // Give each player a hand
        for (int i = 0; i < 13; i++)
        {
            players.get(0).addCard(deck.deal());
            players.get(1).addCard(deck.deal());
            players.get(2).addCard(deck.deal());
            players.get(3).addCard(deck.deal());
        }
        System.out.println(player1 + "'s hand is: " + players.get(0).getHand());
        System.out.println(player2 + "'s hand is: " + players.get(1).getHand());
        System.out.println(player3 + "'s hand is: " + players.get(2).getHand());
        System.out.println(player4 + "'s hand is: " + players.get(3).getHand());
        System.out.println("\nWhich player has the 2 of Clubs? (Enter a number 1-4)");
        counter = s1.nextInt() - 1;
        System.out.println(("It is " + players.get(counter).getName()) + "'s turn. You have played the 2 of Clubs");
        max = 2;
        cardWin = new Card("2","Clubs", 2);
        suit = "Clubs";
        System.out.println("It is " + players.get(getTurn()).getName() + "'s turn. Choose a card to play by the index " +
                "of the card, the first card is 0. This is your hand: " + players.get(counter).getHand());
        idx = s1.nextInt();
        System.out.println("You played " + players.get(counter).getHand(idx));
        max = checkMax(players.get(counter).getHand(idx));
        System.out.println("It is " + players.get(getTurn()).getName() + "'s turn. Choose a card to play by the index" +
                "of the card, the first card is 0. This is your hand: " + players.get(counter).getHand());
        idx = s1.nextInt();
        System.out.println("You played " + players.get(counter).getHand(idx));
        max = checkMax(players.get(counter).getHand(idx));
        System.out.println("It is " + players.get(getTurn()).getName() + "'s turn. Choose a card to play by the index" +
                "of the card, the first card is 0. This is your hand: " + players.get(counter).getHand());
        idx = s1.nextInt();
        System.out.println("You played " + players.get(counter).getHand(idx));
        max = checkMax(players.get(counter).getHand(idx));
        System.out.println("The winner of the hand was the " + cardWin);
        round++;
        while (!gameOver())
        {
            round++;
        }
    }

    public int checkMax(Card card)
    {
        if (card.getValue() > max)
        {
            if (suit.equals(card.getSuit()))
            {
                max = card.getValue();
                cardWin.setValue(max);
                cardWin.setRank(card.getRank());
            }
        }
        return max;
    }

    // Get whose turn it is
    public int getTurn()
    {
        if (counter < 3)
        {
            counter++;
            return counter;
        }
        else
        {
            counter = 0;
            return 0;
        }
    }

    // Checks if the game is over if all 13 rounds have happened
    public boolean gameOver()
    {
        if (round > 13)
        {
            return true;
        }
        return false;
    }
    // Deals each player an amount of cards

    private static void printInstructions()
    {
        System.out.println("Welcome to Hearts!!! " +
                "Rules: The player holding the 2 of clubs at the start plays first. Each player must follow suit if possible. \n" +
                "If a player is void of the suit led, a card of any other suit may be discarded. However, if a player \n" +
                "has no clubs when the first trick is led, a heart or the queen of spades cannot be discarded. The \n" +
                "highest card of the suit led wins a trick and the winner of that trick leads next. There is no trump \n" +
                "suit. The winner of the trick collects it and places it face down. Hearts may not be led until a heart \n" +
                "or the queen of spades has been discarded. The queen does not have to be discarded at the first \n" +
                "opportunity and can be led at any time. To win you want to have the least amount of points ta the end \n" +
                "of the round. Each heart is worth 1 point and the Queen of Spades is worth 13. If you get all 26 \n" +
                "points in the round you get 0 points and everyone else gets 26. \n");
    }

    public static void main(String[] args)
    {
        printInstructions();
        Game game = new Game();
    }
}
