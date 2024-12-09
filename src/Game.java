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
    private int points;
    private Player handWin;

    // Constructor
    public Game()
    {
        // Make a deck for the game
        deck = new Deck(this.ranks, this.suits, this.values);
        deck.shuffle();
        players = new ArrayList<Player>();
        Scanner s1 = new Scanner(System.in);
        // Get the players in the games name
        System.out.println("What is the name of player 1? Make sure all the names are different.");
        players.add(new Player(s1.nextLine()));
        String player1 = players.get(0).getName();
        System.out.println("What is the name of player 2? Make sure all the names are different.");
        players.add(new Player(s1.nextLine()));
        String player2 = players.get(1).getName();
        System.out.println("What is the name of player 3? Make sure all the names are different.");
        players.add(new Player(s1.nextLine()));
        String player3 = players.get(2).getName();
        System.out.println("What is the name of player 4? Make sure all the names are different.");
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
        // Tell each player what their card are
        System.out.println(player1 + "'s hand is: " + players.get(0).getHand());
        System.out.println(player2 + "'s hand is: " + players.get(1).getHand());
        System.out.println(player3 + "'s hand is: " + players.get(2).getHand());
        System.out.println(player4 + "'s hand is: " + players.get(3).getHand());
        // Asks which player starts the game
        System.out.println("\nWhich player has the 2 of Clubs? (Enter a number 1-4)");
        counter = s1.nextInt() - 1;
        // Have the first player play the 2 of Clubs
        System.out.println(("It is " + players.get(counter).getName()) + "'s turn. You have to play the 2 of Clubs. What index is it at?");
        idx = s1.nextInt();
        this.max = 2;
        this.handWin = players.get(counter);
        this.points = 0;
        players.get(counter).removeCard(idx);
        // Have the other 3 players take there turns
        cardWin = new Card("2","Clubs", 2);
        this.suit = "Clubs";
        System.out.println("You played " + players.get(counter).getHand(idx));
        System.out.println("It is " + players.get(getTurn()).getName() + "'s turn. Choose a card to play by the index " +
                "of the card, the first card is 0. This is your hand: " + players.get(counter).getHand());
        idx = s1.nextInt();
        System.out.println("You played " + players.get(counter).getHand(idx));
        this.max = checkMax(players.get(counter).getHand(idx), players.get(counter));
        this.points += getPoints(players.get(counter).getHand(idx));
        players.get(counter).removeCard(idx);
        System.out.println("It is " + players.get(getTurn()).getName() + "'s turn. Choose a card to play by the index " +
                "of the card, the first card is 0. This is your hand: " + players.get(counter).getHand());
        idx = s1.nextInt();
        System.out.println("You played " + players.get(counter).getHand(idx));
        this.max = checkMax(players.get(counter).getHand(idx), players.get(counter));
        this.points += getPoints(players.get(counter).getHand(idx));
        players.get(counter).removeCard(idx);
        System.out.println("It is " + players.get(getTurn()).getName() + "'s turn. Choose a card to play by the index " +
                "of the card, the first card is 0. This is your hand: " + players.get(counter).getHand());
        idx = s1.nextInt();
        System.out.println("You played " + players.get(counter).getHand(idx));
        // Find the winner of the hand and give them points
        this.max = checkMax(players.get(counter).getHand(idx), players.get(counter));
        this.points += getPoints(players.get(counter).getHand(idx));
        players.get(counter).removeCard(idx);
        this.handWin.addPoints(points);
        counter = getStart(handWin);
        System.out.println("The winner of the hand was the " + cardWin);
        round++;
        // Until all of the rounds are over
        while (!gameOver())
        {
            // Tell the user whos turn it is and have them choose a card to play
            this.points = 0;
            System.out.println("It is " + this.handWin.getName() + "'s turn. Choose a card to play by the index " +
                    "of the card, the first card is 0. This is your hand: " + players.get(counter).getHand());
            idx = s1.nextInt();
            System.out.println("You played " + players.get(counter).getHand(idx));
            // Set the winning card to the card just played
            cardWin = new Card(players.get(counter).getHand(idx).getRank(), players.get(counter).getHand(idx).getSuit(), players.get(counter).getHand(idx).getValue());
            this.max = cardWin.getValue();
            this.suit = cardWin.getSuit();
            this.points += getPoints(players.get(counter).getHand(idx));
            players.get(counter).removeCard(idx);
            // Ask the second player for there card
            System.out.println("It is " + players.get(getTurn()).getName() + "'s turn. Choose a card to play by the index " +
                    " of the card, the first card is 0. This is your hand: " + players.get(counter).getHand());
            idx = s1.nextInt();
            System.out.println("You played " + players.get(counter).getHand(idx));
            // Adjust the winning card accordingly
            this.max = checkMax(players.get(counter).getHand(idx), players.get(counter));
            this.points += getPoints(players.get(counter).getHand(idx));
            players.get(counter).removeCard(idx);
            // Ask the third player for there card
            System.out.println("It is " + players.get(getTurn()).getName() + "'s turn. Choose a card to play by the index " +
                    " of the card, the first card is 0. This is your hand: " + players.get(counter).getHand());
            idx = s1.nextInt();
            System.out.println("You played " + players.get(counter).getHand(idx));
            // Adjust the winning card accordingly
            this.max = checkMax(players.get(counter).getHand(idx), players.get(counter));
            this.points += getPoints(players.get(counter).getHand(idx));
            players.get(counter).removeCard(idx);
            // Ask the fourth player for there card
            System.out.println("It is " + players.get(getTurn()).getName() + "'s turn. Choose a card to play by the index " +
                    " of the card, the first card is 0. This is your hand: " + players.get(counter).getHand());
            idx = s1.nextInt();
            System.out.println("You played " + players.get(counter).getHand(idx));
            // Adjust the winning card accordingly
            this.max = checkMax(players.get(counter).getHand(idx), players.get(counter));
            this.points += getPoints(players.get(counter).getHand(idx));
            players.get(counter).removeCard(idx);
            this.handWin.addPoints(points);
            counter = getStart(handWin);
            // Tell the players who won the hand
            System.out.println("The winner of the hand was the " + cardWin);
            round++;
        }
        // Print out the winning scores and if someone "shot the moon" give everyone else 26 points
        for (int i = 0; i < 4; i++)
        {
            if (players.get(i).getPoints() == 26)
            {
                players.get(0).setPoints(26);
                players.get(1).setPoints(26);
                players.get(2).setPoints(26);
                players.get(3).setPoints(26);
                players.get(i).setPoints(0);
                break;
            }
        }
        System.out.println(players.get(0).getName() + " had " + players.get(0).getPoints() + " points");
        System.out.println(players.get(1).getName() + " had " + players.get(1).getPoints() + " points");
        System.out.println(players.get(2).getName() + " had " + players.get(2).getPoints() + " points");
        System.out.println(players.get(3).getName() + " had " + players.get(3).getPoints() + " points");
        System.out.println("\nCongrats on finishing the game!!!");
    }

    // Get the player that starts the next round
    public int getStart(Player p)
    {
        for (int i = 0; i < 4; i++)
        {
            if (p.getName().equals(players.get(i).getName()))
            {
                return i;
            }
        }
        return 0;
    }

    // Get the points that were given in the round
    public int getPoints(Card card)
    {
        if (card.getSuit().equals("Hearts"))
        {
            return 1;
        }
        else if (card.getSuit().equals("Spades") && card.getRank().equals("Q"))
        {
            return 13;
        }
        return 0;
    }

    // See if the played card is the biggest in the round
    public int checkMax(Card card, Player p)
    {
        if (card.getValue() > max)
        {
            if (suit.equals(card.getSuit()))
            {
                this.handWin = p;
                this.max = card.getValue();
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

    // Print instructions
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

    // Create the game in the main function
    public static void main(String[] args)
    {
        printInstructions();
        Game game = new Game();
    }
}