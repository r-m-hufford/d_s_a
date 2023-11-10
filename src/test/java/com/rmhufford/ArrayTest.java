package com.rmhufford;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {
  private MyArray array;

  @Before
  public void setup() {
    array = new MyArray(5);
  }

  @Test
  public void testAppend() {
    array.append(2);

    Assert.assertEquals(array.getElement(0), 2);
  }

  @Test
  public void testContains() {
    MyArray arr = new MyArray(5);
    arr.append(2);
    boolean contains = arr.contains(2);

    Assert.assertEquals(contains, true);
  }

  @Test
  public void testDoesNotContain() {
    MyArray arr = new MyArray(5);
    arr.append(2);
    boolean contains = arr.contains(0);

    Assert.assertEquals(contains, false);
  }

  @Test
  public void testIndexOf() {
    MyArray arr = new MyArray(7);
    arr.append(2);
    int indexOf = arr.indexOf(2);
    Assert.assertEquals(0, indexOf);
  }

  @Test
  public void testNoIndexOf() {
    int indexOf = array.indexOf(0);

    Assert.assertEquals(indexOf, -1);
  }

  @Test
  public void testLastIndexOf() {
    MyArray arr = new MyArray(7);
    arr.append(2);
    arr.append(3);
    arr.append(3);
    arr.append(2);
    int indexOf = arr.lastIndexOf(2);
    Assert.assertEquals(3, indexOf);
  }

  @Test
  public void testAddAll() {
    MyArray arr = new MyArray(4);
    Integer[] addPls = new Integer[] { 1, 2, 3, 4, 5, 6 };
    arr.addAll(addPls);
    boolean contains = arr.contains(6);
    Assert.assertEquals(true, contains);
  }

  @Test
  public void testReverse() {
    MyArray arr = new MyArray(6);
    Integer[] addPls = new Integer[] { 1, 2, 3, 4, 5, 6 };
    arr.addAll(addPls);

    arr.reverse();
    int indexOf = arr.indexOf(6);
    Assert.assertEquals(0, indexOf);
  }

  @Test
  public void testTrimToSize() {
    MyArray myArray = new MyArray(10);
    myArray.append(1);
    myArray.append(2);
    myArray.append(null);
    myArray.append(3);
    myArray.trimToSize();

    int expectedSize = 3;
    int actualSize = myArray.size();

    Assert.assertEquals(expectedSize, actualSize);
  }

  @Test
  public void testRemove() {
    MyArray myArray = new MyArray(5);

    myArray.append(10);
    myArray.append(20);
    myArray.append(30);

    myArray.remove(20);

    // Check that the element was removed
    assertFalse(myArray.contains(20));

    // Check that the other elements are still there
    assertTrue(myArray.contains(10));
    assertTrue(myArray.contains(30));

    // Check that the size is correct
    assertEquals(2, myArray.size());
  }

  @Test
  public void testGetElement() {
    MyArray myArray = new MyArray(5);
    myArray.append(10);
    assertEquals(10, myArray.getElement(0));
  }

  @Test
  public void testGetArray() {
    MyArray myArray = new MyArray(5);
    myArray.append(10);
    Integer[] expectedArray = new Integer[5];
    expectedArray[0] = 10;
    assertArrayEquals(expectedArray, myArray.getArray());
  }

  @Test
  public void testInsert() {
    MyArray myArray = new MyArray(5);
    myArray.insert(0, 10);
    assertEquals(10, myArray.getElement(0));
  }

  @Test
  public void testSize() {
    MyArray myArray = new MyArray(5);
    myArray.append(10);
    assertEquals(1, myArray.size());
  }

  @Test
  public void testIsEmpty() {
    MyArray myArray = new MyArray(5);
    assertTrue(myArray.isEmpty());
    myArray.append(10);
    assertFalse(myArray.isEmpty());
  }

  @Test
  public void testPrint() {
    MyArray myArray = new MyArray(5);
    myArray.append(10);
    myArray.append(null);
    myArray.print("notnull");
  }

  @Test
  public void testClear() {
    MyArray myArray = new MyArray(5);
    myArray.append(10);
    myArray.clear();
    assertEquals(0, myArray.size());
    assertTrue(myArray.isEmpty());
  }

  @Test
  public void testSubArray() {
    MyArray myArray = new MyArray(5);
    myArray.append(10);
    myArray.append(20);
    myArray.append(30);
    MyArray subArray = myArray.subArray(1, 3);
    assertEquals(2, subArray.size());
    assertEquals(20, subArray.getElement(0));
    assertEquals(30, subArray.getElement(1));
  }

  @Test
  public void testQuicker() {
    MyArray arr = new MyArray(7);
    arr.append(1);
    arr.append(0);
    arr.append(3);
    arr.append(19);
    arr.append(2);
    arr.append(7);
    arr.append(8);

    arr.quicker();

    assertEquals(0, arr.indexOf(0));
    assertEquals(6, arr.indexOf(19));
  }

  @Test
  public void testSillySort() {
    MyArray arr = new MyArray(7);
    arr.append(1);
    arr.append(0);
    arr.append(3);
    arr.append(19);
    arr.append(2);
    arr.append(7);
    arr.append(8);

    arr.quick();

    assertEquals(0, arr.indexOf(0));
    assertEquals(6, arr.indexOf(19));
  }

}
