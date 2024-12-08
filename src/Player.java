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
        this.hand = new ArrayList<Card>();
    }

    // Getters
    public ArrayList<Card> getHand() {
        return hand;
    }

    public Card getHand(int idx) {
        return hand.get(idx);
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points)
    {
        this.points = points;
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

    public void removeCard(int idx)
    {
        this.hand.remove(idx);
    }

    public String toString()
    {
        return this.name + " has " + this.points + " points \n" + this.name + "'s cards: " + this.hand;
    }
}

