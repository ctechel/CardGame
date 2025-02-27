// Card Game by Carter Techel

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    // Instance Varibales
    private Image[] cardImages;
    private Image background;
    private final int WINDOW_WIDTH = 1500;
    private final int WINDOW_HEIGHT = 900;
    private final int TITLE_BAR_HEIGHT = 23;
    private final int PRINT_X_VAL = 80;
    private final int PRINT_Y_VAL = 225;
    private final int Y_VAL_CHANGE = 50;
    private Game game;

    // Constructor
    public GameView(Game game) {
        this.game = game;
        background = new ImageIcon("Resources/background.jpg").getImage();

        // Initializes my Window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Hearts");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    // Paint method where I draw stuff to window
    public void paint(Graphics g) {
        g.setColor(Color.white);
        // If in first part of game print that screen
        if (game.getState() == 0) {
            g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            paintInstructions(g);
        }
        // If in second part of game print that screen
        else if (game.getState() == 1) {
            g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            paintGame(g);
        }
        // If in third part of game print that screen
        else if (game.getState() == 2) {
            g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            paintEnd(g);
        }
    }

    // Print the instructions to the window
    public void paintInstructions(Graphics g) {
        g.setFont(new Font("Serif", Font.BOLD, 80));
        g.drawString("Instructions", 500, 150);
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("Welcome to Hearts!!! ", PRINT_X_VAL, PRINT_Y_VAL);
        g.drawString("Rules: The player holding the 2 of clubs at the start plays first. Each player must follow suit if possible.", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE));
        g.drawString("If a player is void of the suit led, a card of any other suit may be discarded. However, if a player", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE * 2));
        g.drawString("has no clubs when the first trick is led, a heart or the queen of spades cannot be discarded. The", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE * 3));
        g.drawString("highest card of the suit led wins a trick and the winner of that trick leads next. There is no trump", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE * 4));
        g.drawString("suit. The winner of the trick collects it and places it face down. Hearts may not be led until a heart\"", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE * 5));
        g.drawString("or the queen of spades has been discarded. The queen does not have to be discarded at the first", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE * 6));
        g.drawString("opportunity and can be led at any time. To win you want to have the least amount of points ta the end", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE * 7));
        g.drawString("of the round. Each heart is worth 1 point and the Queen of Spades is worth 13. If you get all 26", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE * 8));
        g.drawString("points in the round you get 0 points and everyone else gets 26.", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE * 9));
        g.setColor(Color.black);
        g.drawString("Input 3 initials for each of the four users names and hit return after each one is entered.", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE * 10));
    }

    // Visualize the game being played on the window
    public void paintGame(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.BOLD, 20));
        // Right all 4 of the player's names onto the window
        g.drawString(game.getPlayers().get(0).getName() + " (0) ", WINDOW_WIDTH / 2 - 50, 200);
        g.drawString(game.getPlayers().get(1).getName() + " (1) ", 200, (WINDOW_HEIGHT - TITLE_BAR_HEIGHT) / 2);
        g.drawString(game.getPlayers().get(2).getName() + " (2) ", WINDOW_WIDTH - 350, (WINDOW_HEIGHT - TITLE_BAR_HEIGHT) / 2);
        g.drawString(game.getPlayers().get(3).getName() + " (3) ", WINDOW_WIDTH / 2 - 50, WINDOW_HEIGHT - TITLE_BAR_HEIGHT - 200);
        int cards = game.getPlayers().get(0).getHand().size();
        // Display each players hands onto the screen
        for (int i = 0; i < game.getPlayers().get(0).getHand().size(); i++) {
            game.getPlayers().get(0).getHand().get(i).draw(g, (i * 60) + ((14 - cards) * 50) + 200, 75);
            game.getPlayers().get(1).getHand().get(i).draw(g, 60, (i * 60) + ((14 - cards) * 50));
            game.getPlayers().get(2).getHand().get(i).draw(g, WINDOW_WIDTH - 150, (i * 60) + ((14 - cards) * 50));
            game.getPlayers().get(3).getHand().get(i).draw(g, (i * 60) + ((14 - cards) * 50) + 200, WINDOW_HEIGHT - 175);
        }
    }

    // Print the final scores of the game
    public void paintEnd(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.BOLD, 90));
        // Show the players names and there scores
        g.drawString(game.getPlayers().get(0).getName() + " had " + game.getPlayers().get(0).getPoints() + " points", PRINT_X_VAL + 300, PRINT_Y_VAL);
        g.drawString(game.getPlayers().get(1).getName() + " had " + game.getPlayers().get(1).getPoints() + " points", PRINT_X_VAL + 300, PRINT_Y_VAL + (Y_VAL_CHANGE * 2));
        g.drawString(game.getPlayers().get(2).getName() + " had " + game.getPlayers().get(2).getPoints() + " points", PRINT_X_VAL + 300, PRINT_Y_VAL + (Y_VAL_CHANGE * 4));
        g.drawString(game.getPlayers().get(3).getName() + " had " + game.getPlayers().get(3).getPoints() + " points", PRINT_X_VAL + 300, PRINT_Y_VAL + (Y_VAL_CHANGE * 6));
        // Tells the users the game is over
        g.drawString("Congrats on finishing the game!!!", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE * 9));
    }
}
