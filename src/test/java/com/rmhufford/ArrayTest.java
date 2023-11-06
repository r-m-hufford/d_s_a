package com.rmhufford;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {
  private MyArray array;

  @Before
  public void setup() {
    array = new MyArray(5);
  }

  @Test
  public void testArraySet() {
    array.setElement(1, 5);

    Assert.assertEquals(5, array.getElement(1));
  }

  @Test
  public void testInsert() {
    array.insert(8, 4);

    Assert.assertEquals(4, array.getElement(8));
  }

}
