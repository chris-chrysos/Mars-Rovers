
PROJECT TITLE: Martian Robots
AUTHOR: Christopher Chrysostomou
PURPOSE OF PROJECT: Report the final position of a robot that follows instructions to navigate mars.
26/01/2017 Version 1
HOW TO START THIS PROJECT: This project was created using the BlueJ IDE, and Java 8 JDK. An IDE is not necessary to run the
grid.java file, and other IDE's will work too, however if you wish to download both BlueJ and Java 8 JDK you may do so here: http://www.bluej.org/ .
Simply scroll down to your operating system, and select to download BlueJ with Java 8 JDK. Next navigate to your downloads folder
and open "bluej-bundled-317.msi" to open the BlueJ setup wizard, follow the instructions on screen, to fully install the program
and JDK. Once installed you may open the "package" project file located in the same directory as this file. Right click on the
rectangle that says "Grid" and select Compile, now right click "Grid" again and this time select void main(String[] args),
press ok, without changing the text. The program is now running.

USER INSTRUCTIONS:
For all input do not input any extra characters that are not listed here or the program will exit. "N" "E" "W" "F"
The first line of input will determine the x and y boundary of the grid, with a maximum value for either at 50. Please seperate
the values by a single space and do not include any other characters, e.g. "25 25". This will create one grid,if you want a new sized
grid enter "stop", at the second line of input.
The second line of input will stop the program if told to do so. If you wish to continue then input a starting x, y co-ordinate and
orientation seperated by a single space, e.g. "15 15 N" will set the robot at position (15,15) facing north.
The third line of input will determine how the robot moves on the grid. "F" will move the robot forward, "E" will change the orientation of the robot to east, "W" will change the orientation of the robot to west. These can be input all at once,
e.g. FFRLLLFRWWF. Please do not leave any spaces between each character, or exceed 100 characters of instructions.
After the third line, you will be prompted with the second line of input again, this is because you are now instructing a different robot to navigate the planet. Once you are satisfied with how many robots you have, input "stop", as instructed above.
This will then print out the final position, orientation and whether or not they were lost for each robot. With robot 1 being the left most string, and robot 3 being the right most.

EXAMPLE RUN:
INPUT:
5 3
1 1 E
RFRFRFRF
3 2 N
FRRFLLFFRRFLL
0 3 W
LLFFFLFLFL
stop
OUTPUT:
[1 1 E, 3 3 N LOST, 2 3 S]

FUTURE UPDATES: 
Add a south method so the user can change from north facing to south facing.
Stop the program closing on incorrect input and instead re-prompt you for another line.
