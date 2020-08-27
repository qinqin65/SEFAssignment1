import Game.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class KeyBoardTest {
    Map map;
    Player players[];
    Monster monster;
    Board gameBoard;
    KeyBoard keyBoard;

    @Before
    public void setUp() {
        map = new Map();
        players = new Player[]{ new Player(map, 0, 0) };
        monster = new Monster(map, players, 5, 5);
        gameBoard = new Board(map, players, monster);
        keyBoard = new KeyBoard();
        keyBoard.keyBoardListener(gameBoard);
        keyBoard.keyEventRegister(gameBoard);
    }

    @Test
    public void getKey() {
        Assert.assertEquals("left", keyBoard.getKey(37));
        Assert.assertEquals("up", keyBoard.getKey(38));
        Assert.assertEquals("right", keyBoard.getKey(39));
        Assert.assertEquals("down", keyBoard.getKey(40));
        Assert.assertNull(keyBoard.getKey(49));
    }
}