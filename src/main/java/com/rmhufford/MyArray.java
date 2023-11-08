package com.rmhufford;

public class MyArray {
  private Integer[] array;
  private int size;

  public MyArray(int capacity) {
    this.array = new Integer[capacity];
    this.size = 0;
  }

  public int getElement(int index) {
    checkBoundary(index);
    return this.array[index];
  }

  public void setElement(int index, int value) {
    checkBoundary(index);

    this.array[index] = value;
    this.size++;
  }

  public Integer[] getArray() {
    return this.array;
  }

  public void insert(int index, int value) {
    if (index > this.array.length) {
      Integer[] newArr = new Integer[this.array.length * 2];
      for (int i = 0; i < this.array.length; i++) {
        newArr[i] = this.array[i];
      }
      for (int i = this.array.length; i < this.array.length * 2; i++) {
        if (i == index) {
          newArr[i] = value;
        }
      }
      this.array = newArr;
    }

    this.setElement(index, value);
    this.size++;
  }

  public void delete(int index) {
    checkBoundary(index);
    this.array[index] = null;
    this.size--;
  }

  public int size() {
    // i.e. number of non null elements
    return this.size;
  }

  public boolean isEmpty() {
    return this.size > 0;
  }

  public void resize() {
    Integer[] newArr = new Integer[this.size * 2];
    for (int i = 0; i < this.size; i++) {
      newArr[i] = this.array[i];
    }
    this.array = newArr;
  }

  // modes: all and notnull
  public String print(String mode) {
    StringBuilder list = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      if (mode == "notnull" && this.array[i] == null) {
        continue;
      } else {
        list.append(this.array[i]).append(", ");
      }
    }

    if (list.length() > 0) {
      list.setLength(list.length() - 2);
    }
    return list.toString();
  }

  public void append(int value) {
    if (size == this.array.length) {
      resize();
    }
    this.array[size] = value;
    size++;
  }

  public void clear() {
    for (int i = 0; i < this.array.length; i++) {
      this.array[i] = null;
    }
  }

  public boolean contains(int value) {
    for (int i = 0; i < this.array.length; i++) {
      if (this.array[i] == value) {
        return true;
      } else {
        continue;
      }
    }
    return false;
  }

  public int indexOf(int value) {
    for (int i = 0; i < this.array.length; i++) {
      if (this.array[i] == value) {
        return i;
      } else {
        continue;
      }
    }
    return -1;
  }

  // HELPERS
  public void checkBoundary(int index) {
    if (index >= this.array.length) {
      throw new IndexOutOfBoundsException("you're outta bounds!");
    }
  }
}
