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
	Moveable mv;

	@Before
	public void setUp() throws Exception {
		grid = new Grid();
		player = new Player(grid, 0, 0);
		monster = new Monster(grid, player, 0, 0);
		c = new Cell(0, 0);
		c1 = new Cell(1, 0);
		currentCell = new Cell(0, 0);
		mv = new Moveable(grid) {
			@Override
			public Cell move() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	@Test
	public void test() {
		player.setCell(c);
		player.getCell();
		mv.setCell(c1);
		mv.getCell();
		mv.setDirection('R');
		mv.getDirection();
		currentDirection = grid.getBestDirection(mv.getCell(), player.getCell());
		currentCell = grid.getCell(mv.getCell(), mv.getDirection());
		assertEquals(mv.getDirection(),currentDirection);
	}

}
