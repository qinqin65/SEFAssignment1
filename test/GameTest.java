import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class GameTest {
    @Test
    public void Game() {
        Game newGame = new Game();
        newGame.setTitle("Pacman Game");
        newGame.setSize(700,700);
        Assert.assertEquals("Pacman Game", newGame.getTitle());
        Dimension d = newGame.getSize();
        Assert.assertEquals(700, d.width);
        Assert.assertEquals(700, d.height);
    }
}