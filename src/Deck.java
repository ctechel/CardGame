import java.util.ArrayList;

public class Deck {
    // Instance Variables
    private ArrayList<Card> cards;
    private int cardsLeft;

    // Constructors
    public void Deck(int[] ranks, String[] suits, int[] values, int cardsLeft)
    {
        cards = new ArrayList<Card>();
        for (int i = 0; i < ranks.length; i++)
        {
            for (int j = 0; j < suits.length; j++)
            {
                Card card = new Card(ranks[i], suits[j], values[i]);
                cards.add(card);
            }
        }
        this.cardsLeft = cardsLeft;
    }
    // Getters and Setters
}
