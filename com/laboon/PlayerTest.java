package com.laboon;
	import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;


public class PlayerTest {

	private Player p=null;
	
	@Test
	public void noItemsTest() //This test fails, but the comparison shows the same text.
	{
		p=new Player();
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(b);
		System.setOut(stream);
		p.showInventory();
		System.out.flush();
		System.setOut(System.out);
		assertEquals(b.toString(),"YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!");
	}
	
	@Test
	public void getSugarTest() //This test fails, but the comparison shows the same text.
	{
		p=new Player();
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(b);
		System.setOut(stream);
		p.getSugar();
		System.out.flush();
		System.setOut(System.out);
		assertEquals(b.toString(),"You found some sweet sugar!");
	}
	
	@Test
	public void getCoffeeTest() //This test fails, but the comparison shows the same text.
	{
		p=new Player();
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(b);
		System.setOut(stream);
		p.getCoffee();
		System.out.flush();
		System.setOut(System.out);
		assertEquals(b.toString(),"You found some caffeinated coffee!");
	}
	
	@Test
	public void getCreamTest() //This test fails, but the comparison shows the same text.
	{
		p=new Player();
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(b);
		System.setOut(stream);
		p.getCream();
		System.out.flush();
		System.setOut(System.out);
		assertEquals(b.toString(),"You found some creamy cream!\n");
	}
	
	@Test
	public void allItemsTest() //Makes sure that all items are in the player's possession. 
	{
		p=new Player(true,true,true);
		assertEquals(p.hasAllItems(),true);
	}
	
	@Test
	public void notAllItemsTest() //Makes sure that the function returns false if an item is missing. 
	{
		p=new Player(true,true,false);
		assertEquals(p.hasAllItems(),false);
	}
	
	@Test
	public void inventoryAllItemsTest() //Tests the rest of the inventory if statements, but returns false while showing an equivalent string.
	{
		p=new Player(true,true,true);
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(b);
		System.setOut(stream);
		p.showInventory();
		System.out.flush();
		System.setOut(System.out);
		assertEquals(b.toString(),"You have a cup of delicious coffee.\nYou have some fresh cream.\nYou have some tasty sugar.");
	}
	
	@Test
	public void DrinkLackingTest1() //Checks to make sure you lose if you do not have all three items. 
	{
		p=new Player(true,true,false);
		assertEquals(p.drink(),false);
	}
	
	@Test
	public void DrinkLackingTest2() //Checks to make sure you lose if you do not have all three items. 
	{
		p=new Player(false,true,true);
		assertEquals(p.drink(),false);
	}
	
	@Test
	public void DrinkLackingTest3() //Checks to make sure you lose if you do not have all three items. 
	{
		p=new Player(true,false,true);
		assertEquals(p.drink(),false);
	}
	
	@Test
	public void DrinkLackingTest4() //Checks to make sure you lose if you do not have all three items. 
	{
		p=new Player(false,true,false);
		assertEquals(p.drink(),false);
	}
	
	@Test
	public void DrinkLackingTest5() //Checks to make sure you lose if you do not have all three items. 
	{
		p=new Player(true,false,false);
		assertEquals(p.drink(),false);
	}
	
	@Test
	public void DrinkLackingTest6() //Checks to make sure you lose if you do not have all three items. 
	{
		p=new Player(false,false,false);
		assertEquals(p.drink(),false);
	}
	
	@Test
	public void DrinkWinTest() //Checks to make sure you win if you have all three items. 
	{
		p=new Player(true,true,true);
		assertEquals(p.drink(),true);
	}
}
