import Game.*;
import static org.junit.Assert.*;

import org.junit.*;

import org.junit.Test;

public  class PlayerTest {
	Map grid;
	Player players[];
	Player player;
	Position c;
	Role currentCell;
	
	
	@Before
	public void setUp() {
		 
	}
	
	@Before
	public void setMove() throws Exception {
		grid = new Map();
		player = new Player(grid, 0, 0);
		c = new Position(0, 0);
		
	}
	

	@Test
	public void testMove() throws Exception {
		player.setDirection('R');
		player.setPosition(c);
		player.getPosition();
		player.getDirection();
		c = grid.getCell(player.getPosition(), player.getDirection());
		assertEquals(c,player.move());
	}

	@Test
	public void testMaxCellsPerMove() throws Exception {
		Position c1 = new Position(0,0);
		Position c2 = new Position(1,0);
		assertEquals(2,Utils.distance(c1, c2));
	}


	@Test
	public void testSetDirection() {
		char c = 'R';
		Role instance = new Role() {
			@Override
			public Position move() {
				// TODO Auto-generated method stub
				return null;
			}};
		instance.setDirection(c);
		assertEquals(instance.getDirection(), c);
	}

	@Test
	public void testGetDirection() throws Exception {
		Role instance = new Role() {
			@Override
			public Position move() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		char expResult = 'R';
		instance.setDirection('R');
		char result = instance.getDirection();
		assertEquals(expResult, result);
	}

}
