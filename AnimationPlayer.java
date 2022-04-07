package Final;

// imports required for the classes
import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javax.swing.JOptionPane;
 

public class AnimationPlayer{
 
    // create an array of Shape objects filled with null 
    static Shape[] shapes = {null, null, null};
    static String[] C1Effect = {null, null, null, null, null};
    static String[] R1Effect = {null, null, null, null, null, null};
    static String[] L1Effect = {null, null, null, null};      //create arrays for the effects for each shape of circle, rectangle and line

    // initializing static variables 
    static int frames; 
    static int speed; 
    static int elements;
    static boolean flag = true;       
    static int circleCount = 0;     ////////////////////
    static int countRectangle = 0;  // create a counter for each shape of circle, rectangle and line
    static int lineCount = 0;       ////////////////////    
    static int count = 0;  // set the counter to 0

 /*
 * @method 
 * method that reads the file and put into allocated variables 
 */
 public static void readFile(){
 /*
 * Try statement with a catch exception
 */
 try{
 // create a buffer reader and open the txt file
 FileReader fr = new FileReader("input.txt");
 BufferedReader br = new BufferedReader(fr);
 
 // if the counter equals 0 
 if (count == 0){
 // read the frames, speed and number of elements from the txt file
 frames = Integer.parseInt(br.readLine());
 speed = Integer.parseInt(br.readLine());
 elements = Integer.parseInt(br.readLine());
 }
 
 // a for loop for the number of elements in the txt file
 for (int i=0; i<elements; i++){
 br.readLine(); // read the blank line 
 String shapetype = br.readLine(); // get the type of the shape
 
 if (shapetype.equals("Circle")){  // if the type is a circle 
    Circle circle = new Circle();                            //create a circle shape
    circle.setRadius(getInt(br.readLine()));                 //set the radius and x and y position 
    circle.setCenterX(getInt(br.readLine()));                //set the color and the border width 
    circle.setCenterY(getInt(br.readLine()));                //set the color of the border 
    String[] rgb = br.readLine().split(",");                 //add the circle to the shape array
    Color color = Color.rgb(getInt(rgb[0]), getInt(rgb[1]), getInt(rgb[2]));
    circle.setFill(color);
    circle.setStrokeWidth(getInt(br.readLine()));
    String[] rgb2 = br.readLine().split(",");
    Color color2 = Color.rgb(getInt(rgb2[0]), getInt(rgb2[1]), getInt(rgb2[2]));
    circle.setStroke(color2);
    shapes[count++] = circle;
    br.readLine(); //effects introduced
 
 /**
 * read the effects and add the data to the array for circle Effects
 */
 String effectTypec1 = br.readLine();
 if(effectTypec1.equals("Show")){ // if the effect is of type show 
    C1Effect[circleCount++] = "Show";
    C1Effect[circleCount++] = br.readLine();
 }
 
 else if(effectTypec1.equals("Hide")){ // if the effect is of type hide 
    C1Effect[circleCount++] = "Hide";
    C1Effect[circleCount++] = br.readLine(); 
 }

 else if(effectTypec1.equals("Jump")){  // if the effect is of type jump 
    C1Effect[circleCount++] = "Jump";
    C1Effect[circleCount++] = br.readLine();
    C1Effect[circleCount++] = br.readLine();
 }

 else if(effectTypec1.equals("changeColor")){ // if the effect is of type changeColor
    C1Effect[circleCount++] = "changeColor";
    C1Effect[circleCount++] = br.readLine();
    C1Effect[circleCount++] = br.readLine();
 }
 else{
 break;
 }
 String effectTypec2 = br.readLine();
 
 if(effectTypec2.equals("Show")){ // if the effect is of type show 
    C1Effect[circleCount++] = "Show";
    C1Effect[circleCount++] = br.readLine();
 }
 
 else if(effectTypec2.equals("Hide")){ // if the effect is of type hide
    C1Effect[circleCount++] = "Hide";
    C1Effect[circleCount++] = br.readLine(); 
 }
 
 else if(effectTypec2.equals("Jump")){ // if the effect is of type jump 
    C1Effect[circleCount++] = "Jump";
    C1Effect[circleCount++] = br.readLine();
    C1Effect[circleCount++] = br.readLine();
 }
 
 else if(effectTypec2.equals("changeColor")){ // if the effect of type change color 
    C1Effect[circleCount++] = "changeColor";
    C1Effect[circleCount++] = br.readLine();
    C1Effect[circleCount++] = br.readLine();
 }
 
 else{ // else then it will break out of the loop 
 break;
 } 
 }
 
 else if (shapetype.equals("Rectangle")){ //if type rectangle
    Rectangle rectangle = new Rectangle();             //if the shape type is a rectangle 
    rectangle.setX(getInt(br.readLine()));             //create a rectangle shape 
    rectangle.setY(getInt(br.readLine()));             //set the x and y position 
    rectangle.setWidth(getInt(br.readLine()));         //set the width and length of the rectangle 
    rectangle.setHeight(getInt(br.readLine()));

    String[] rgb = br.readLine().split(",");  // split the integers and add to rgb array 
    Color color = Color.rgb(getInt(rgb[0]), getInt(rgb[1]), getInt(rgb[2]));

    rectangle.setFill(color);  // set the fill color of the rectangle 
    rectangle.setStrokeWidth(getInt(br.readLine())); //set border width
 
    String[] rgb2 = br.readLine().split(","); // split the integers and add to the rgb2 array 
    Color color2 = Color.rgb(getInt(rgb2[0]), getInt(rgb2[1]), getInt(rgb2[2]));
    rectangle.setStroke(color2); //set border color
 
    shapes[count++] = rectangle; // add the rectangle to the shapes array 
    br.readLine();   // introduce the effects 
    /*
    - get the effect type and add to the rectangleEffects array 
    - check for the show effect 
    - check for the hide effect 
    - check for the jump effect 
    - check for the change color effect 
    */
 String effectTyper1 = br.readLine();
 if(effectTyper1.equals("Show")){ // if the effect is of type show 
    R1Effect[countRectangle++] = "Show";
    R1Effect[countRectangle++] = br.readLine();
 }
 
 else if(effectTyper1.equals("Hide")){ // if the effect is of type hide 
    R1Effect[countRectangle++] = "Hide";
    R1Effect[countRectangle++] = br.readLine(); 
 }

 else if(effectTyper1.equals("Jump")){  // if the effect is of type jump 
    R1Effect[countRectangle++] = "Jump";
    R1Effect[countRectangle++] = br.readLine();
    R1Effect[countRectangle++] = br.readLine();
 }
 
 else if(effectTyper1.equals("changeColor")){ // if the effect is of type change color 
    R1Effect[countRectangle++] = "changeColor";
    R1Effect[countRectangle++] = br.readLine();
    R1Effect[countRectangle++] = br.readLine();
 }
 else{
 break;
 }
 /*
 - get the effect type and add to the rectangleEffects array 
 - check for the show effect 
 - check for the hide effect 
 - check for the jump effect 
 - check for the change color effect 
 */
 String effectTyper2 = br.readLine();
 if(effectTyper2.equals("Show")){  // if the effect is of type show 
    R1Effect[countRectangle++] = "Show";
    R1Effect[countRectangle++] = br.readLine();
 }

 else if(effectTyper2.equals("Hide")){ // if the effect is of type hide 
    R1Effect[countRectangle++] = "Hide";
    R1Effect[countRectangle++] = br.readLine(); 
 }
 
 else if(effectTyper2.equals("Jump")){ // if the effect is of type jump
    R1Effect[countRectangle++] = "Jump";
    R1Effect[countRectangle++] = br.readLine();
    R1Effect[countRectangle++] = br.readLine();
    R1Effect[countRectangle++] = br.readLine();
 }
 
 else if(effectTyper2.equals("changeColor")){ // if the effect is of type changeColor 
    R1Effect[countRectangle++] = "changeColor";
    R1Effect[countRectangle++] = br.readLine();
    R1Effect[countRectangle++] = br.readLine();
 }
 
 else{ // else it will break out of the loop
 break;
 }
 }
 else if (shapetype.equals("Line")){ //if type line
    Line line = new Line();                        //create a line shape 
    line.setStartX(getInt(br.readLine()));         //read the x and y position 
    line.setStartY(getInt(br.readLine()));         //read the end x and y position v
    line.setEndX(getInt(br.readLine()));           //get the border width 
    line.setEndY(getInt(br.readLine()));           //get the color of the line and add to the rgb array 
    line.setStrokeWidth(getInt(br.readLine()));    //set the border color
    String[] rgb = br.readLine().split(",");
    Color color = Color.rgb(getInt(rgb[0]), getInt(rgb[1]), getInt(rgb[2]));
    line.setStroke(color);

    shapes[count++] = line;  // add the line to the shapes array 
    br.readLine();
    /*
    - get the effect type and add to the lineEffects array 
    - check for the show effect 
    - check for the hide effect 
    - check for the jump effect 
    - check for the change color effect 
    */
 String effectTypel1 = br.readLine();
 if(effectTypel1.equals("Show")){  // if the effect is a type show 
    L1Effect[lineCount++] = "Show";
    L1Effect[lineCount++] = br.readLine();
 }
 
 else if(effectTypel1.equals("Hide")){ // if the effect is a hide effect 
    L1Effect[lineCount++] = "Hide";
    L1Effect[lineCount++] = br.readLine(); 
 }
 
 else if(effectTypel1.equals("Jump")){ // if the effect is the jump effect 
    L1Effect[lineCount++] = "Jump";
    L1Effect[lineCount++] = br.readLine();
    L1Effect[lineCount++] = br.readLine();
 }
 
 else if(effectTypel1.equals("changeColor")){ // if the effect is the type of change color 
    L1Effect[lineCount++] = "changeColor";
    L1Effect[lineCount++] = br.readLine();
    L1Effect[lineCount++] = br.readLine();
 }
 else{ // else it will break out of the loop
 break;
 }
 /**
 * get the effect type and add to the lineEffects array 
 * check for the show effect 
 * check for the hide effect 
 * check for the jump effect 
 * check for the change color effect 
 */
 String effectTypel2 = br.readLine();
 
 if(effectTypel2.equals("Show")){ // if the effect is of type show 
    L1Effect[lineCount++] = "Show";
    L1Effect[lineCount++] = br.readLine();
 }

 else if(effectTypel2.equals("Hide")){  // if the effect is of type hide 
    L1Effect[lineCount++] = "Hide";
    L1Effect[lineCount++] = br.readLine(); 
 }

 else if(effectTypel2.equals("Jump")){  // if the effect is of type jump 
    L1Effect[lineCount++] = "Jump";
    L1Effect[lineCount++] = br.readLine();
    L1Effect[lineCount++] = br.readLine();
 }
 
 else if(effectTypel2.equals("changeColor")){ // if the effect is of type change color
    L1Effect[lineCount++] = "changeColor";
    L1Effect[lineCount++] = br.readLine();
    L1Effect[lineCount++] = br.readLine();
 }
 else{  // break out of the loop exception handling 
 break;
 }
 }
 // exception message using joption pane 
 else{
 JOptionPane.showMessageDialog(null, "Error!");
 }
 }
 }
 /**
 * exception handling 
 * if the input is incorrect it will catch the error
 */
 catch (IOException ioe){
 ioe.printStackTrace();
 }
 } 
 /*
 * 
 * @param s
 * @return n 
 * method to parse an integer 
 */
 static public int getInt(String s){
 int n = Integer.parseInt(s);
 return n; 
 }
}