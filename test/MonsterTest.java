import Game.*;
import static org.junit.Assert.*;

import org.junit.*;

public class MonsterTest {
	Map grid;
	Player players[];
	Player player;
	Monster monster;
	Position c;
	Position c1;
	char currentDirection;
	Position currentCell;
	Role mv;

	@Before
	public void setUp() throws Exception {
		grid = new Map();
		players = new Player[]{new Player(grid, 0, 0)};
		player = players[0];
		monster = new Monster(grid, players, 0, 0);
		c = new Position(0, 0);
		c1 = new Position(1, 0);
		currentCell = new Position(0, 0);
		mv = new Role() {
			@Override
			public Position move() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	@Test
	public void test() {
		player.setPosition(c);
		player.getPosition();
		mv.setPosition(c1);
		mv.getPosition();
		mv.setDirection('R');
		mv.getDirection();
		currentDirection = (new Monster(grid, players, 5, 5)).getBestDirection(mv.getPosition(), player.getPosition());
		currentCell = grid.getCell(mv.getPosition(), mv.getDirection());
		assertEquals(mv.getDirection(),currentDirection);
	}

}
