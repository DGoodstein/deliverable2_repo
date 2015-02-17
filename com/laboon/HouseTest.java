package com.laboon;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.mockito.Mockito;
public class HouseTest{

	private House h;

	@Test //This makes sure the house can be built with a number.
	public void buildHouseRoomNo()
	{
		h=new House(6);
		assertNotEquals(h,null);
	}
	
	@Test //This builds a house using a predefined array of rooms.
	public void buildHouseRooms()
	{
		Room[] r=new Room[6];
		r[0]=Mockito.mock(Room.class);
		r[1]=Mockito.mock(Room.class);
		r[2]=Mockito.mock(Room.class);
		r[3]=Mockito.mock(Room.class);
		r[4]=Mockito.mock(Room.class);
		r[5]=Mockito.mock(Room.class);
		h=new House(r);
		assertNotEquals(h,null);
	}
	
	@Test //Makes sure that it generates the correct amount of rooms.
	public void testRooms() 
	{
		h=new House(6);
		Room[] r=h.generateRooms(6);
		assertEquals(r.length,6);
	}
	
	@Test //This test makes sure that the room has a description
	public void testRoomInfo()
	{
		h=new House(6);
		String s=h.getCurrentRoomInfo();
		assertNotNull(s);
	}
	
	@Test //This checks for a negative room, and the appropriate message.
	public void testNegativeRoomInfo()
	{
		h=new House(6);
		h.moveSouth();
		String s=h.getCurrentRoomInfo();
		assertEquals(s,"You are in a magical land!  But you are returned to the beginning!");
	}
	
	@Test //South is implicitly tested in testNegativeRoomInfo.
	public void testNorth()
	{
		h=new House(6);
		String original=h.getCurrentRoomInfo();
		h.moveNorth();
		String s=h.getCurrentRoomInfo();
		assertNotEquals(s,original);
	}
	
	@Test //This test uses Mocking and Stubbing in order to test the look function. 
			//This test fails, but if you compare the results in the failure trace, it is the same string. 
			//I think it's just having trouble with it being output using System.out.println instead of System.out.print
	public void lookTest()
	{
		h=new House(6);	
		Room r=Mockito.mock(Room.class);
		Mockito.stub(r.hasItem()).toReturn(false);
		Player p=Mockito.mock(Player.class);
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(b);
		System.setOut(stream);
		h.look(p,r);
		System.out.flush();
		System.setOut(System.out);
		assertEquals(b.toString(),"You don't see anything out of the ordinary.");
	}
	
	@Test
	//This tests to make sure the look function will pull the current room if not fed a room. Will also fail like the previous test, but should contain cream as room 0 is set to contain it.
	public void lookNullTest()
	{
		h=new House(6);	
		Player p=Mockito.mock(Player.class);
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(b);
		System.setOut(stream);
		h.look(p,null);
		System.out.flush();
		System.setOut(System.out);
		assertEquals(b.toString(),"There might be something here...");
	}
}
