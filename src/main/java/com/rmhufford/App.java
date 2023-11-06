package com.rmhufford;

import com.rmhufford.MyArray;

public class App {
  public static void main(String[] args) {
    MyArray arr = new MyArray(7);
    arr.setElement(1, 1);
    arr.setElement(3, 3);
    arr.setElement(5, 5);

    System.out.println(arr.print("all"));
  }
}
