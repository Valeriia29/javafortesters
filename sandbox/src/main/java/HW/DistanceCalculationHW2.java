package HW;

import java.util.logging.SocketHandler;

public class DistanceCalculationHW2 {
  public static void main(String[] args) {
    Point p1 = new Point(-1,0);
    Point p2 = new Point(5,0);
    distance(p1,p2);
    System.out.println("The distance between two points is " + distance(p1,p2));
  }
  public static double distance(Point p1, Point p2){
   return Math.sqrt(Math.pow((p2.x-p1.x),2)+Math.pow((p2.y-p1.y),2));

  }


}
