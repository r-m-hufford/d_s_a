package com.rmhufford;

import java.util.ArrayList;
import java.util.List;

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
    // ! index is out of bounds
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("you're outta bounds!");
    }
    if (size == array.length) {
      resize();
    }

    this.shiftRight(index);

    this.array[index] = value;
    size++;
  }

  public void shiftRight(int index) {
    this.checkBoundary(index + 1);
    for (int i = index + 1; i < 0; i--) {
      this.array[i + 1] = this.array[i];
    }
    size++;
  }

  public void shiftLeft(int index) {
    this.checkBoundary(index);
    for (int i = index; i < size - 1; i++) {
      this.array[i] = this.array[i + 1];
    }
    array[size - 1] = null;
    size--;
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
    return this.size == 0;
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
      if ("notnull".equals(mode) && this.array[i] == null) {
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

  public void append(Integer value) {
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

  public boolean contains(Integer value) {
    for (Integer i = 0; i < this.array.length; i++) {
      if (this.array[i] == value) {
        return true;
      }
    }
    return false;
  }

  public int indexOf(Integer value) {
    for (Integer i = 0; i < this.array.length; i++) {
      if (this.array[i] == value) {
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(Integer value) {
    int currentIndex = -1;
    for (Integer i = 0; i < this.array.length; i++) {
      if (this.array[i] == value) {
        currentIndex = i;
      } else {
        continue;
      }
    }
    return currentIndex;
  }

  public void remove(Integer value) {
    int index = indexOf(value);
    if (index != -1) {
      shiftLeft(index);
    }
  }

  public Integer[] addAll(Integer[] arr) {
    for (Integer i = 0; i < arr.length; i++) {
      this.append(arr[i]);
    }
    return this.array;
  }

  // from: exclusive. to: inclusive
  public Integer[] subArray(int from, int to) {
    Integer[] subArr = new Integer[to - from];
    int subArrIndex = 0;
    for (Integer i = 0; i < this.array.length; i++) {
      if (i > from && i <= to) {
        subArr[subArrIndex] = this.array[i];
        subArrIndex++;
      }
    }
    return subArr;
  }

  // reverse
  public void reverse() {
    // start at the beginning
    // i = 0 j = end
    // got to the middle and flip each index along the way
    // trim away the excess length?
    for (int i = 0, j = this.array.length - 1; i < this.array.length / 2; i++, j--) {
      int temp = this.array[i];
      this.array[i] = this.array[j];
      this.array[j] = temp;
      System.out.println("i: " + i + "  |  j: " + j);
    }
  }

  public void trimToSize() {
    Integer[] trimmedArr = new Integer[this.size];

    int trimIndex = 0;
    for (int i = 0; i < this.array.length; i++) {
      if (this.array[i] != null) {
        trimmedArr[trimIndex] = this.array[i];
        trimIndex++;
      }
    }

    this.array = trimmedArr;
  }

  public void sort() {
    // trim away nulls
    this.trimToSize();
    this.quicksort(this.array, 0, this.array.length - 1);
  }

  private void quicksort(Integer[] arr, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(arr, low, high);
      quicksort(arr, low, pivotIndex);
      quicksort(arr, pivotIndex + 1, high);
    }
  }

  private int partition(Integer[] arr, int low, int high) {
    int pivotIndex = low + (int) (Math.random() * (high - low + 1));
    int pivot = arr[pivotIndex];
    swap(arr, pivotIndex, high);
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (arr[j] <= pivot) {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, high);

    return i + 1;
  }

  private void swap(Integer[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void quack() {
    // trim away nulls
    this.trimToSize();
    this.array = this.quacksort(this.array);
  }

  private Integer[] quacksort(Integer[] arr) {
    if (arr.length <= 1) {
      return arr;
    }

    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    int pivotIndex = (int) (Math.random() * arr.length);
    int pivot = arr[pivotIndex];

    for (int i = 0; i < arr.length; i++) {
      if (i == pivotIndex)
        continue; // skip the pivot element

      if (arr[i] < pivot) {
        left.add(arr[i]);
      } else {
        right.add(arr[i]);
      }
    }

    Integer[] sortedLeft = quacksort(left.toArray(new Integer[0]));
    Integer[] sortedRight = quacksort(right.toArray(new Integer[0]));

    return combine(sortedLeft, sortedRight, pivot);
  }

  private Integer[] combine(Integer[] left, Integer[] right, Integer pivot) {
    Integer[] combined = new Integer[left.length + right.length + 1];
    System.arraycopy(left, 0, combined, 0, left.length);
    combined[left.length] = pivot;
    System.arraycopy(right, 0, combined, left.length + 1, right.length);
    return combined;
  }

  private void checkBoundary(int index) {
    if (index >= this.array.length || index < 0) {
      throw new IndexOutOfBoundsException("you're outta bounds!");
    }
  }
}
