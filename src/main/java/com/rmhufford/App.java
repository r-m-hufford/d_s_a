package com.rmhufford;

import com.rmhufford.MyArray;

public class App {
  public static void main(String[] args) {
    MyArray arr = new MyArray(10);
    arr.append(0);
    arr.append(1);
    arr.append(2);
    arr.append(3);
    arr.append(4);
    arr.append(5);
    arr.append(6);
    arr.append(7);
    arr.append(8);
    arr.append(9);
    System.out.println(arr.print("all"));

    Integer[] subArr = arr.subArray(2, 5);

    for (int i = 0; i < subArr.length; i++) {
      System.out.println(subArr[i]);
    }
  }
}
