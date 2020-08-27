package main;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

import org.junit.Test;

public  class PlayerTest {
	Grid grid;
	Player player;
	Cell c;
	Moveable currentCell;
	
	
	@Before
	public void setUp() {
		 
	}
	
	@Before
	public void setMove() throws Exception {
		grid = new Grid();
		player = new Player(grid, 0, 0);
		c = new Cell(0, 0);
		
	}
	

	@Test
	public void testMove() throws Exception {
		player.setDirection('R');
		player.setCell(c);
		player.getCell();
		player.getDirection();
		c = grid.getCell(player.getCell(), player.getDirection());
		assertEquals(c,player.move());
	}

	@Test
	public void testMaxCellsPerMove() throws Exception {
		Cell c1 = new Cell(0,0);
		Cell c2 = new Cell(1,0);
		assertEquals(2,grid.distance(c1, c2));
	}


	@Test
	public void testSetDirection() {
		char c = 'R';
		Moveable instance = new Moveable(grid) {
			@Override
			public Cell move() {
				// TODO Auto-generated method stub
				return null;
			}};
		instance.setDirection(c);
		assertEquals(instance.getDirection(), c);
	}

	@Test
	public void testGetDirection() throws Exception {
		Moveable instance = new Moveable(grid) {
			@Override
			public Cell move() {
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
