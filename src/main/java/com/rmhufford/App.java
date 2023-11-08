package com.rmhufford;

import com.rmhufford.MyArray;

public class App {
  public static void main(String[] args) {
    MyArray arr = new MyArray(10);
    arr.append(1);
    arr.append(2);
    arr.append(3);
    arr.setElement(5, 5);

    System.out.println(arr.print("all"));

    arr.trimToSize();
    System.out.println(arr.print("all"));

  }
}
