package com.rmhufford;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
  private LinkedList list;

  @Before
  public void setup() {
    list = new LinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
  }

  @Test
  public void testInsert() {
    list.insert(1);
    list.insert(2);
    list.insert(3);

    Assert.assertEquals(1, list.get(0));
    Assert.assertEquals(2, list.get(1));
    Assert.assertEquals(3, list.get(2));
  }

  @Test
  public void testInsertAtHead() {
    LinkedList list = new LinkedList();

    list.insertAtHead(1);
    list.insertAtHead(2);
    list.insertAtHead(3);

    Assert.assertEquals(3, list.get(0));
    Assert.assertEquals(2, list.get(1));
    Assert.assertEquals(1, list.get(2));
  }

  @Test
  public void testInsertAt() {
    LinkedList list = new LinkedList();

    list.insertAt(0, 1);
    list.insertAt(0, 2);
    list.insertAt(1, 3);

    Assert.assertEquals(2, list.get(0));
    Assert.assertEquals(3, list.get(1));
    Assert.assertEquals(1, list.get(2));
  }

  @Test
  public void testClear() {
    LinkedList list = new LinkedList();

    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.clear();

    Assert.assertEquals(0, list.size());
  }

  @Test
  public void testDeleteNode() {
    LinkedList list = new LinkedList();

    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.deleteNode(1);

    Assert.assertEquals(1, list.get(0));
    Assert.assertEquals(3, list.get(1));
  }

  @Test
  public void testContains() {
    assertTrue(list.contains(1));
    assertTrue(list.contains(2));
    assertTrue(list.contains(3));
    assertFalse(list.contains(4));
  }

  @Test
  public void testGetFirst() {
    assertEquals(1, list.getFirst());
  }

  @Test
  public void testGetLast() {
    assertEquals(3, list.getLast());
  }

  @Test
  public void testGet() {
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  @Test
  public void testIndexOf() {
    assertEquals(0, list.indexOf(1));
    assertEquals(1, list.indexOf(2));
    assertEquals(2, list.indexOf(3));
    assertEquals(-1, list.indexOf(4));
  }

  @Test
  public void testSize() {
    assertEquals(3, list.size());
  }

  @Test
  public void testIsEmpty() {
    assertFalse(list.isEmpty());

    list.clear();
    assertTrue(list.isEmpty());
  }

  @Test
  public void testUpdate() {
    list.update(0, 4);
    list.update(1, 5);
    list.update(2, 6);

    assertEquals(4, list.get(0));
    assertEquals(5, list.get(1));
    assertEquals(6, list.get(2));
  }

  @Test
  public void testReverse() {
    list.reverse();

    assertEquals(3, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(1, list.get(2));
  }

  @Test
  public void testSort() {
    list.clear();
    list.insert(3);
    list.insert(1);
    list.insert(2);
    list.sort();

    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  @Test
  public void testMergeSort() {
    list.clear();
    list.insert(3);
    list.insert(1);
    list.insert(2);
    list.sort();

    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  @Test
  public void testConcatenate() {
    list.clear();
    LinkedList otherList = new LinkedList();
    otherList.insert(4);
    otherList.insert(5);
    otherList.insert(6);

    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.concatenate(otherList);

    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
    assertEquals(4, list.get(3));
    assertEquals(5, list.get(4));
    assertEquals(6, list.get(5));
  }

  @Test
  public void testMergeLists() {
    list.clear();
    LinkedList otherList = new LinkedList();
    otherList.insert(4);
    otherList.insert(2);
    otherList.insert(6);

    list.insert(5);
    list.insert(1);
    list.insert(3);
    list.mergeLists(otherList);

    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
    assertEquals(4, list.get(3));
    assertEquals(5, list.get(4));
    assertEquals(6, list.get(5));
  }
}
