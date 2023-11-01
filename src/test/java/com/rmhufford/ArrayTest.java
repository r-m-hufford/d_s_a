package com.rmhufford;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
    array.set(1, 5);

    Assert.assertEquals(5, array.get(1));
  }
}
