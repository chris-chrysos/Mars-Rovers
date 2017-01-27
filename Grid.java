import java.util.Scanner;
import java.awt.Point;
import java.util.ArrayList;
/**
 * Grid class used to create a grid object the robot class can use to navigate. Creates a padding
 * around the grid, e.g. 5x5 becomes 7x7 where 1,1 will be the equivalent of 0,0. 
 * 
 * @Christopher Chrysostomou 
 * @version 3
 */
public class Grid {
 // instance variables 
 private int x;
 private int minX;
 private int maxX;
 private int minY;
 private int maxY;
 private int startX;
 private int startY;
 private String s;
 private int[][] grids;
  private int[][] boundaries;
 private String startingOrientation;
 private int tempPositionx;
 private int tempPositiony;
 ArrayList<String> outputList= new ArrayList < String > ();
 public Grid() {
  // initialise instance variables
  grids = grids;
  
  x = 0;
  minX = 1;
  minY = 1;
  maxX = 51;
  maxY = 51;
  startX = 0;
  startY = 0;
  s = "";
   boundaries = new int[maxX+2][maxY+2];
  for (int x = 0; x < maxX+2; x++) {
   for (int y = 0; y < maxY+2; y++) {
    boundaries[x][y] = 0;
   }
  }
 }
 public static void main(String[] args) {
  new Grid().start();
}

 public int canMove(int x, int y) {
    if (x <= maxX && y <= maxY && x >= minX && y >= minY) {
        return 1;
    }//if within boundaries move
         if (getBoundary(x,y) == 1) {
    //System.out.println("You detect a scent from a former rover");
    return 0;
} 
    else if (x > maxX) {
    setBoundary(maxX+1, y);
    return 2; //can move but destroys robot
   }
   else if (x < minX) {
    setBoundary(minX-1, y);
    return 2;
   }
   else if (y > maxY) {
    setBoundary(x, maxY+1);
    return 2;
   }
   else if (y < minY) {
    setBoundary(x, minY-1);
    return 2; //kill robot then break and go to next one
   }


   //invalid
   return 0;
  }

 public void setBoundary(int x, int y) {
  //System.out.println("SETTING BOUNDARY AT (" + x + "," +y +")");
  boundaries[x][y] = 1;
 }
 public int getBoundary(int x,int y){
     return boundaries[x][y];
    }
 public int[][] gridSize( String dimensions ) {

  if (dimensions.length() >= 3) {
      int input[] = readInputGridSize(dimensions);
      if(input[0] <= 50){
   setmaxX(input[0]);  
}
else {
System.out.println("x co-ordinate too large, maximum is 50");
System.exit(0);
}
if(input[1] <= 50){
 setmaxY(input[1]);
}
else {
System.out.println("Y co-ordinate too large, maximum is 50");
System.exit(0);
}

  } else if (dimensions.length() >= 4) {
   System.out.println("input size too large");
System.exit(0);
  } else if (dimensions.length() >= 2) {
   System.out.println("input size too small");
  System.exit(0); 
  }
  grids = new int[maxX+2][maxY+2];
  for (int x = 0; x < maxX+2; x++) {
   for (int y = 0; y < maxY+2; y++) {
    grids[x][y] = 0;
   }
  }//5x5 input is now 7z7, 1,1 6,6 boundary
  maxX = maxX+1;
  maxY = maxY+1;
  //maxX may be 5 but now 6 this is the boundary now, falls off at 7

  return grids;
 }
 public void startingPos(String dimensions) {
  if (dimensions.length() >= 5) {
   //setstartX(Character.getNumericValue(dimensions.charAt(0)));
   //setstartY(Character.getNumericValue(dimensions.charAt(2)));
   char temp = dimensions.charAt(dimensions.length() -1);
   char tempUpper = Character.toUpperCase(temp);
   setStartingOrientation(String.valueOf(tempUpper));
int input[] = readInputStartingPos(dimensions);
   tempPositionx = input[0] + 1;
   tempPositiony = input[1] + 1;
   if(tempPositionx > maxX ||  tempPositiony > maxY || tempPositionx < minX || tempPositiony < minY)
{
System.out.println("Can not start outside of the grid");
System.exit(0);
}
   //tempPositionx = Character.getNumericValue(dimensions.charAt(0)+1);
   //tempPositiony = Character.getNumericValue(dimensions.charAt(2)+1);
   //starting at 0,0 is now 1,1
   startingOrientation = getStartingOrientation();

  } else if (dimensions.length() <= 4) {
   System.out.println("input length too small, please enter an X value, a Y value, and an orientation, seperated by spaces, e.g. 2 3 N");
System.exit(0);
}

 }
     public void start(){
      System.out.println("Enter the dimensions of the grid: ");
      Scanner scanner = new Scanner(System.in);
      String dimensions = scanner.nextLine();
      grids = gridSize(dimensions);

      while(true){//forever run until stop can limit how many robots with for statement
             
      System.out.println("Enter a starting position and orientation, or stop to exit: ");
      String spo = scanner.nextLine();
      if(spo.equalsIgnoreCase("stop")){break;};//stop at stop
   
      startingPos(spo);
    
      Robot robot = new Robot(tempPositionx, tempPositiony,startingOrientation, this);
      System.out.println("Enter a string of instructions: ");
      String instructions = scanner.nextLine();
      if (instructions.length() < 100) {
      robot.read(instructions);
      outputList.add(robot.output());
      //System.out.println(outputList);
      } 
      else {
       System.out.println("Input size too large, please try again");
       System.exit(0);
      }
    }
    System.out.println(outputList);
    
}
public int[] readInputStartingPos (String input){
String[] seperators = {"(", ")", ",", ";"};
String text = input;
for (String replace : seperators) {
    text = text.replace(replace, " ").trim();
}
// This replaces any multiple spaces with a single space
while (text.contains("  ")) {
    text = text.replace("  ", " ");
}
String[] values = text.split(" ");
int[] iValues = new int[values.length];
for (int index = 0; index < values.length-1; index++) {//reads 1 less otherwise would read orientation

    String sValue = values[index];
    iValues[index] = Integer.parseInt(values[index].trim());

}
return iValues;
}
public int[] readInputGridSize (String input){
String[] seperators = {"(", ")", ",", ";"};
String text = input;
for (String replace : seperators) {
    text = text.replace(replace, " ").trim();
}
// This replaces any multiple spaces with a single space
while (text.contains("  ")) {
    text = text.replace("  ", " ");
}
String[] values = text.split(" ");
int[] iValues = new int[values.length];
for (int index = 0; index < values.length; index++) {

    String sValue = values[index];
    iValues[index] = Integer.parseInt(values[index].trim());

}
return iValues;
    }
    public void setmaxX(int mx){
     maxX = mx;
    }
    public void setmaxY(int my){
     maxY = my;
    }
     public void setstartX(int sx){
     startX = sx;
    }
     public void setstartY(int sy){
     startY = sy;
    }
     public void setStartingOrientation(String s){
     startingOrientation = s;
    }
    public void settempPositionx(int x){
        tempPositionx = x;
    }
    public void settempPositiony(int y){
      tempPositiony = y;
    }
    public int gettempPositionx(){
     return tempPositionx;
    }
    public int gettempPositiony(){
     return tempPositiony;
    }
    public int getmaxX(){
     return maxX;
    }
    public int getmaxY(){
     return maxY;
    }
     public int getstartX(){
     return startX;
    }
     public int getstartY(){
     return startY;
    }
    public String getStartingOrientation(){
        return startingOrientation;
    }
}

