package com.rmhufford;

import com.rmhufford.MyArray;

public class App {
  public static void main(String[] args) {
    MyArray arr = new MyArray(7);
    System.out.println(arr.print("all"));

    arr.append(0);
    System.out.println(arr.print("all"));
  }
}
