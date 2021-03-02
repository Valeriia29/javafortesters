package ru.stqa.pft.sandbox;

import hw.Point;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {

@Test
  public void testDistanceNull() {
    Point p1 = new Point(0,0);
    Point p2 = new Point(0,0);
    Assert.assertEquals(p1.distance(p2),0);
  }

@Test
  public void testDistanceByOneCoordinate() {
    Point p1 = new Point(0,5);
    Point p2 = new Point(0,0);
    Assert.assertEquals(p1.distance(p2),5);
  }

  @Test
  public void testDistanceByOnePoint() {
    Point p1 = new Point(7,5);
    Point p2 = new Point(0,0);
    Assert.assertEquals(p1.distance(p2),8.602325267042627);
  }

  @Test
  public void testDistanceByTwoPoints() {
    Point p1 = new Point(-6,4);
    Point p2 = new Point(5,-7);
    Assert.assertEquals(p1.distance(p2),15.556349186104045);
  }

}
