package com.rmhufford;

public class MyArray {
  private Integer[] array;
  private int size;
  private int count;

  public MyArray(int capacity) {
    this.array = new Integer[capacity];
    this.size = capacity;
  }

  public int get(int index) {
    checkBoundary(index);
    return this.array[index];
  }

  public void set(int index, int value) {
    checkBoundary(index);

    this.array[index] = value;
    this.count++;
  }

  public void insert(int index, int value) {
    if (index > size) {
      Integer[] newArr = new Integer[this.size * 2];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.array[i];
      }
      for (int i = this.size; i < this.size * 2; i++) {
        if (i == index) {
          newArr[i] = value;
        }
      }
      this.size *= 2;
      this.array = newArr;
    }

    this.set(index, value);
    this.count++;
  }

  public void delete(int index) {
    checkBoundary(index);
    this.array[index] = null;
    this.count--;
  }

  public int size() {
    return this.count;
  }

  public boolean isEmpty() {
    return this.count > 0;
  }

  public void resize() {
    Integer[] newArr = new Integer[this.size * 2];
    for (int i = 0; i < this.size; i++) {
      newArr[i] = this.array[i];
    }
    // return or reassign
    //
  }

  // HELPERS
  public void checkBoundary(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException("you're outta bounds!");
    }
  }
}
