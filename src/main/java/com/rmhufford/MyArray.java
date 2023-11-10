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

  public Integer[] getArray() {
    return this.array;
  }

  public void insert(int index, int value) {
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

  public int size() {
    // i.e. number of non null elements
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
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
    return findValue(value, false) != -1;
  }

  public int indexOf(Integer value) {
    return findValue(value, false);
  }

  public int lastIndexOf(Integer value) {
    return findValue(value, true);
  }

  private int findValue(Integer value, boolean findLast) {
    int foundIndex = -1;
    for (Integer i = 0; i < this.array.length; i++) {
      if (this.array[i] == value) {
        foundIndex = i;
        if (!findLast) {
          break;
        }
      }
    }
    return foundIndex;

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
  public MyArray subArray(int from, int to) {
    MyArray subArr = new MyArray(to - from);
    for (int i = from; i < to; i++) {
      subArr.append(this.array[i]);
    }
    return subArr;
  }

  public void reverse() {
    for (int i = 0, j = this.array.length - 1; i < this.array.length / 2; i++, j--) {
      int temp = this.array[i];
      this.array[i] = this.array[j];
      this.array[j] = temp;
    }
  }

  public void resize() {
    Integer[] newArr = new Integer[this.size * 2];
    for (int i = 0; i < this.size; i++) {
      newArr[i] = this.array[i];
    }
    this.array = newArr;
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
    size = size - (size - trimIndex);
  }

  public void sort() {
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
