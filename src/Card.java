public class Card {
    // Instance Variables
    private String rank;
    private String suit;
    private int value;

    // Constructors
    public Card(String rank, String suit, int value)
    {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    // Getters and Setters
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // toString Method
    public String toString()
    {
        return  rank + " of " + suit;
    }
}
