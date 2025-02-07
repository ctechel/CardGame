import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame
{
    private Image[] cardImages;
    private final int WINDOW_WIDTH = 1600;
    private final int WINDOW_HEIGHT = 900;
    private final int TITLE_BAR_HEIGHT = 23;
    private Game game;
    public GameView(Game game)
    {
        this.game = game;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Hearts");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {

    }
}
