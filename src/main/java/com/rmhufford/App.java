package com.rmhufford;

import com.rmhufford.MyArray;

public class App {
  public static void main(String[] args) {
    MyArray arr = new MyArray(6);
    arr.append(0);
    arr.append(3);
    arr.append(19);
    arr.append(2);
    arr.append(1);
    arr.append(7);

    arr.quack();

    System.out.println(arr.print("all"));

  }
}
