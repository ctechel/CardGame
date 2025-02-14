// Card Game by Carter Techel
import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame
{
    private Image[] cardImages;
    private Image background;
    private final int WINDOW_WIDTH = 1500;
    private final int WINDOW_HEIGHT = 900;
    private final int TITLE_BAR_HEIGHT = 23;
    private final int PRINT_X_VAL = 80;
    private final int PRINT_Y_VAL = 225;
    private final int Y_VAL_CHANGE = 50;
    private Game game;

    public GameView(Game game)
    {
        this.game = game;
        background = new ImageIcon("Resources/background.jpg").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Hearts");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        if (game.getState() == 0)
        {
            g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            paintInstructions(g);
        }
        else if (game.getState() == 1)
        {
            g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            paintGame(g);
        }
    }

    // Print the instructions to the window
    public void paintInstructions(Graphics g)
    {
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
        g.drawString("Input 3 initials each of the four users names and hit return after each one is entered.", PRINT_X_VAL, PRINT_Y_VAL + (Y_VAL_CHANGE * 10));
    }

    // Visualize the game being played on the window
    public void paintGame(Graphics g)
    {
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.BOLD, 20));
        g.drawString(game.getPlayers().get(0).getName() + " (0) ", WINDOW_WIDTH / 2 - 50, 200);
        g.drawString(game.getPlayers().get(1).getName() + " (1) ", 200, (WINDOW_HEIGHT - TITLE_BAR_HEIGHT) / 2);
        g.drawString(game.getPlayers().get(2).getName() + " (2) ", WINDOW_WIDTH - 350,(WINDOW_HEIGHT - TITLE_BAR_HEIGHT) / 2);
        g.drawString(game.getPlayers().get(3).getName() + " (3) ", WINDOW_WIDTH / 2 - 50, WINDOW_HEIGHT - TITLE_BAR_HEIGHT - 200);
    }
}
