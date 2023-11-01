package com.rmhufford;

import com.rmhufford.LinkedList;

public class App {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.insertAt(0, 1);
    list.insertAt(0, 2);
    list.insertAt(1, 3);

    System.out.println(list.toString());
  }
}
