package com.rmhufford;

public class MyArray {
  private int[] array;
  private int size;

  public MyArray(int capacity) {
    this.array = new int[capacity];
    this.size = capacity;
  }

  // get
  public int get(int index) {
    if (index > size) {
      throw new IndexOutOfBoundsException("you're outta bounds!");
    }
    return this.array[index];
  }

  // set
  public void set(int index, int value) {
    if (index > size) {
      throw new IndexOutOfBoundsException("you're outta bounds!");
    }

    this.array[index] = value;
  }

  // insert
  public void insert(int index, int value) {
    if (index > size) {
      // create a new array double in size
      // add the old stuff
      // add the new stuff
      // assign to this.array
    }

    this.set(index, value);
  }
}
