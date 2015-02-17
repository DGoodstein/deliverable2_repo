package com.laboon;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class CoffeeMakerTest {

	@Test //Makes sure runArgs is working correctly
	public void runArgTest()
	{
		CoffeeMaker testcoffee = new CoffeeMaker();
		int retVal = testcoffee.runArgs("test args");
		assertEquals(0, retVal);
	}
	
	@Test
	//Tries the main using an array of args.
	public void mainArgsTest()
	{
	CoffeeMaker testcoffee = new CoffeeMaker();
	String[] s=new String[2];
	s[0]="1";
	ByteArrayOutputStream b = new ByteArrayOutputStream();
	PrintStream stream = new PrintStream(b);
	System.setOut(stream);
	testcoffee.main(s);
	System.out.flush();
	System.setOut(System.out);
	assertEquals(b.toString(),"Exiting with error code 0");
	}
	
	
	//This test does not really look for a specific code; Error code 1 means you didn't have all of the items and you lost. This just runs the game, albeit into a string.
	@Test
	public void mainNoArgsTest()
	{
	CoffeeMaker testcoffee = new CoffeeMaker();
	String[] s=new String[0];
	ByteArrayOutputStream b = new ByteArrayOutputStream();
	PrintStream stream = new PrintStream(b);
	System.setOut(stream);
	testcoffee.main(s);
	System.out.flush();
	System.setOut(System.out);
	assertEquals(b.toString(),"Exiting with error code 1");
	}
}