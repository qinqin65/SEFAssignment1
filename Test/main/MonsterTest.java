package main;

import static org.junit.Assert.*;

import org.junit.*;

public class MonsterTest {
	Grid grid;
	Player player;
	Monster monster;
	Cell c;
	Cell c1;
	char currentDirection;
	Cell currentCell;

	@Before
	public void setUp() throws Exception {
		grid = new Grid();
		player = new Player(grid, 0, 0);
		monster = new Monster(grid, player, 0, 0);
		c = new Cell(0, 0);
		c1 = new Cell(1, 0);
		currentCell = new Cell(0, 0);
		//currentDirection = new Cell(0, 0);
		
	}

	@Test
	public void test() {
		player.setCell(c);
		player.getCell();
		monster.setCell(c1);
		monster.getCell();
		//player.setDirection('R');
		//player.getDirection();
		currentDirection = grid.getBestDirection(c1, c);
		//currentCell = (grid.getCell(player.getCell(), player.getDirection()));
		assertEquals(1, currentDirection);
	}

}
