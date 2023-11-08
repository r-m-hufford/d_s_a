package com.rmhufford;

import com.rmhufford.MyArray;

public class App {
  public static void main(String[] args) {
    MyArray arr = new MyArray(7);
    System.out.println(arr.print("all"));

    arr.setElement(2, 2);
    System.out.println(arr.print("all"));
  }
}
