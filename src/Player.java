import java.util.ArrayList;

public class Player {
    // Instance Variables
    private ArrayList<Card> hand;
    private String name;
    private int points;

    // Constructors


    public Player(ArrayList<Card> hand, String name) {
        this.hand = hand;
        this.name = name;
        this.points = 0;
    }

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    // Getters
    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    // Add points to a players point total
    public void addPoints(int points)
    {
        this.points += points;
    }

    // Add a card to a players hand
    public void addCard(Card card)
    {
        this.hand.add(card);
    }
}

