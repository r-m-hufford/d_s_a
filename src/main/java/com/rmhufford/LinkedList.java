package com.rmhufford;

import java.util.NoSuchElementException;

public class LinkedList {
  private Node head;
  private Node tail;
  private int size;

  private class Node {
    private int data;
    private Node next;

    public Node(int data) {
      this.data = data;
    }
  }

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  // INSERTION
  public void insert(int data) {
    Node node = new Node(data);
    if (this.head == null) {
      this.head = node;
      this.tail = node;
      this.size++;
      return;
    }
    tail.next = node;
    tail = node;
    this.size++;
  }

  public void insertAtHead(int data) {
    Node node = new Node(data);
    if (this.head == null) {
      this.head = node;
      this.tail = node;
      this.size++;
      return;
    }
    node.next = this.head;
    this.head = node;
    this.size++;
  }

  public void insertAt(int index, int data) {
    this.checkBounds(index);
    Node node = new Node(data);

    if (index == 0) {
      this.insertAtHead(data);
    } else if (index == this.size) {
      this.insert(data);
    } else {
      Node previousNode = getNodeAt(index - 1);
      node.next = previousNode.next;
      previousNode.next = node;
    }
    this.size++;
  }

  // DELETION
  public void clear() {
    Node current = this.head;
    Node next = current.next;

    while (current != null) {
      next = current.next;
      current.next = null;
      current = next;
    }

    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void deleteNode(int index) {
    this.checkBounds(index);

    if (index == 0) {
      this.head = this.head.next;
    } else {
      Node previousNode = getNodeAt(index - 1);
      Node delete = previousNode.next;
      previousNode.next = delete.next;
      delete.next = null;
      this.size--;
    }
  }

  // TRAVERSAL
  public boolean contains(int data) {
    Node node = this.head;
    while (node != null) {
      if (node.data == data) {
        return true;
      }
      node = node.next;
    }
    return false;
  }

  public int getFirst() {
    if (this.size == 0) {
      throw new NoSuchElementException("List is empty");
    }
    return this.head.data;
  }

  public int getLast() {
    if (this.size == 0) {
      throw new NoSuchElementException("List is empty");
    }
    return this.tail.data;
  }

  public int get(int index) {
    this.checkBounds(index);

    if (index == 0) {
      return head.data;
    } else {
      Node node = getNodeAt(index);
      return node.data;
    }
  }

  public int indexOf(int value) {
    Node node = this.head;
    int count = 0;
    while (node != null) {
      if (node.data == value) {
        return count;
      }
      count++;
      node = node.next;
    }

    return -1;
  }

  // SIZE CHECKS
  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  // UPDATE
  public void update(int index, int data) {
    this.checkBounds(index);

    if (index == 0) {
      this.head.data = data;
    } else {
      Node node = getNodeAt(index);
      node.data = data;
    }
  }

  // REVERSAL
  public void reverse() {
    Node current = this.head;
    Node previous = null;
    Node next = null;

    while (current != null) {
      next = current.next;
      current.next = previous;

      previous = current;
      current = next;
    }

    this.head = previous;
  }

  // SORT - merge sort
  public void sort() {
    head = mergeSort(head);
  }

  public Node sortedMerge(Node a, Node b) {
    Node result = null;

    if (a == null)
      return b;
    if (b == null)
      return a;

    if (a.data <= b.data) {
      result = a;
      result.next = sortedMerge(a.next, b);
    } else {
      result = b;
      result.next = sortedMerge(a, b.next);
    }

    return result;
  }

  public Node mergeSort(Node h) {
    if (h == null || h.next == null) {
      return h;
    }

    Node middle = middleNode(h);
    Node nextOfMiddle = middle.next;
    middle.next = null;

    Node left = mergeSort(h);

    Node right = mergeSort(nextOfMiddle);

    Node sortedList = sortedMerge(left, right);
    return sortedList;
  }

  // CONCATENATE
  public LinkedList concatenate(LinkedList otherList) {
    Node current = otherList.head;
    while (current != null) {
      this.insert(current.data);
      current = current.next;
    }
    this.tail = otherList.tail;
    otherList.clear();
    return this;
  }

  // MERGING
  public void mergeLists(LinkedList otherList) {
    this.concatenate(otherList);
    this.sort();
  }

  // HELPERS

  private Node getNodeAt(int index) {
    this.checkBounds(index);
    Node node = this.head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node;
  }

  private void checkBounds(int index) {
    if (index > this.size) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
  }

  public Node middleNode(Node head) {
    Node slow = head;
    Node fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public String toString() {
    StringBuilder list = new StringBuilder();
    Node node = this.head;
    while (node != null) {
      list.append(node.data).append(", ");
      node = node.next;
    }

    if (list.length() > 0) {
      list.setLength(list.length() - 2);
    }
    return list.toString();
  }
}
