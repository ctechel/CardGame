import java.util.ArrayList;

public class Deck {
    // Instance Variables
    private ArrayList<Card> cards;
    private int cardsLeft;

    // Constructors
    public Deck(String[] ranks, String[] suits, int[] values)
    {
        cards = new ArrayList<Card>();
        for (int i = 0; i < ranks.length; i++)
        {
            for (int j = 0; j < suits.length; j++)
            {
                cards.add(new Card(ranks[i], suits[j], values[i]));
            }
        }
        this.cardsLeft = cards.size();
    }

    // Check if the deck is empty
    public boolean isEmpty()
    {
        if (cardsLeft == 0)
        {
            return true;
        }
        return false;
    }

    // Getters
    public int getCardsLeft() {
        return cardsLeft;
    }

    // Deal a card
    public Card deal()
    {
        if (cardsLeft == 0)
        {
            return null;
        }
        else
        {
            return cards.get((int)(Math.random() * cardsLeft));
        }
    }

    // Shuffle the deck
    public void shuffle()
    {
        for (int i = cardsLeft - 1; i >= 0; i--)
        {
            int random = (int) (Math.random() * i);
            Card temp = cards.get(i);
            cards.set(i, cards.get(random));
            cards.set(random, temp);
        }
    }
}
