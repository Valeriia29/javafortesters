package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

  @Test
  public void testArea() {
    Square a = new Square(5);
    Assert.assertEquals(a.area(),25);
  }
}
