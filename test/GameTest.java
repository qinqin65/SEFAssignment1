import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;

public class GameTest {
    private Game newGame;

    @Before
    public void setUp() {
        newGame = new Game();
        newGame.setTitle("Pacman Game");
        newGame.setSize(700,700);
    }

    @Test
    public void Game() {
        Assert.assertEquals("Pacman Game", newGame.getTitle());
        Dimension d = newGame.getSize();
        Assert.assertEquals(700, d.width);
        Assert.assertEquals(700, d.height);
    }
}