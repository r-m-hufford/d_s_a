package com.rmhufford;

public class MyArray {
  private Integer[] array;
  private int size;
  private int elementCount;

  public MyArray(int capacity) {
    this.array = new Integer[capacity];
    this.size = capacity;
  }

  public int getElement(int index) {
    checkBoundary(index);
    return this.array[index];
  }

  public void setElement(int index, int value) {
    checkBoundary(index);

    this.array[index] = value;
    this.elementCount++;
  }

  public Integer[] getArray() {
    return this.array;
  }

  public void setArray(Integer[] arr) {
    this.array = arr;
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
      setArray(newArr);
    }

    this.setElement(index, value);
    this.elementCount++;
  }

  public void delete(int index) {
    checkBoundary(index);
    this.array[index] = null;
    this.elementCount--;
  }

  public int size() {
    return this.elementCount;
  }

  public boolean isEmpty() {
    return this.elementCount > 0;
  }

  public void resize() {
    Integer[] newArr = new Integer[this.size * 2];
    for (int i = 0; i < this.size; i++) {
      newArr[i] = this.array[i];
    }
    setArray(newArr);
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

  // HELPERS
  public void checkBoundary(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException("you're outta bounds!");
    }
  }
}
