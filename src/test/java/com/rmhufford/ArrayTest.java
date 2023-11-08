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
  public void testInsert() {
    array.insert(2, 4);

    Assert.assertEquals(4, array.getElement(2));
  }

}
