/**
 * Robot class used to navigate the grid, creates a robot object with a position and orientation on a grid
 * object and reads the input to move accordingly
 * 
 * @Christopher Chrysostomou 
 * @version 3
 */
import java.awt.Point;
import java.util.ArrayList;
public class Robot {
 // instance variables
 private int positionx;
 private int positiony;
 private String orientation;
 private Point position;
 private Grid grid;
 private boolean test;
 ArrayList<String> outputs = new ArrayList < String > ();
 /**
  * Constructor for objects of class Rover
  */
 public Robot(int x, int y, String o, Grid g) {
  // initialise instance variables
  positionx = x;  
  positiony = y;
  orientation = o;
  grid = g;
  test = true;
  

 }

 /**
  * An example of a method - replace this comment with your own
  * 
  * @param  y   a sample parameter for a method
  * @return     the sum of x and y 
  */
 public void read(String s) {
  
  for (int index = 0; index < s.length(); index++) {
   char c = s.charAt(index);

   if (c == 'L' || c == 'l') {
    Left();

   } else if (c == 'R' || c == 'r') {
    Right();

   } else if (c == 'F' || c == 'f') {
    if (Forward() == false) {
    test = false;
    break;
    }

   } else {
    System.out.println("invalid direction in string");
   }

  }
  setPositionx(getPositionx()-1);
  setPositiony(getPositiony()-1);
  output();
 }

 public void Right() {
  switch (orientation) { //if facing case then go orientation
   case "W":
    orientation = "N";
    break;
   case "N":
    orientation = "E";
    break;
   case "E":
    orientation = "S";
    break;
   case "S":
    orientation = "W";
    break;
    default:
    System.out.println("Invalid direction in string");
    break;

  }
 }
 public void Left() {
  switch (orientation) {
   case "N":
    orientation = "W";
    break;
   case "E":
    orientation = "N";
    break;
   case "S":
    orientation = "E";
    break;
   case "W":
    orientation = "S";
    break;
   default:
    System.out.println("Invalid direction in string");
    break;
  }
 }
 public boolean Forward() { //while (!return isnt false)
    // grid.gettempPositionx();
  //positiony = y;
  int result;
  switch (orientation) {
   case "N"://System.out.println(grid.canMove(positionx, positiony + 1));
    result = grid.canMove(positionx, positiony + 1);
    if (result == 1) {
     positiony += 1;
     return true;
    } else if (result == 0) {
     return true;
    } else {
     return false; //robot has fallen off and been destroyed
    }
   case "S"://System.out.println(grid.canMove(positionx, positiony - 1));
    result = grid.canMove(positionx, positiony - 1);
    if (result == 1) {
     positiony -= 1;
     return true;
    } else if (result == 0) {
     return true;
    } else {
     return false; //robot has fallen off and been destroyed
    }
   case "E"://System.out.println(grid.canMove(positionx + 1, positiony));
   result = grid.canMove(positionx + 1, positiony);
    if (result == 1) {
     positionx += 1;
     return true;
    } else if (result == 0) {
     return true;
    } else {
     return false; //robot has fallen off and been destroyed
    }
   case "W"://System.out.println(grid.canMove(positionx -1, positiony));
   result = grid.canMove(positionx - 1, positiony);
    if (result == 1) {
     positionx -= 1;
     return true;
    } else if (result == 0) {
     return true;
    } else {
     return false; //robot has fallen off and been destroyed
    }
    //break;
    //can add cases like NW and positionx=1, positiony+1)
  }
  return false; //robot not destoryed move onto next char
 }
 public String output() {
    // positionx = positionx -1;
     //positiony = positiony -1;
     test = getTest();
   if (test == false) {
    //outputs.add(positionx + " " + positiony + " " + orientation + " LOST");
    return (positionx + " " + positiony + " " + orientation + " LOST");
   } else {
    //outputs.add(positionx + " " + positiony + " " + orientation);
    return (positionx + " " + positiony + " " + orientation);
   }
  }
   public void setPositionx(int x){
     positionx = x;
    }
    public void setPositiony(int y){
        positiony = y;
    }
 public void setOrientation(String o){
     orientation = o;
    }
  public int getPositionx(){
    return positionx;
    }
    public int getPositiony(){
        return positiony;
    }
 public String getOrientation(){
     return orientation;
    }
    public void setTest(boolean t){
        test = false;
    }
    public boolean getTest(){
        return test;
    }
    public ArrayList<String> getOutputs(){
        return outputs;
    }
     /*public void setstartX(int sx){
     startX = mx;
    }
     public void setstartY(int sy){
     startY = my;
    }*/


  /*
   * 
   * 
   * /
   */
}