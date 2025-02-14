import java.awt.*;

// Card Game by Carter Techel
public class Card {
    // Instance Variables
    private String rank;
    private String suit;
    private int value;
    private Image image;
    private int xVal;
    private int yVal;
    private GameView window;

    // Constructors
    public Card(String rank, String suit, int value, Image image, GameView window)
    {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        this.image = image;
        this.window = window;
        xVal = 0;
        yVal = 0;
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

    public Image getImage() {
        return image;
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

    // Draw Method
    public void draw(Graphics g, int xVal, int yVal)
    {
        this.xVal = xVal;
        this.yVal = yVal;
        g.drawImage(this.image, xVal, yVal, window);
    }
}
