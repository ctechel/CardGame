// Card Game by Carter Techel

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Deck {
    // Instance Variables
    private ArrayList<Card> cards;
    private int cardsLeft;
    private GameView window;

    // Constructors
    public Deck(String[] ranks, String[] suits, int[] values, GameView window) {
        cards = new ArrayList<Card>();
        int counter = 1;
        this.window = window;
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                String fileName = "resources/" + counter + ".png";
                Image cardImage = new ImageIcon(fileName).getImage();
                cards.add(new Card(ranks[i], suits[j], values[i], cardImage, window));
                counter++;
            }
        }
        this.cardsLeft = cards.size();
        this.shuffle();
    }

    // Check if the deck is empty
    public boolean isEmpty() {
        if (cardsLeft == 0) {
            return true;
        }
        return false;
    }

    // Getters
    public int getCardsLeft() {
        return cardsLeft;
    }

    // Deal a card
    public Card deal() {
        if (cardsLeft == 0) {
            return null;
        } else {
            this.cardsLeft--;
            return cards.get(cardsLeft);
        }
    }

    // Shuffle the deck
    public void shuffle() {
        for (int i = cardsLeft - 1; i >= 0; i--) {
            int random = (int) (Math.random() * i);
            Card temp = cards.get(i);
            cards.set(i, cards.get(random));
            cards.set(random, temp);
        }
    }
}
