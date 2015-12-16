package assign6;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * 
 * @author Jordan Hensley, Romney Doria jHensley doria 10/6/2015 Assignment 6
 *         CS_2420 - Fall 2015
 * 
 *         This class contains tests to ensure the functionality and quality of
 *         the MyLinkedList class.
 *
 */
public class MyLinkedListTester {

	@Test
	public void testMyLinkedList() {

		//Test constructor
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		assertEquals(0, testInteger.size());
	}

	@Test
	public void testAddFirst() {
		// No elements
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		testInteger.addFirst(30);
		assertEquals(30, testInteger.get(0), 0);

		// Subsequent elements added, should be shifting items over
		testInteger.addFirst(52);

		assertEquals(52, testInteger.get(0), 0);
		assertEquals(30, testInteger.get(1), 0);
		testInteger.addFirst(1);
		assertEquals(1, testInteger.get(0), 0);
		assertEquals(52, testInteger.get(1), 0);
		assertEquals(30, testInteger.get(2), 0);

		// Size of testInteger after calling addFirst 3 times
		assertEquals(3, testInteger.size());
	}

	@Test
	public void testAddLast() {
		// No elements
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		testInteger.addLast(30);
		assertEquals(30, testInteger.get(0), 0);

		// Subsequent elements added, should be shifting items over
		testInteger.addLast(52);

		assertEquals(30, testInteger.get(0), 0);
		assertEquals(52, testInteger.get(1), 0);
		testInteger.addLast(1);
		assertEquals(30, testInteger.get(0), 0);
		assertEquals(52, testInteger.get(1), 0);
		assertEquals(1, testInteger.get(2), 0);

		// Size of testInteger after calling addFirst 3 times
		assertEquals(3, testInteger.size());

	}

	@Test
	public void testAdd() {
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();

		// If size == 0
		testInteger.add(0, 21);
		assertEquals(21, testInteger.getFirst(), 0);

		// If index == size
		testInteger.add(1, 22);
		assertEquals(22, testInteger.getLast(), 0);

		// Just adding stuff
		testInteger.add(2, 30);
		assertEquals(30, testInteger.get(2), 0);

		// Added to save index, should shift over
		testInteger.add(3, 31);
		assertEquals(31, testInteger.get(3), 0);

		testInteger.add(3, 36);
		assertEquals(36, testInteger.get(3), 0);
		assertEquals(31, testInteger.get(4), 0);
		assertEquals(5, testInteger.size());

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIndexOutOfBounds1() {
		//test expected exception of the add method
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		testInteger.add(1, 5);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIndexOutOfBounds2() {
		//test expected exception of the add method
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		testInteger.add(-1, 5);

	}

	@Test
	public void testGetFirst() {
		//test functionality of get first method
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		testInteger.add(0, 1337);
		assertEquals(1337, testInteger.getFirst(), 0);
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetFirstFail() {
		//test expected exception thrown in the getFirst method
		MyLinkedList<Double> testFail = new MyLinkedList<Double>();
		testFail.getFirst();
	}

	@Test
	public void testGetLast() {
		//tet functionality of the getlast method
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		testInteger.add(0, 1337);
		assertEquals(1337, testInteger.getFirst(), 0);
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetLastFail() {
		//Test for expected exception of getLast method
		MyLinkedList<Double> testFail = new MyLinkedList<Double>();
		testFail.getLast();
	}

	@Test
	public void testGet() {
		//test functionality of the get method
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		testInteger.add(0, 1337);
		assertEquals(1337, testInteger.get(0), 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetFail1() {
		//test expected exception in the get method
		MyLinkedList<Integer> testFail = new MyLinkedList<Integer>();
		testFail.get(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetFail2() {
		//test for expected exception
		MyLinkedList<Integer> testFail = new MyLinkedList<Integer>();
		testFail.addFirst(5);
		testFail.get(1);
	}

	@Test
	public void testGetRandom() {
		//test functionality of the get random method for one object
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		testInteger.addFirst(1337);
		testInteger.getRandom();
		assertEquals(1337, testInteger.getRandom(), 0);
	}

	@Test(expected = NoSuchElementException.class)
	public void testRandomFail() {
		//test for expected exception
		MyLinkedList<Integer> testFail = new MyLinkedList<Integer>();
		testFail.getRandom();
	}

	@Test
	public void testRemoveFirst() {
		//test functionality of the removeFirst method
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		testInteger.addFirst(1337);
		testInteger.addFirst(1234);

		assertEquals(1234, testInteger.removeFirst(), 0);
		assertEquals(1337, testInteger.getFirst(), 0);
		assertEquals(1, testInteger.size(), 0);
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveFirstFail() {
		//test for expected exceptions of removeFirst method
		MyLinkedList<Integer> testFail = new MyLinkedList<Integer>();
		testFail.removeFirst();
	}

	@Test
	public void testRemoveLast() {
		//test functionality of the removeLast method
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		testInteger.addFirst(1337);
		testInteger.addFirst(1234);

		assertEquals(1337, testInteger.removeLast(), 0);
		assertEquals(1234, testInteger.getFirst(), 0);
		assertEquals(1, testInteger.size());
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveLastFail() {
		//test for expected exception of removeLast
		MyLinkedList<Integer> testFail = new MyLinkedList<Integer>();
		testFail.removeLast();
	}

	@Test
	public void testRemove() {
		//tests basic functionality of the remove method
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		testInteger.add(0, 1);
		testInteger.add(1, 2);
		testInteger.add(2, 3);
		testInteger.add(3, 5);
		assertEquals(4, testInteger.size());
		assertEquals(3, testInteger.remove(2), 0);
		assertEquals(2, testInteger.remove(1), 0);
		assertEquals(1, testInteger.remove(0), 0);
		assertEquals(1, testInteger.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveFail1() {
		//tests for the expected exception of the remove method
		MyLinkedList<Integer> testFail = new MyLinkedList<Integer>();
		testFail.remove(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveFail2() {
		MyLinkedList<Integer> testFail = new MyLinkedList<Integer>();
		testFail.addFirst(3);
		testFail.remove(1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveFail3() {
		MyLinkedList<Integer> testFail = new MyLinkedList<Integer>();
		testFail.addFirst(3);
		testFail.remove(-1);
	}

	@Test
	public void testIndexOf() {
		//tests the indexOf method
		MyLinkedList<Integer> testInteger = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			testInteger.add(i, i + 1);
		}
		assertEquals(9, testInteger.indexOf(10));
		assertEquals(0, testInteger.indexOf(1));
	}

	@Test
	public void testLastIndexOf() {
		MyLinkedList<Integer> lastindex = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			lastindex.add(i, i + 1);
		}
		//test functionality of lastIndexOf
		assertEquals(10, lastindex.size());
		assertEquals(1, lastindex.get(0), 0);
		assertEquals(10, lastindex.get(9), 0);
		assertEquals(9, lastindex.lastIndexOf(10));
		assertEquals(0, lastindex.lastIndexOf(1));

	}

	@Test
	public void testSize() {
		MyLinkedList<Integer> testIndex = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			testIndex.add(i, i + 1);
		}
		assertEquals(10, testIndex.size());
	}

	@Test
	public void testIsEmpty() {
		MyLinkedList<Double> testEmpty = new MyLinkedList<Double>();
		assertTrue(testEmpty.isEmpty());

		testEmpty.addFirst(23.0);
		assertFalse(testEmpty.isEmpty());
	}

	@Test
	public void testClear() {
		MyLinkedList<Point> test = new MyLinkedList<Point>();
		test.addFirst(new Point(23, 234));
		test.add(0, new Point(103, 49));
		test.add(2, new Point(203, 2));

		//Assure functionality of the clear method
		assertEquals(3, test.size(), 0);
		test.clear();
		assertTrue(test.isEmpty());
	}

	@Test
	public void testToArray() {
		MyLinkedList<Integer> testToArray = new MyLinkedList<Integer>();
		testToArray.addFirst(32);
		testToArray.addLast(23);
		testToArray.addLast(12);
		testToArray.addLast(3);

		//test ToArray method
		Object[] result = testToArray.toArray();
		assertEquals(32, result[0]);
		assertEquals(23, result[1]);
		assertEquals(12, result[2]);
		assertEquals(3, result[3]);
		assertEquals(4, result.length);
	}
}
