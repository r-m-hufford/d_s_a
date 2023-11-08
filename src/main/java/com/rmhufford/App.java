package com.rmhufford;

import com.rmhufford.MyArray;

public class App {
  public static void main(String[] args) {
    MyArray arr = new MyArray(7);
    arr.append(2);
    int indexOf = arr.indexOf(2);
    System.out.println(indexOf);
    System.out.println(arr.print("all"));
  }
}
