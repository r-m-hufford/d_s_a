package com.rmhufford;

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
  public void testRemove() {
    MyArray arr = new MyArray(7);
    arr.append(2);
    arr.append(3);
    arr.append(3);
    arr.append(2);
    arr.remove(2);
    boolean contains = arr.contains(2);
    Assert.assertEquals(false, contains);
  }
}
