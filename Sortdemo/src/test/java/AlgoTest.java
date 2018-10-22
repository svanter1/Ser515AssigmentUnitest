package test.java;
import main.java.*;

import static org.junit.Assert.*;


import org.junit.Test;
/* following test case will implement node coverage, edge coverage  and condition coverage , the input will cover all covergaes are covered atleast once
 * and null pointer exception is also tested by calling bubblesort and catching null pointer , as we have given expected nullpointer */
public class AlgoTest {
	@Test(expected=NullPointerException.class)
	public void testbubble() {
		SortDemoData dataTest = new SortDemoData();
		SortDemoData answer = new SortDemoData();
		dataTest.initializeArray("1 2 8 9 7 6 5"); //all the coverages are visited atleast once
		answer.initializeArray("1 2 5 6 7 8 9");
		dataTest.runAlgo(0);
		assertTrue(dataTest.myArray[0].key == answer.myArray[0].key);//checking element by element
		assertTrue(dataTest.myArray[1].key == answer.myArray[1].key);
		assertTrue(dataTest.myArray[2].key == answer.myArray[2].key);
		assertTrue(dataTest.myArray[3].key == answer.myArray[3].key);
		assertTrue(dataTest.myArray[4].key == answer.myArray[4].key);
		assertTrue(dataTest.myArray[5].key == answer.myArray[5].key);
		assertTrue(dataTest.myArray[6].key == answer.myArray[6].key);
		SortAlgos.bubbleSort(null);
	}
	//test case for checking heap
	@Test
	public void testheap() {
		SortDemoData dataTest = new SortDemoData();
		SortDemoData answer = new SortDemoData();
		dataTest.initializeArray("1 2 4 7 3 5 6");
		answer.initializeArray("1 2 3 4 5 6 7");
		dataTest.runAlgo(5);
		assertTrue(dataTest.myArray[0].key == answer.myArray[0].key);
		assertTrue(dataTest.myArray[1].key == answer.myArray[1].key);
		assertTrue(dataTest.myArray[2].key == answer.myArray[2].key);
		assertTrue(dataTest.myArray[3].key == answer.myArray[3].key);
		assertTrue(dataTest.myArray[4].key == answer.myArray[4].key);
		assertTrue(dataTest.myArray[5].key == answer.myArray[5].key);
		assertTrue(dataTest.myArray[6].key == answer.myArray[6].key);
	}
	//test case for checking insertion
	@Test
	public void testinsertion() {
		SortDemoData dataTest = new SortDemoData();
		SortDemoData answer = new SortDemoData();
		dataTest.initializeArray("1 2 4 7 3 5 6");
		answer.initializeArray("1 2 3 4 5 6 7");
		dataTest.runAlgo(2);
		assertTrue(dataTest.myArray[0].key == answer.myArray[0].key);
		assertTrue(dataTest.myArray[1].key == answer.myArray[1].key);
		assertTrue(dataTest.myArray[2].key == answer.myArray[2].key);
		assertTrue(dataTest.myArray[3].key == answer.myArray[3].key);
		assertTrue(dataTest.myArray[4].key == answer.myArray[4].key);
		assertTrue(dataTest.myArray[5].key == answer.myArray[5].key);
		assertTrue(dataTest.myArray[6].key == answer.myArray[6].key);
	}
	//test case for checking merge
	@Test
	public void testmerge() {
		SortDemoData dataTest = new SortDemoData();
		SortDemoData answer = new SortDemoData();
		dataTest.initializeArray("1 2 4 7 3 5 6");
		answer.initializeArray("1 2 3 4 5 6 7");
		dataTest.runAlgo(3);
		assertTrue(dataTest.myArray[0].key == answer.myArray[0].key);
		assertTrue(dataTest.myArray[1].key == answer.myArray[1].key);
		assertTrue(dataTest.myArray[2].key == answer.myArray[2].key);
		assertTrue(dataTest.myArray[3].key == answer.myArray[3].key);
		assertTrue(dataTest.myArray[4].key == answer.myArray[4].key);
		assertTrue(dataTest.myArray[5].key == answer.myArray[5].key);
		assertTrue(dataTest.myArray[6].key == answer.myArray[6].key);
	}
	//test case for checking quick
	@Test
	public void testquick() {
		SortDemoData dataTest = new SortDemoData();
		SortDemoData answer = new SortDemoData();
		dataTest.initializeArray("1 2 4 7 3 5 6");
		answer.initializeArray("1 2 3 4 5 6 7");
		dataTest.runAlgo(4);
		assertTrue(dataTest.myArray[0].key == answer.myArray[0].key);
		assertTrue(dataTest.myArray[1].key == answer.myArray[1].key);
		assertTrue(dataTest.myArray[2].key == answer.myArray[2].key);
		assertTrue(dataTest.myArray[3].key == answer.myArray[3].key);
		assertTrue(dataTest.myArray[4].key == answer.myArray[4].key);
		assertTrue(dataTest.myArray[5].key == answer.myArray[5].key);
		assertTrue(dataTest.myArray[6].key == answer.myArray[6].key);
	}
	@Test
	public void testselection() {
		SortDemoData dataTest = new SortDemoData();
		SortDemoData answer = new SortDemoData();
		dataTest.initializeArray("1 2 4 7 3 5 6");
		answer.initializeArray("1 2 3 4 5 6 7");
		dataTest.runAlgo(1);
		assertTrue(dataTest.myArray[0].key == answer.myArray[0].key);
		assertTrue(dataTest.myArray[1].key == answer.myArray[1].key);
		assertTrue(dataTest.myArray[2].key == answer.myArray[2].key);
		assertTrue(dataTest.myArray[3].key == answer.myArray[3].key);
		assertTrue(dataTest.myArray[4].key == answer.myArray[4].key);
		assertTrue(dataTest.myArray[5].key == answer.myArray[5].key);
		assertTrue(dataTest.myArray[6].key == answer.myArray[6].key);
	}
	//checking test case for only one input
	@Test
	public void test2() {
		SortDemoData dataTest = new SortDemoData();
		SortDemoData answer = new SortDemoData();
		
		dataTest.initializeArray("1");
		answer.initializeArray("1");
		dataTest.runAlgo(0);
		assertTrue(dataTest.myArray[0].key==answer.myArray[0].key);
		
	}
	// checking input for 2 inputs
	@Test
	public void test3() {
		SortDemoData dataTest = new SortDemoData();
		SortDemoData answer = new SortDemoData();
		dataTest.initializeArray("7 1");
		answer.initializeArray("1 7");
		dataTest.runAlgo(0);
		assertTrue(dataTest.myArray[0].key==answer.myArray[0].key);
		assertTrue(dataTest.myArray[1].key == answer.myArray[1].key);
	
}
	//here I am implemented only for nullpointer exception for bubblesort
	
	@Test(expected=NullPointerException.class)
	public void testNullInput() {
		
		SortAlgos.bubbleSort(null);
		
	    
	}
		
		
	
	
	}
