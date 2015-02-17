package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GameTest {

	
	@Test
	public void doSomethingNorth(){

		Player mockplayer = mock(Player.class);
		House mockgame = new House(6); //Starts at room 0, so there will be a room to the North
		Game testgame = new Game(mockplayer, mockgame);
		String firstdesc= mockgame.getCurrentRoomInfo();
		testgame.doSomething("N");
		String secdesc=mockgame.getCurrentRoomInfo();
		assertNotEquals(firstdesc,secdesc);
	}
	
	@Test
	public void doSomethingSouth(){

		Player mockplayer = mock(Player.class);
		House mockgame = new House(6); //Starts at room 0, so there will be a room to the North
		Game testgame = new Game(mockplayer, mockgame);
		String firstdesc= mockgame.getCurrentRoomInfo();
		testgame.doSomething("N");
		testgame.doSomething("S");
		String secdesc=mockgame.getCurrentRoomInfo();
		assertEquals(firstdesc,secdesc);
	}

	@Test
	public void doSomeThingLook(){
		
		Player mockplayer = mock(Player.class);
		House mockgame = new House(6); //Starts at room 0, so there will be a room to the North
		Game testgame = new Game(mockplayer, mockgame);
		testgame.doSomething("L");
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(b);
		System.setOut(stream);
		mockgame.look(mockplayer, null);
		System.out.flush();
		System.setOut(System.out);
		assertNotNull(b.toString());
	}
	
	@Test
	public void doSomeThingInventory(){
		
		Player mockplayer = mock(Player.class);
		House mockgame = new House(6); //Starts at room 0, so there will be a room to the North
		Game testgame = new Game(mockplayer, mockgame);
		testgame.doSomething("I");
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(b);
		System.setOut(stream);
		mockplayer.showInventory();
		System.out.flush();
		System.setOut(System.out);
		assertNotNull(b.toString());
	}
	
	@Test
	public void doSomethingDrinkWin(){
		Player mockplayer = mock(Player.class);
		House mockgame = new House(6); //Starts at room 0, so there will be a room to the North
		Game testgame = new Game(mockplayer, mockgame);
		stub(mockplayer.drink()).toReturn(true);
		int retVal = testgame.doSomething("D");
		assertEquals(retVal, 1);
	}
	
	@Test
	public void doSomethingDrinkLose(){
		Player mockplayer = mock(Player.class);
		House mockgame = new House(6); //Starts at room 0, so there will be a room to the North
		Game testgame = new Game(mockplayer, mockgame);
		stub(mockplayer.drink()).toReturn(false);
		int retVal = testgame.doSomething("D");
		assertEquals(retVal, -1);
	}
	
	@Test
	public void runLose(){
		Player mockplayer = mock(Player.class);
		House mockgame = new House(6); //Starts at room 0, so there will be a room to the North
		Game testgame = new Game(mockplayer, mockgame);
		/*testgame.doSomething("D");*/
		int retVal = testgame.run();
		assertEquals(retVal, 1);
	}
	
	@Test
	public void runWin(){
		Player mockplayer = mock(Player.class);
		House mockgame = new House(6); //Starts at room 0, so there will be a room to the North
		Game testgame = new Game(mockplayer, mockgame);
		int retVal = testgame.run();
		assertEquals(retVal, 0);
	}
	
	
	
}
