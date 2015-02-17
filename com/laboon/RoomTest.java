package com.laboon;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
public class RoomTest {
	
	private Room r;
	
	@Before
	public void setup()
	{
		r=null;
	}
	
	
	@Test //Test to make sure there is no coffee.
	public void testNoCoffee()
	{
		r=new Room(false,false,false,false,false);
		assertFalse(r.hasCoffee());
	}
	
	@Test //Test to make sure there is coffee.
	public void testCoffee()
	{
		r=new Room(true,false,false,false,false);
		assertTrue(r.hasCoffee());
	}
	
	@Test //Test to make sure there is no cream.
	public void testNoCream()
	{
		r=new Room(false,false,false,false,false);
		assertFalse(r.hasCream());
	}
	
	@Test //Test to make sure there is cream.
	public void testCream()
	{
		r=new Room(true,true,false,false,false);
		assertTrue(r.hasCream());
	}
	//Test to make sure there is no sugar.
	@Test
	public void testNoSugar()
	{
		r=new Room(false,false,false,false,false);
		assertFalse(r.hasSugar());
	}
	
	@Test //Test to make sure there is sugar.
	public void testSugar()
	{
		r=new Room(true,false,true,false,false);
		assertTrue(r.hasSugar());
	}
	@Test //Test to make sure there is no northern door.
	public void testNoNorth()
	{
		r=new Room(false,false,false,false,false);
		assertEquals(r.northExit(),false);
	}
	
	@Test //Test to make sure there is a door to the North.
	public void testNorth()
	{
		r=new Room(true,false,false,true,false);
		assertEquals(r.northExit(),true);
	}
	
	@Test //Test to make sure there is no southern door.
	public void testNoSouth()
	{
		r=new Room(false,false,false,false,false);
		assertEquals(r.southExit(),false);
	}
	
	@Test //Test to make sure there is a southern door.
	public void testSouth()
	{
		r=new Room(true,false,false,true,true);
		assertEquals(r.southExit(),true);
	}
	
	//The following tests make sure of different combinations of variables in the hasItem method.
	
	@Test
	public void testNoItem()
	{
		r=new Room(false,false,false,false,false);
		assertFalse(r.hasItem());
	}
	
	@Test
	public void testItem1()
	{
		r=new Room(true,true,true,false,false);
		assertTrue(r.hasItem());
	}
	
	@Test
	public void testItem2()
	{
		r=new Room(false,true,true,false,false);
		assertTrue(r.hasItem());
	}
	
	@Test
	public void testItem3()
	{
		r=new Room(true,false,true,false,false);
		assertTrue(r.hasItem());
	}
	
	@Test
	public void testItem4()
	{
		r=new Room(true,true,false,false,false);
		assertTrue(r.hasItem());
	}
	
	@Test
	public void testItem5()
	{
		r=new Room(true,true,true,false,false);
		assertTrue(r.hasItem());
	}
	
	@Test
	public void testItem6()
	{
		r=new Room(true,false,false,false,false);
		assertTrue(r.hasItem());
	}
	
	@Test //This makes sure that the descriptions are built correctly.
	public void testDesc()
	{
		r=new Room(true,true,true,false,false);
		String desc=r.getDescription();
		assertNotNull(desc);
	}
	
}
